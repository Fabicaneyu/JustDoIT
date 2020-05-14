package com.connection.databaseconnection.usuario;

import com.connection.databaseconnection.associative.conhecimento.ConhecimentoUsuario;
import com.connection.databaseconnection.associative.conhecimento.ConhecimentoUsuarioRepository;
import com.connection.databaseconnection.conhecimento.Conhecimento;
import com.connection.databaseconnection.conhecimento.ConhecimentoRepository;
import com.connection.databaseconnection.dto.BuscaDTO;
import com.connection.databaseconnection.dto.UsuarioViewDTO;
import com.connection.databaseconnection.exception.ErroAutenticacao;
import com.connection.databaseconnection.exception.RegraException;
import com.connection.databaseconnection.exception.UserNotFoundException;

import com.connection.databaseconnection.iterators.BuscaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BuscaBuilder buscaBuilder;

    @Autowired
    private ConhecimentoRepository conhecimentoRepository;

    @Autowired
    ConhecimentoUsuarioRepository conhecimentoUsuarioRepository;

    @Autowired
    private EntityManager entityManager;

    public UserService(UserRepository repository) {
        super();
        this.repository = repository;
    }

    public Usuario buscaporId(Long id) {

        Optional<Usuario> result = this.repository.findById(id);

        if(result.isPresent()) {
            return result.get();
        }
        else {
            return null;
        }

    }

    public Optional<Usuario> buscaporIdOptional(Long id) {

        Optional<Usuario> result = this.repository.findById(id);

        if(result.isPresent()) {
            return result;
        }
        else {
            return null;
        }

    }

    @Transactional
    public Usuario saveUser(Usuario user) {
        verifyNewEmail(user.getEmail());
        repository.save(user);
        return user;
    }


    public void verifyNewEmail(String email) {
        boolean existe = repository.existsByEmail(email);

        if (existe) {
            throw new RegraException("Já existe um usuário cadastrado com este e-mail!");
        }
    }



    public Usuario authentication(String email, String senha) {

        Usuario user = repository.findByEmail(email);

        if (user == null) {
            throw new ErroAutenticacao("Usuário não encontrado");
        }

        if (!user.getSenha().equals(senha)) {
            throw new ErroAutenticacao("Senha inválida");
        }

        return user;

    }

    @Transactional
    public void updateSobre(Usuario usuario) {

        repository.findById(usuario.getId())
                .map( user -> {
                    user.setSobre(usuario.getSobre());
                    return repository.save(user);
                }).orElseThrow(() -> new UserNotFoundException());

    }

    public List<BuscaDTO> buscarConhecimentos(String conhecimento) {

        List<Conhecimento> busca = conhecimentoRepository.findByKnow(conhecimento);

        List<ConhecimentoUsuario> novaBusca;

        if(busca.isEmpty()) {
            return null;
        }
        else {
            novaBusca = conhecimentoUsuarioRepository
                    .findByIdKnowId(busca.get(0).getId_conhecimento());
        }

        return buscaBuilder.nextList(novaBusca);
    }


    public UsuarioViewDTO buscaViewporId(long id) {

        Optional<Usuario> result = this.repository.findById(id);
        UsuarioViewDTO view ;

        if(result.isPresent()) {

            view = new UsuarioViewDTO
                    (result.get().getSobre(), result.get().getPhoto(), result.get().getId());

            return view;
        }
        else {
            return null;
        }

    }
}







