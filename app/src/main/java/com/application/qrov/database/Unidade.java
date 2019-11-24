package com.application.qrov.database;

public class Unidade {

    private int idUnidade;
    private String nome;
    private String tipo;

    public Unidade(int idUnidade, String nome, String tipo) {
        this.idUnidade = idUnidade;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Unidade(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
