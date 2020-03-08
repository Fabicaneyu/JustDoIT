package com.connection.databaseconnection.usuario;

import org.springframework.stereotype.Service;

@Service
public class UserController {

    private UsuarioRepository repository;

    public UserController(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }


    public boolean validarEmail(String email) {


        boolean existe = repository.existsByEmail(email);

        if (existe) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean validarSenha(String senha) {


        boolean existe = repository.existsBySenha(senha);

        if (existe) {
            return true;
        }
        else {
            return false;
        }
    }


}
