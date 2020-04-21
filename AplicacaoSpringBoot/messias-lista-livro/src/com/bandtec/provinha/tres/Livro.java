package com.bandtec.provinha.tres;

public class Livro {


    private int idLivro;
    private String titulo;
    private String autor;
    private double preco;
    private int qtdPagina;

    public Livro(int idLivro, String titulo, String autor, double preco, int qtdPagina) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.qtdPagina = qtdPagina;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdPagina() {
        return qtdPagina;
    }

    public void setQtdPagina(int qtdPagina) {
        this.qtdPagina = qtdPagina;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                ", qtdPagina=" + qtdPagina +
                '}';
    }
}
