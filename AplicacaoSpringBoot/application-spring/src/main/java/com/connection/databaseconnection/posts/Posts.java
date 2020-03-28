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
@Table(name = "posts", schema="teste2")
public class Posts {

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    @Column( name = "conteudo")
    private String conteudo;
    @Column( name = "id_usuario")
    private Long id_usuario;
    @Column( name = "_data")
    private LocalDateTime _data;


}
