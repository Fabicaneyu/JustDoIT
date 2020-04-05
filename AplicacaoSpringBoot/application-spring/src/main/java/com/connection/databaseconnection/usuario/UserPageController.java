package com.connection.databaseconnection.usuario;

import com.connection.databaseconnection.dto.UsuarioDTO;
import com.connection.databaseconnection.exception.ErroAutenticacao;
import com.connection.databaseconnection.exception.ErroConexao;
import com.connection.databaseconnection.exception.RegraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;

@Service
@Controller
@RestController
@RequestMapping("/user")
public class UserPageController {

    private Usuario usuarioAtual = null;

    @Autowired
    private UserService controller;

    public  UserPageController(UserService controller) {
        this.controller = controller;
    }

    @PostMapping("/login")
    public ResponseEntity logar(@RequestBody UsuarioDTO userDTO) {
        try {
            Usuario usuarioAutenticado = controller.autenticar(userDTO.getEmail(), userDTO.getSenha());
            usuarioAtual = usuarioAutenticado;
            return ResponseEntity.ok(usuarioAutenticado);
        }catch (ErroAutenticacao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/logoff")
    public ResponseEntity deslogar() {
        try{
            usuarioAtual = null;
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        }catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @GetMapping("/photo")
        public ResponseEntity getPhoto(){

        try{
           String result = controller.buscarPhoto("cassio");

           return new ResponseEntity(result,HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
           }

    }

//    @GetMapping("/name")
//    public ResponseEntity exibeDadosUsuario() {
//        try{
//            return ResponseEntity.ok(usuarioAtual.getNome());
//        }catch (ErroConexao e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastrar(@RequestBody  UsuarioDTO userDTO) {

        Usuario usuario = Usuario.builder()
                .nome(userDTO.getNome())
                .email(userDTO.getEmail()).photo(userDTO.getPhoto()).senha(userDTO.getSenha()).build();


        try{
            Usuario usuarioSalvo = controller.salvarUsuario(usuario);
            return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
        }catch (RegraException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


//    @RequestMapping(value="cadastro", method = RequestMethod.GET)
//    public String indexCadastrar(){
//        return "cadastro";
//    }
//
//    @RequestMapping(value="cadastro", method = RequestMethod.POST)
//    public String indexCadastrar(Usuario usuario){
//
//        controller.salvarUsuario(usuario);
//        return "redirect:login";
//
//    }
//
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
//        boolean validado = controller.autenticar(email, senha);
//
//        if (validado) {
//            usuarioAtual = usuario;
//            return "redirect:home";
//        }
//        else {
//            return "redirect:fail";
//        }
//
//    }
//
//    @RequestMapping(value="logoff", method = RequestMethod.GET)
//    public String indexLogoff() {
//        usuarioAtual = null;
//        return "login";
//    }
//
//    @RequestMapping(value="fail", method = RequestMethod.GET)
//    public String indexFail() {
//
//        return "fail";
//    }
//
//    @RequestMapping(value="sucess", method = RequestMethod.GET)
//    public String indexSucess() {
//
//        return "sucess";
//    }
//
//    @RequestMapping(value="home", method = RequestMethod.GET)
//    public String indexHome() {
//
//        return "home";
//    }


}
