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
        return "redirect:login";

    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String indexLogin(){
        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String indexLogin(Usuario usuario){

        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        boolean validado = controller.validaAll(email, senha);

        if (validado) {
            return "redirect:home";
        }
        else {
            return "redirect:fail";
        }

    }

    @RequestMapping(value="logoff", method = RequestMethod.GET)
    public String indexLogoff() {
        usuarioAtual = null;
        return "login";
    }

    @RequestMapping(value="fail", method = RequestMethod.GET)
    public String indexFail() {

        return "fail";
    }

    @RequestMapping(value="sucess", method = RequestMethod.GET)
    public String indexSucess() {

        return "sucess";
    }

    @RequestMapping(value="home", method = RequestMethod.GET)
    public String indexHome() {

        return "home";
    }


}
