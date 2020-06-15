package com.connection.databaseconnection.evento;

import com.connection.databaseconnection.evento.convidado.Convidado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;

@Service
@Transactional
public class ConvidadoServices {

        @Autowired
    private ConvidadoRepository repository;

        public List<Convidado> listAll(){
            return (List<Convidado>) repository.findAll(Sort.by("nomeConvidado").ascending());
        }
}

