package com.connection.databaseconnection.convidado;

import com.connection.databaseconnection.evento.Evento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Builder
@Data //( @Data )Esta notação permite que eu não precise chamar os gets e sets pois já é chamado internamente por ela
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Convidado {
    @Id
    private String rg;


    private String nomeConvidado;

    @ManyToOne
    private Evento evento;

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
