package com.connection.databaseconnection.dataTreat;

public class PostModel {

    private String nome, conteudo, imagem;
    private Long id;

    public PostModel(Long id, String nome, String conteudo, String imagem) {
        this.id = id;
        this.nome = nome;
        this.conteudo = conteudo;
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
}
