package com.application.qrov.database;

public class MateriaPrima {

    private int codProduto;
    private String nome;
    private int idInsumo;

    public MateriaPrima(int codProduto, String nome, int idInsumo) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.idInsumo = idInsumo;
    }

    public MateriaPrima(String nome, int idInsumo) {
        this.nome = nome;
        this.idInsumo = idInsumo;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
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
}
