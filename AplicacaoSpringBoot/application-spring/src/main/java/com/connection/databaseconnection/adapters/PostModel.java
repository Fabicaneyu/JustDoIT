package com.connection.databaseconnection.adapters;

public class PostModel {

    private Long id;
    private String nome, conteudo, imagem , data;

    public PostModel(Long id, String nome, String conteudo, String data, String imagem) {
        this.id = id;
        this.nome = nome;
        this.conteudo = conteudo;
        this.data = data;
        this.imagem = imagem;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
