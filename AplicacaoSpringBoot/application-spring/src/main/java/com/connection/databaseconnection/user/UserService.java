package com.connection.databaseconnection.user;

import com.connection.databaseconnection.exception.ErroAutenticacao;
import com.connection.databaseconnection.exception.RegraException;
import com.connection.databaseconnection.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

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


}







