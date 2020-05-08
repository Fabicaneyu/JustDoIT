package com.connection.databaseconnection.usuario;

import com.connection.databaseconnection.associative.conhecimento.ConhecimentoUsuario;
import com.connection.databaseconnection.conhecimento.Conhecimento;
import com.connection.databaseconnection.conhecimento.ConhecimentoRepository;
import com.connection.databaseconnection.dto.UserDTO;
import com.connection.databaseconnection.exception.ErroAutenticacao;
import com.connection.databaseconnection.exception.ErroConexao;
import com.connection.databaseconnection.exception.RegraException;
import com.connection.databaseconnection.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.awt.peer.CanvasPeer;
import java.util.List;

@Service
@Controller
@RestController
@RequestMapping("/user")
public class UserController {


    //Esse atributo vai armazenar o usuario atual
    private Usuario currentUser = null;

    //Esse Atributo vai nos permitir utilizar os metodos da classe Service
    @Autowired
    private UserService controller;

    @Autowired
    private ConhecimentoRepository conhecimentoRepository;

    public UserController(UserService controller) {

        this.controller = controller;
    }


        /*Esse end-point é resposavel pelo login, ele executa o
        metodo "authentication" que verifica o email e a senha no banco*/

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        try {
            Usuario userAutenticado = controller.authentication(userDTO.getEmail(), userDTO.getSenha());
            currentUser = userAutenticado;
            return ResponseEntity.ok(userAutenticado);
        } catch (ErroAutenticacao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/logoff")
    public ResponseEntity logoff() {
        try {
            currentUser = null;
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    //Pega o json fornecido pelo front do tipo userDTO e cria um user do tipo User
    @PostMapping("/cadastro")
    public ResponseEntity cadastrar(@RequestBody UserDTO userDTO) {

        Usuario user = Usuario.builder()
                .nome(userDTO.getNome())
                .email(userDTO.getEmail()).photo(userDTO.getPhoto()).senha(userDTO.getSenha()).build();

        try {
            Usuario userSalvo = controller.saveUser(user);
            return new ResponseEntity(userSalvo, HttpStatus.CREATED);
        } catch (RegraException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/about")
    public ResponseEntity sobre(@RequestParam(required = true) Long id) {
        try {


            Usuario user = this.controller.buscaporId(id);
            if (user != null) {
                return new ResponseEntity(user.getSobre(), HttpStatus.OK);
            } else {
                return new ResponseEntity("Usuário não encontrado", HttpStatus.NO_CONTENT);
            }

        } catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/about")
    public ResponseEntity atualizarSobre(@RequestBody UserDTO userDTO) {

        try {
            Usuario user = Usuario.builder().id(userDTO.getId()).sobre(userDTO.getSobre()).build();

            controller.updateSobre(user);

            return new ResponseEntity(HttpStatus.OK);

        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    @GetMapping("/find")
    public ResponseEntity buscarTeste(@RequestParam(required = false) String conhecimento,
                                      @RequestParam(required = false) String tipo) {
        try {

            Conhecimento consulta = Conhecimento.builder().conhecimento(conhecimento).build();

            List conhecimentos = controller.buscarConhecimentos(consulta.getConhecimento());


            if (conhecimentos == null) {
                return new ResponseEntity("Infelizmente ainda não temos usuários que possuem este conhecimento"
                        , HttpStatus.NO_CONTENT);
            }
            else{
                return ResponseEntity.ok(conhecimentos);
            }


        } catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }


}
