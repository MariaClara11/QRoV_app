package com.application.qrov.database;

public class MateriaPrima {

    private int idProduto;
    private String nome;
    private int idInsumo;
    private String localizacao;
    private int visibilidade;

    public MateriaPrima(int idProduto, String nome, int idInsumo, String localizacao, int visibilidade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.idInsumo = idInsumo;
        this.localizacao = localizacao;
        this.visibilidade = visibilidade;
    }

    public MateriaPrima(String nome, int idInsumo, int visibilidade) {
        this.nome = nome;
        this.idInsumo = idInsumo;
        this.localizacao = localizacao;
        this.visibilidade = visibilidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
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
    public String toString() { //QR Code
        return "Matéria-prima: " + idProduto;
    }
}
