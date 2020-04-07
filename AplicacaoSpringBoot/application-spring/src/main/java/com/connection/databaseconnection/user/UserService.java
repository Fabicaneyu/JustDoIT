package com.connection.databaseconnection.user;

import com.connection.databaseconnection.exception.ErroAutenticacao;
import com.connection.databaseconnection.exception.RegraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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

    @Transactional
    public Usuario findPhoto(Long idUser){


        Usuario usuario = entityManager.find(Usuario.class, idUser);


        return usuario;
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


}







