package com.connection.databaseconnection.usuario;

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
@Table( name = "usuario", schema = "teste")
public class Usuario {

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    @Column( name = "nome")
    private String nome;
    @Column( name = "email")
    private String email;
    @Column( name = "senha")
    private String senha;


}
