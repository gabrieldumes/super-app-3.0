package com.example.superapp30.model;

public class Noticia {

    private int imagem;
    private String titulo, artigo;

    public Noticia() {

    }

    public Noticia(int imagem, String titulo, String artigo) {
        this.imagem = imagem;
        this.titulo = titulo;
        this.artigo = artigo;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtigo() {
        return artigo;
    }

    public void setArtigo(String artigo) {
        this.artigo = artigo;
    }
}
