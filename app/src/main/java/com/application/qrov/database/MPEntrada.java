package com.application.qrov.database;

public class MPEntrada {

    private int idMPEntrada;
    private int estoqueMinimo;
    private float preco;
    private int qtd;
    private float total;
    private int codProduto;

    public MPEntrada(int idMPEntrada, int estoqueMinimo, float preco, int qtd, float total, int codProduto) {
        this.idMPEntrada = idMPEntrada;
        this.estoqueMinimo = estoqueMinimo;
        this.preco = preco;
        this.qtd = qtd;
        this.total = total;
        this.codProduto = codProduto;
    }

    public MPEntrada(int estoqueMinimo, float preco, int qtd, float total, int codProduto) {
        this.estoqueMinimo = estoqueMinimo;
        this.preco = preco;
        this.qtd = qtd;
        this.total = total;
        this.codProduto = codProduto;
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

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }
}
