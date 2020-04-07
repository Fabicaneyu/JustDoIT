package com.connection.databaseconnection.posts;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post", schema="teste3")
public class Posts {

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @Column( name = "conteudo")
    private String conteudo;
    @Column( name = "id_user")
    private Long id_user;
    @Column( name = "_data")
    private LocalDateTime _data;
    @Column( name = "nome_user")
    private  String nome_user;


}
