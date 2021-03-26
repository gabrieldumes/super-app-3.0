package com.example.superapp30.helper;

public class Tarefa {

    private int id;
    private String tarefa;

    public Tarefa() {

    }

    public Tarefa(int id, String tarefa) {
        this.id = id;
        this.tarefa = tarefa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
}
