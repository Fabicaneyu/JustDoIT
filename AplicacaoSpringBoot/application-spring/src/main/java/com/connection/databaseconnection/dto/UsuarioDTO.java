package com.connection.databaseconnection.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDTO {

    private String email, nome, photo, senha, senhaConfirma;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPhoto(String photo){ this.photo = photo;}

    public String getPhoto(){ return photo; }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioDTO(String senhaConfirma) {
        this.senhaConfirma = senhaConfirma;
    }

    public String getSenhaConfirma() {
        return senhaConfirma;
    }

    public void setSenhaConfirma(String senhaConfirma) {
        this.senhaConfirma = senhaConfirma;
    }
}



