package com.connection.databaseconnection.conhecimento;

import com.connection.databaseconnection.associative.conhecimento.ConhecimentoUsuario;
import com.connection.databaseconnection.associative.interesse.InteresseUsuario;
import com.connection.databaseconnection.dto.ConhecimentoDTO;
import com.connection.databaseconnection.exception.ErroConexao;
import com.connection.databaseconnection.exception.UserNotFoundException;
import com.connection.databaseconnection.iterators.ConhecimentoBuilder;
import com.connection.databaseconnection.iterators.InteresseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conhecimentos")
public class ConhecimentoController {

    @Autowired
    ConhecimentoService controller;

    @Autowired
    ConhecimentoBuilder conhecimentoBuilder;

    @Autowired
    InteresseBuilder interesseBuilder;

    @PostMapping("/adicionar")
    public ResponseEntity novoConhecimento(@RequestBody ConhecimentoDTO conhecimento) {
        return ResponseEntity.ok().build();
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

    @DeleteMapping("/remover{id}")
    public ResponseEntity removerPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().build();
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
