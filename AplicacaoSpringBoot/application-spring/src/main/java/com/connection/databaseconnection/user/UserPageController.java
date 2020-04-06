package com.connection.databaseconnection.user;

import com.connection.databaseconnection.dto.UserDTO;
import com.connection.databaseconnection.exception.ErroAutenticacao;
import com.connection.databaseconnection.exception.ErroConexao;
import com.connection.databaseconnection.exception.RegraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Service
@Controller
@RestController
@RequestMapping("/user")
public class UserPageController {


    //Esse atributo vai armazenar o usuario atual
    private User currentUser = null;


    //Esse Atributo vai nos permitir utilizar os metodos da classe Service
    @Autowired
    private UserService controller;


    public  UserPageController(UserService controller) {

        this.controller = controller;
    }


        /*Esse end-point é resposavel pelo login, ele executa o
        metodo "authentication" que verifica o email e a senha no banco*/

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        try {
            User userAutenticado = controller.authentication(userDTO.getEmail(), userDTO.getSenha());
            currentUser = userAutenticado;
            return ResponseEntity.ok(userAutenticado);
        }catch (ErroAutenticacao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @GetMapping("/logoff")
    public ResponseEntity logoff() {
        try{
            currentUser = null;
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        }catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    //Em processo de correção
    @GetMapping("/photo/{id}")
        public ResponseEntity buscaPhoto(@PathParam("id") Integer id ){
        System.out.println(id);

        try{
           String result = controller.findPhoto(id);

           return new ResponseEntity(result,HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
           }

    }


    //Pega o json fornecido pelo front do tipo userDTO e cria um user do tipo User
    @PostMapping("/cadastro")
    public ResponseEntity cadastrar(@RequestBody UserDTO userDTO) {

        User user = User.builder()
                .nome(userDTO.getNome())
                .email(userDTO.getEmail()).photo(userDTO.getPhoto()).senha(userDTO.getSenha()).build();

        try{
            User userSalvo = controller.saveUser(user);
            return new ResponseEntity(userSalvo, HttpStatus.CREATED);
        }catch (RegraException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
