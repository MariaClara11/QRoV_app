package com.application.qrov.database;

public class TemUnidadeEntrada {

    private int idUnidade;
    private int idProduto;
    private int idInsumo;

    public TemUnidadeEntrada(int idUnidade, int idProduto, int idInsumo) {
        this.idUnidade = idUnidade;
        this.idProduto = idProduto;
        this.idInsumo = idInsumo;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }
}
