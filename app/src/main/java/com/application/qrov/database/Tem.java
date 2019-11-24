package com.application.qrov.database;

public class Tem {

    private int idCaracteristica;
    private int codProduto;

    public Tem(int idCaracteristica, int codProduto) {
        this.idCaracteristica = idCaracteristica;
        this.codProduto = codProduto;
    }

    public int getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(int idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }
}
