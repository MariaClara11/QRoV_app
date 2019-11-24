package com.application.qrov.database;

public class MateriaPrima {

    private int idProduto;
    private String nome;
    private int idInsumo;
    private boolean visivel;

    public MateriaPrima(int idProduto, String nome, int idInsumo, boolean visivel) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.idInsumo = idInsumo;
        this.visivel = visivel;
    }

    public MateriaPrima(String nome, int idInsumo, boolean visivel) {
        this.nome = nome;
        this.idInsumo = idInsumo;
        this.visivel = visivel;
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

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
}
