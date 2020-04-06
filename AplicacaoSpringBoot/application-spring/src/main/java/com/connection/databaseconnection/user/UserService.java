package com.connection.databaseconnection.user;

import com.connection.databaseconnection.exception.ErroAutenticacao;
import com.connection.databaseconnection.exception.RegraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        super();
        this.repository = repository;
    }

    @Transactional
    public User saveUser(User user) {
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

    public String findPhoto(Integer id){
        User userFound = repository.findByIdUser(id);
        return userFound.getPhoto();
    }

    public User authentication(String email, String senha) {

        User user = repository.findByEmail(email);

        if (user == null) {
            throw new ErroAutenticacao("Usuário não encontrado");
        }

        if (!user.getSenha().equals(senha)) {
            throw new ErroAutenticacao("Senha inválida");
        }

        return user;

    }


}







