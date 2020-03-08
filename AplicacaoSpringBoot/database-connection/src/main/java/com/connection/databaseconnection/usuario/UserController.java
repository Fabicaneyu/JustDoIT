package com.connection.databaseconnection.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Controller
public class UserController {

    @RequestMapping("/")
    public String index(){
        return "login";
    }

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
