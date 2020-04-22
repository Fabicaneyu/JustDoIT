package com.connection.databaseconnection.posts;

import com.connection.databaseconnection.dataTreat.ListBuilder;
import com.connection.databaseconnection.dataTreat.PostModel;
import com.connection.databaseconnection.dto.PostDTO;
import com.connection.databaseconnection.exception.ErroConexao;
import com.connection.databaseconnection.user.UserService;
import com.connection.databaseconnection.user.Usuario;
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


    @PostMapping("/new")
    public ResponseEntity novoPost(@RequestBody PostDTO postDTO) {

        Usuario newPostUser = Usuario.builder().id(postDTO.getId_user()).build();

        Posts post = Posts.builder().conteudo(postDTO.getConteudo())._data(postDTO.get_data())
                .usuario(newPostUser).build();
        try{
            Posts postEnviado = controller.novoPost(post);
            return new ResponseEntity(postEnviado, HttpStatus.CREATED);
        }catch (ErroConexao e) {
           return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/load/initial")
    public ResponseEntity loadPostsSet() {

        try{
            controller.setFirst();
            return new ResponseEntity(HttpStatus.OK);
        }catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/load/feed")

    public ResponseEntity loadPosts() {

        try{
            List<PostModel> lista =  controller.loadFeed();
            if (lista == null) {
           return new ResponseEntity("A lista está vazia", HttpStatus.ACCEPTED);
            }
            return new ResponseEntity(lista, HttpStatus.OK);
        }catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

//    @GetMapping("/teste")
//    public ResponseEntity loadTeste() {
//
//        try{
//            List<Object[]>  resultDefault = controller.testeJoin();
//
//            List<PostModel> resultNice = controller.testeBuilder(resultDefault);
//
//            return new ResponseEntity(resultNice, HttpStatus.OK);
//        }catch (ErroConexao e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//
//    }

}
