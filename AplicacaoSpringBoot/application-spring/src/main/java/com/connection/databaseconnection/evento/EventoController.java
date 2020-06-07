package com.connection.databaseconnection.evento;


import com.connection.databaseconnection.evento.convidado.Convidado;
import com.connection.databaseconnection.evento.convidado.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class EventoController {
    @Autowired
    private EventoRepository er;
    @Autowired
    private ConvidadoRepository cr;

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
        return ResponseEntity.ok("redirect:/cadastrarEvento");

    }

    @GetMapping(path = "/eventos")
    public ResponseEntity listaEventos() {
        Iterable<Evento> eventos = er.findAll();
        if (eventos == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(eventos);
        }

    }

        @GetMapping(path = "/eventos/{codigo}")
        public ResponseEntity eventosEspecificos ( @PathVariable("codigo") long codigo){
            Evento evento = er.findByCodigo(codigo);
            return ResponseEntity.ok(evento);
        }

        @GetMapping(path = "/convidado/{codigo}")
        public ResponseEntity detalhesEvento ( @PathVariable("codigo") long codigo) {
            Evento evento = er.findByCodigo(codigo);
            Iterable<Convidado> convidados = cr.findByEvento(evento);
            if (convidados == null) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(convidados);
            }
        }
        @PostMapping(path = "/convidado/{codigo}")
        public ResponseEntity cadastroConvidado( @PathVariable("codigo") long codigo, @RequestBody Convidado convidado)
        {
            Evento evento = er.findByCodigo(codigo);
            convidado.setEvento(evento);
            cr.save(convidado);
            return ResponseEntity.ok(convidado);
        }

        @DeleteMapping(path="/evento/{codigo}")
        public ResponseEntity deletarEvento ( @PathVariable("codigo") long codigo){
            Evento evento = er.findByCodigo(codigo);
            er.delete(evento);
            return ResponseEntity.ok().build();
    }



    @DeleteMapping(path = "/convidado/{rg}")
    public ResponseEntity delete (@PathVariable String rg){
        cr.findByRg(rg);
        cr.deleteById(rg);
        return ResponseEntity.ok().build();

    }



    }
