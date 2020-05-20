package com.connection.databaseconnection.adapters;

public class PostModel {

    private Integer id, id_user, reacao, interessante, gratidao,inovador;
    private String nome, conteudo, imagem , data;


    public PostModel(Integer id, Integer id_user, Integer reacao, Integer interessante, Integer gratidao,
                     Integer inovador, String nome, String conteudo, String imagem, String data) {
        this.id = id;
        this.id_user = id_user;
        this.reacao = reacao;
        this.interessante = interessante;
        this.gratidao = gratidao;
        this.inovador = inovador;
        this.nome = nome;
        this.conteudo = conteudo;
        this.imagem = imagem;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
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

    public Integer getReacao() {
        return reacao;
    }

    public void setReacao(Integer reacao) {
        this.reacao = reacao;
    }

    public Integer getInteressante() {
        return interessante;
    }

    public void setInteressante(Integer interessante) {
        this.interessante = interessante;
    }

    public Integer getGratidao() {
        return gratidao;
    }

    public void setGratidao(Integer gratidao) {
        this.gratidao = gratidao;
    }

    public Integer getInovador() {
        return inovador;
    }

    public void setInovador(Integer inovador) {
        this.inovador = inovador;
    }
}
