package com.connection.databaseconnection.usuario;

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
public class Usuario {

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    @Column( name = "nome")
    private String nome;
    @Column( name = "email")
    private String email;
    @Column( name = "senha")
    private String senha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
