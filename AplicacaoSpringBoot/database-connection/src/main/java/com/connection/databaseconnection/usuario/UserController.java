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
    @RequestMapping(value="login", method = RequestMethod.GET)
    public String index(){
        return "login";
    }
    @RequestMapping(value="login", method = RequestMethod.POST)
    public String index(Usuario usuario){
        repository.save(usuario);
        return "redirect:login";
    }




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
