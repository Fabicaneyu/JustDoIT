package com.justdoit.justdoit.model;

import javax.persistence.*;

@Entity
@Table(name = "tbClassificacao")
public class Classificacao {
    @Id
    @Column(name = "id_classificacao")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClassificacao;
    @Column(name = "rank")
    private String rank;
    @Column(name = "nivel")
    private int nivel;
    @Column(name = "pontuacao")
    private float pontuacao;

}
