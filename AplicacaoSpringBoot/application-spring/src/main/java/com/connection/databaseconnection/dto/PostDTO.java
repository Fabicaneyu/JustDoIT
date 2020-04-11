package com.connection.databaseconnection.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long id_user;
    private String conteudo;
    private String photo;
    private String nome_user;
    private LocalDate _data;


    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
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
