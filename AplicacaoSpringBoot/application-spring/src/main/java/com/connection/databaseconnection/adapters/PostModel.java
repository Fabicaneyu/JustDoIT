package com.connection.databaseconnection.adapters;

public class PostModel {

    private long id, id_user;
    private String nome, conteudo, imagem , data;

    public PostModel(Long id, String nome, String conteudo, String data, String imagem, long id_user) {
        this.id = id;
        this.nome = nome;
        this.conteudo = conteudo;
        this.data = data;
        this.imagem = imagem;
        this.id_user = id_user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
