package com.connection.databaseconnection.posts;



import com.connection.databaseconnection.user.Usuario;
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

    @ManyToOne
    @JoinColumn( name = "id_user")
    private Usuario usuario;

    @Column( name = "_data")
    private String _data;
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
