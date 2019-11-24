package com.application.qrov.database;

public class Insumo {

    private int idInsumo;
    private String nome;
    private int idTipo;

    public Insumo(int idInsumo, String nome, int idTipo) {
        this.idInsumo = idInsumo;
        this.nome = nome;
        this.idTipo = idTipo;
    }

    public Insumo(String nome, int idTipo) {
        this.nome = nome;
        this.idTipo = idTipo;
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
}
