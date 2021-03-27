package com.example.superapp30.model;

public class Livro {

    private int id;
    private String livro;

    public Livro() {

    }

    public Livro(int id, String livro) {
        this.id = id;
        this.livro = livro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }
}
