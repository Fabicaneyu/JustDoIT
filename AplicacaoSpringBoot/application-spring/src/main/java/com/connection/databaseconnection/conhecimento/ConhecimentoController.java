package com.connection.databaseconnection.conhecimento;

import com.connection.databaseconnection.associative.conhecimento.ConhecimentoUsuario;
import com.connection.databaseconnection.associative.interesse.InteresseUsuario;
import com.connection.databaseconnection.dto.ConhecimentoDTO;
import com.connection.databaseconnection.exception.ErroConexao;
import com.connection.databaseconnection.exception.KnowNotFoundException;
import com.connection.databaseconnection.exception.UserNotFoundException;
import com.connection.databaseconnection.iterators.ConhecimentoBuilder;
import com.connection.databaseconnection.iterators.InteresseBuilder;
import com.connection.databaseconnection.user.UserService;
import com.connection.databaseconnection.user.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conhecimentos")
public class ConhecimentoController {

    @Autowired
    ConhecimentoService controller;

    @Autowired
    UserService userController;

    @Autowired
    ConhecimentoBuilder conhecimentoBuilder;

    @Autowired
    InteresseBuilder interesseBuilder;


    @PostMapping("/adicionar/conhecimento")
    public ResponseEntity novoConhecimento(@RequestBody ConhecimentoUsuario conhecimentoUsuario) {

        try {
            Optional<Conhecimento> resultKnow = controller.buscaConhecimentoPorId
                    (conhecimentoUsuario.getConhecimento().getId_conhecimento());

            Optional<Usuario> resultUser = userController.buscaporIdOptional
                    (conhecimentoUsuario.getUsuario().getId());

            ConhecimentoUsuario novoConhecimento = ConhecimentoUsuario.builder()
                    .descricao_user(conhecimentoUsuario.getDescricao_user())
                    .nivel(conhecimentoUsuario.getNivel()).usuario(resultUser.get())
                    .conhecimento(resultKnow.get()).build();

           boolean salvo = controller.saveConhecimentoUsuario(novoConhecimento);

           if (salvo) {
               return ResponseEntity.ok(novoConhecimento);
           }
           else {
               return ResponseEntity.status(404).build();
           }

        }catch (ErroConexao erro) {
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
    }

    @PostMapping("/adicionar/interesse")
    public ResponseEntity novoInteresse(@RequestBody InteresseUsuario interesseUsuario) {

        try {
            Optional<Conhecimento> resultKnow = controller.buscaConhecimentoPorId
                    (interesseUsuario.getConhecimento().getId_conhecimento());

            Optional<Usuario> resultUser = userController.buscaporIdOptional
                    (interesseUsuario.getUsuario().getId());

            InteresseUsuario novoInteresse = InteresseUsuario.builder()
                    .descricao_interesse(interesseUsuario.getDescricao_interesse())
                    .conhecimento(resultKnow.get()).usuario(resultUser.get()).build();

            boolean salvo = controller.saveInteresseUsuario(novoInteresse);

            if (salvo) {
                return ResponseEntity.ok(novoInteresse);
            }
            else {
                return ResponseEntity.status(404).build();
            }

        }catch (ErroConexao erro) {
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
    }

    @GetMapping("/buscar/conhecimentos")
    public ResponseEntity buscarConhecimentos(@RequestParam(required = true) Long id ) {

        try {
            List<ConhecimentoUsuario> result = controller.buscaConhecimentosPerfil(id);

            return ResponseEntity.ok(conhecimentoBuilder.nextList(result));

        }catch (UserNotFoundException e) {

            return ResponseEntity.noContent().build();

        }
    }

    @GetMapping("/buscar/interesses")
    public ResponseEntity buscarInteresses(@RequestParam(required = true) Long id ) {

        try {
            List<InteresseUsuario> result = controller.buscarInteresses(id);

            return ResponseEntity.ok(interesseBuilder.nextList(result));

        }catch (UserNotFoundException e) {

            return ResponseEntity.noContent().build();

        }

    }

    @DeleteMapping("/remover/conhecimento/{id}")
    public ResponseEntity removerConhecimentoPorId(@PathVariable("id") Long id) {

        try{
            boolean delete = controller.deleteKnowById(id);
            if(delete) {
                return ResponseEntity.ok().build();
            }

            throw new KnowNotFoundException();

        }catch (KnowNotFoundException erro) {

            return ResponseEntity.badRequest().body(erro.getMessage());

        }
    }

    @DeleteMapping("/remover/interesse/{id}")
    public ResponseEntity removerInteresseorId(@PathVariable("id") Long id) {

        try{
            boolean delete = controller.deleteInterestById(id);
            if(delete) {
                return ResponseEntity.ok().build();
            }

            throw new KnowNotFoundException();

        }catch (KnowNotFoundException erro) {

            return ResponseEntity.badRequest().body(erro.getMessage());

        }
    }

    @GetMapping("/recomendados/teste")
    public ResponseEntity teste() {
        try {
            List<Conhecimento> result = controller.recomendados();
            if (result == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("Nenhum conhecimento na base de dados");
            }
            return ResponseEntity.ok(result);
        }
        catch (ErroConexao e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
