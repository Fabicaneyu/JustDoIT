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

    public LocalDateTime get_data() {
        return LocalDateTime.now();
    }

    public void set_data(LocalDate _data) {
        this._data = _data;
    }
}
