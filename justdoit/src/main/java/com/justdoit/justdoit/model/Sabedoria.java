package com.justdoit.justdoit.model;

import javax.persistence.*;

@Entity @Table(name = "tbSabedoria")
public class Sabedoria {
    @Id
    @Column (name = "id_sabedoria")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSabedoria;
    @Column (name = "conhecimento")
    private String conhecimento;
    @Column (name = "descricao")
    private String descricao;
    @Column (name = "level")
    private int level;

}
