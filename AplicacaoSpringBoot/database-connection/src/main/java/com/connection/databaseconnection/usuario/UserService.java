package com.connection.databaseconnection.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository repository;

    public UserService(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        repository.save(usuario);
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
