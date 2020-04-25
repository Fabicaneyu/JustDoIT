package com.connection.databaseconnection.convidado;

import com.connection.databaseconnection.evento.Evento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Builder
@Data
//( @Data )Esta notação permite que eu não precise chamar os gets e sets pois já é chamado internamente por ela
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Convidado {
    @Id
    private String rg;

    private String nomeConvidado;

    @ManyToOne
    private Evento evento;

}
