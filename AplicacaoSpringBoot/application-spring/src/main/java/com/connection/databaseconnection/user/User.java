package com.connection.databaseconnection.user;

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
public class User {

    @Id
    @Column( name = "idUser" )
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer idUser;
    @Column( name = "nome")
    private String nome;
    @Column( name = "email")
    private String email;
    @Column( name = "photo")
    private String photo;
    @Column( name = "senha")
    private String senha;
}
