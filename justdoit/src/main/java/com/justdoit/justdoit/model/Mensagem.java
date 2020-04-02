package com.justdoit.justdoit.model;

import javax.persistence.*;

@Entity
@Table(name = "mensagem")
public class Mensagem {

    @Id
    @Column(name = "id_mensagem")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMensagem;
    @Column(name = "texto")
    private String texto;
    @Column(name = "data_hora")
    private String dataHora;
    @Column(name = "de_quem")
    private String deQuem;
    @Column(name = "para_quem")
    private String paraQuem;

//    foreign key(de_quem) references tbUsuario (idUsuario),
//   foreign key(para_quem) references tbUsuario (idUsuario);
}
