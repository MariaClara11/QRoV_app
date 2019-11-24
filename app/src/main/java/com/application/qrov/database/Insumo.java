package com.application.qrov.database;

public class Insumo {

    private int idInsumo;
    private String nome;
    private int idTipo;
    private boolean visivel;

    public Insumo(int idInsumo, String nome, int idTipo, boolean visivel) {
        this.idInsumo = idInsumo;
        this.nome = nome;
        this.idTipo = idTipo;
        this.visivel = visivel;
    }

    public Insumo(String nome, int idTipo, boolean visivel) {
        this.nome = nome;
        this.idTipo = idTipo;
        this.visivel = visivel;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
}
