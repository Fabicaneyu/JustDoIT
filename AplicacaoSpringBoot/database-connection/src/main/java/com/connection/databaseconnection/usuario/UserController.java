package com.connection.databaseconnection.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@Controller
public class UserController {

    @Autowired
    private UsuarioRepository repository;

    public UserController(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    @RequestMapping(value="cadastro", method = RequestMethod.GET)
    public String indexCadastrar(){
        return "cadastro";
    }
    @RequestMapping(value="cadastro", method = RequestMethod.POST)
    public String indexCadastrar(Usuario usuario){

        repository.save(usuario);
        return "login";

    }


    @RequestMapping(value="login", method = RequestMethod.GET)
    public String indexCadastro(){
        return "login";
    }
    @RequestMapping(value="login", method = RequestMethod.POST)
    public String indexCadastro(Usuario usuario){


        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        boolean e = validarEmail(email);
        boolean s = validarSenha(senha);

        if (e && s) {
            return "home";
        }
        else {
            return "falha";
        }


    }

//    @RequestMapping(value="login", method = RequestMethod.GET)
//    public String indexLogin(){
//        return "login";
//    }
//
//    @RequestMapping(value="login", method = RequestMethod.POST)
//    public String indexLogin(Usuario usuario){
//
//        String email = usuario.getEmail();
//        String senha = usuario.getSenha();
//
//        boolean e = validarEmail(email);
//        boolean s = validarSenha(senha);
//
//        if (e && s) {
//            return "redirect:home";
//        }
//        else {
//            return "Falha na autenticação";
//        }
//
//    }



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
