package com.connection.databaseconnection.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    String userAtual = null;

    @Autowired
    UserService controller;

    @Autowired
    UserPageController pageController;


    @PostMapping("/autenticar/{email}/{pass}")
    public String logar(@PathVariable("email") String email,
                      @PathVariable("pass") String pass ) {

       boolean validaEmail = controller.validarEmail(email);

       boolean validaSenha = controller.validarSenha(pass);

       if (validaEmail) {
           if (validaSenha) {
               return "Usuário autenticado";
           }
           else {
               return "Falha de autenticação";
           }
       }
       else {
           return "Falha de autenticação";
       }

    }



}
