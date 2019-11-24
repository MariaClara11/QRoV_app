package com.application.qrov.database;

public class Caracteristica {

    private int idCaracteristica;
    private String nome;
    private String descricao;

    public Caracteristica(int idCaracteristica, String nome, String descricao) {
        this.idCaracteristica = idCaracteristica;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Caracteristica(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(int idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
