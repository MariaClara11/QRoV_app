package com.application.qrov.database;

public class TemCaracteristica {

    private int idCaracteristica;
    private int idProduto;

    public TemCaracteristica(int idCaracteristica, int idProduto) {
        this.idCaracteristica = idCaracteristica;
        this.idProduto = idProduto;
    }

    public int getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(int idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}
