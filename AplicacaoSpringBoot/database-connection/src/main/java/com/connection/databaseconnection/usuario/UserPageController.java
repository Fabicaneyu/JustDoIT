package com.connection.databaseconnection.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@Controller
public class UserPageController {

    private Usuario usuarioAtual = null;

    @Autowired
    UserService controller;

    @RequestMapping(value="cadastro", method = RequestMethod.GET)
    public String indexCadastrar(){
        return "cadastro";
    }

    @RequestMapping(value="cadastro", method = RequestMethod.POST)
    public String indexCadastrar(Usuario usuario){

        controller.salvarUsuario(usuario);
        return "login";

    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String indexLogin(){
        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String indexLogin(Usuario usuario){

        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        boolean e = controller.validarEmail(email);
        boolean s = controller.validarSenha(senha);

        if (e && s) {
            usuarioAtual = usuario;
            return "home";
        }
        else {
            return "falha";
        }


    }

    @RequestMapping(value="logoff", method = RequestMethod.GET)
    public String indexHome() {
        usuarioAtual = null;
        return "redirect:login";
    }


}
