package com.application.qrov.database;

import java.sql.Date;

public class Saida {

    private int idSaida;
    private float preco;
    private float qtdSI;
    private Date data;
    private float total;
    private int codProduto;

    public Saida(int idSaida, float preco, float qtdSI, Date data, float total, int codProduto) {
        this.idSaida = idSaida;
        this.preco = preco;
        this.qtdSI = qtdSI;
        this.data = data;
        this.total = total;
        this.codProduto = codProduto;
    }

    public Saida(float preco, float qtdSI, Date data, float total, int codProduto) {
        this.preco = preco;
        this.qtdSI = qtdSI;
        this.data = data;
        this.total = total;
        this.codProduto = codProduto;
    }

    public int getIdSaida() {
        return idSaida;
    }

    public void setIdSaida(int idSaida) {
        this.idSaida = idSaida;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getQtdSI() {
        return qtdSI;
    }

    public void setQtdSI(float qtdSI) {
        this.qtdSI = qtdSI;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
