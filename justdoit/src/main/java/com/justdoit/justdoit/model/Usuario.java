package com.justdoit.justdoit.model;

import javax.persistence.*;

@Entity
@Table(name = "tbUsuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento")
    private String dataNascimento;
    @Column(name = "login")
    private String login;
    @Column(name = "email")
    private String email;
    @Column(name = "estado")
    private String estado;
    @Column(name = "pais")
    private String pais;
    @Column(name = "senha")
    private String senha;
    @Column(name = "fkClassificacao")
    private Classificacao classificacao;

    //foreign key(fkClassificacao) references tbClassificacao (idClassificacao);


}
