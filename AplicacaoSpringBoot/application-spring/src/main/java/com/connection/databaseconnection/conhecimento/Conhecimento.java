package com.connection.databaseconnection.conhecimento;


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
@Table(name = "conhecimento", schema="teste2")
public class Conhecimento {

    @Id
    @Column( name = "idConhecimento" )
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long idConhecimento;
    @Column( name = "conhecimento")
    private String conhecimento;
    @Column( name = "descricao")
    private String descricao;
    @Column( name = "tipo")
    @Enumerated(value = EnumType.STRING )
    private TipoConhecimento tipo;


}
