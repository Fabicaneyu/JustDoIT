package com.connection.databaseconnection.conhecimento;

import com.connection.databaseconnection.dto.ConhecimentoDTO;
import com.connection.databaseconnection.exception.ErroConexao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conhecimento")
public class ConhecimentoController {

    @Autowired
    ConhecimentoService controller;

    @PostMapping("/adicionar")
    public ResponseEntity novoConhecimento(@RequestBody ConhecimentoDTO conhecimento) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().build();
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
