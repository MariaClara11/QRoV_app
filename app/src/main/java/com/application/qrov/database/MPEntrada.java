package com.application.qrov.database;

public class MPEntrada {

    private int idMPEntrada;
    private int estoqueMinimo;
    private float preco;
    private int qtd;
    private float total;
    private int idProduto;

    public MPEntrada(int idMPEntrada, int estoqueMinimo, float preco, int qtd, float total, int idProduto) {
        this.idMPEntrada = idMPEntrada;
        this.estoqueMinimo = estoqueMinimo;
        this.preco = preco;
        this.qtd = qtd;
        this.total = total;
        this.idProduto = idProduto;
    }

    public MPEntrada(int estoqueMinimo, float preco, int qtd, float total, int idProduto) {
        this.estoqueMinimo = estoqueMinimo;
        this.preco = preco;
        this.qtd = qtd;
        this.total = total;
        this.idProduto = idProduto;
    }

    public int getIdMPEntrada() {
        return idMPEntrada;
    }

    public void setIdMPEntrada(int idMPEntrada) {
        this.idMPEntrada = idMPEntrada;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}
