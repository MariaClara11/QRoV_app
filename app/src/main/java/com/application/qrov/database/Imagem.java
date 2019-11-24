package com.application.qrov.database;

public class Imagem {

    private String endereco;
    private String nome;
    private int codProduto;
    private int idInsumo;

    public Imagem(String endereco, String nome, int codProduto, int idInsumo) {
        this.endereco = endereco;
        this.nome = nome;
        this.codProduto = codProduto;
        this.idInsumo = idInsumo;
    }

    public Imagem(String nome, int codProduto, int idInsumo) {
        this.nome = nome;
        this.codProduto = codProduto;
        this.idInsumo = idInsumo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }
}
