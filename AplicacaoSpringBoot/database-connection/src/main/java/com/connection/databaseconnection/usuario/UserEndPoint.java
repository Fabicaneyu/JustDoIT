package com.connection.databaseconnection.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class UserEndPoint {

    @Autowired
    UserController controller;

    @GetMapping
    public String teste() {
        return "Teste";
    }


    @GetMapping("/autenticar/{email}/{pass}")
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
