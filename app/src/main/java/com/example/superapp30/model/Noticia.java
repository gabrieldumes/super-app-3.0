package com.example.superapp30.model;

import java.io.Serializable;

public class Noticia implements Serializable {

    private int imagem;
    private String titulo, artigo, data, autor, creditoFoto;

    public Noticia() {

    }

    public Noticia(int imagem, String titulo, String artigo, String data, String autor, String creditoFoto) {
        this.imagem = imagem;
        this.titulo = titulo;
        this.artigo = artigo;
        this.data = data;
        this.autor = autor;
        this.creditoFoto = creditoFoto;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCreditoFoto() {
        return creditoFoto;
    }

    public void setCreditoFoto(String creditoFoto) {
        this.creditoFoto = creditoFoto;
    }
}
