package com.connection.databaseconnection.evento;

import com.connection.databaseconnection.convidado.Convidado;
import com.connection.databaseconnection.convidado.ConvidadoRepository;
import com.connection.databaseconnection.evento.client.cep.Cep;
import com.connection.databaseconnection.evento.client.cep.ClientViaCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;


@Controller
public class EventoController {
    @Autowired
    private EventoRepository er;
    @Autowired
    private ConvidadoRepository cr;

    private ClientViaCep clientViaCep;

    @PostMapping(path = "/cadastrarEvento")
    public ResponseEntity<String> form(@RequestBody Evento evento) {
      try {
          if(evento == null){
              System.out.println("Cadastro vazio");

          }
      }catch (Exception e){
          e.printStackTrace();
      }

        er.save(evento);
        return ok("redirect:/cadastrarEvento");

    }

    @GetMapping(path = "/eventos")
    public ResponseEntity listaEventos() {
        Iterable<Evento> eventos = er.findAll();
        if (eventos == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ok(eventos);
        }

    }

        @GetMapping(path = "/eventos/{codigo}")
        public ResponseEntity eventosEspecificos ( @PathVariable("codigo") long codigo){
            Evento evento = er.findByCodigo(codigo);
            return ok(evento);
        }

        @GetMapping(path = "/convidado/{codigo}")
        public ResponseEntity detalhesEvento ( @PathVariable("codigo") long codigo) {
            Evento evento = er.findByCodigo(codigo);
            Iterable<Convidado> convidados = cr.findByEvento(evento);
            if (convidados == null) {
                return ResponseEntity.noContent().build();
            } else {
                return ok(convidados);
            }
        }
        @PostMapping(path = "/convidado/{codigo}")
        public ResponseEntity cadastroConvidado( @PathVariable("codigo") long codigo, @RequestBody Convidado convidado)
        {
            Evento evento = er.findByCodigo(codigo);
            convidado.setEvento(evento);
            cr.save(convidado);
            return ok(convidado);
        }

        @DeleteMapping(path="/evento/{codigo}")
        public ResponseEntity deletarEvento ( @PathVariable("codigo") long codigo){
            Evento evento = er.findByCodigo(codigo);
            er.delete(evento);
            return ok().build();
        }



    @DeleteMapping(path = "/convidado/{rg}")
    public ResponseEntity delete (@PathVariable String rg){
        cr.findByRg(rg);
        cr.deleteById(rg);
        return ok().build();

    }
    @GetMapping("/cep/{cep}")
    public ResponseEntity consultarCep(@PathVariable String cep) {
        Cep cepEncontrado = clientViaCep.getCep(cep);
        try {
            if (cepEncontrado == null) {
                System.out.println("cep vazio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok(cepEncontrado);
    }


    }
