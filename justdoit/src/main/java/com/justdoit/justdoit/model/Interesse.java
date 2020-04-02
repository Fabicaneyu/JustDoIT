package com.justdoit.justdoit.model;

import javax.persistence.*;

@Entity
@Table(name = "tbInteresse")
public class Interesse {

    @Id
    @Column(name = "id_interesse")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idInteresse;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "palavra_chave")
    private String palavraChave;
}
