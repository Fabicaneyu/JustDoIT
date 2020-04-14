package com.connection.databaseconnection.associative;

import com.connection.databaseconnection.conhecimento.Conhecimento;
import com.connection.databaseconnection.user.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Possui {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column( name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn( name = "fkUser")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn( name = "fkConhecimento")
    private Conhecimento conhecimento;

    @Column( name = "nivel" )
    private int nivel;

}
