package com.application.qrov.database;

public class Insumo {

    private int idInsumo;
    private String nome;
    private int idTipo;
    private String localizacao;
    private int visibilidade;

    public Insumo(int idInsumo, String nome, int idTipo, String localizacao, int visibilidade) {
        this.idInsumo = idInsumo;
        this.nome = nome;
        this.idTipo = idTipo;
        this.localizacao = localizacao;
        this.visibilidade = visibilidade;
    }

    public Insumo(String nome, int idTipo, String localizacao, int visibilidade) {
        this.nome = nome;
        this.idTipo = idTipo;
        this.localizacao = localizacao;
        this.visibilidade = visibilidade;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(int visibilidade) {
        this.visibilidade = visibilidade;
    }

    @Override
    public String toString() {
        return "Insumo: " + idInsumo;
    }
}
