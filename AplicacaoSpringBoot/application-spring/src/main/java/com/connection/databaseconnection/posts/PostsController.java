package com.connection.databaseconnection.posts;

import com.connection.databaseconnection.dto.PostDTO;
import com.connection.databaseconnection.dto.UsuarioDTO;
import com.connection.databaseconnection.exception.ErroConexao;
import com.connection.databaseconnection.exception.RegraException;
import com.connection.databaseconnection.usuario.UserService;
import com.connection.databaseconnection.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Controller
@RestController
@RequestMapping("/post")
public class PostsController {

    @Autowired
    private PostsService controller;


    public  PostsController(PostsService controller) {
        this.controller = controller;
    }

    @Autowired
    private UserService userController;



    @PostMapping("/new")
    public ResponseEntity novoPost(@RequestBody PostDTO postDTO) {
        Posts post = Posts.builder().conteudo(postDTO.getConteudo())._data(postDTO.get_data())
                .id_usuario(postDTO.getId_usuario()).nome_user(postDTO.getNome_user()).build();
        try{
            Posts postEnviado = controller.novoPost(post);
            return new ResponseEntity(postEnviado, HttpStatus.CREATED);
        }catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @GetMapping("/load")
    public ResponseEntity loadPosts() {

        try{
            List<Posts> lista =  controller.loadAll();
            return new ResponseEntity(lista, HttpStatus.OK);
        }catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
