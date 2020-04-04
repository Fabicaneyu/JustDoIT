package com.connection.databaseconnection.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long id_usuario;
    private String conteudo;
    private String photo;
    private String nome_user;
    private LocalDate _data;


    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setPhoto(String photo){
        this.photo = photo;
    }
    public String getPhoto(){
        return photo;
    }

    public LocalDateTime get_data() {
        return LocalDateTime.now();
    }

    public void set_data(LocalDate _data) {
        this._data = _data;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }
}
