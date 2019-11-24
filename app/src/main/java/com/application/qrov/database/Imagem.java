package com.application.qrov.database;

public class Imagem {

    private String endereco;
    private String nome;
    private int idProduto;
    private int idInsumo;

    public Imagem(String endereco, String nome, int idProduto, int idInsumo) {
        this.endereco = endereco;
        this.nome = nome;
        this.idProduto = idProduto;
        this.idInsumo = idInsumo;
    }

    public Imagem(String nome, int idProduto, int idInsumo) {
        this.nome = nome;
        this.idProduto = idProduto;
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
