package com.application.qrov.database;

import java.sql.Date;

public class Entrada {

    private int idEntrada;
    private int chaveAcesso;
    private float valorTotal;
    private Date data;
    private int idFornecedor;

    public Entrada(int idEntrada, int chaveAcesso, float valorTotal, Date data, int idFornecedor) {
        this.idEntrada = idEntrada;
        this.chaveAcesso = chaveAcesso;
        this.valorTotal = valorTotal;
        this.data = data;
        this.idFornecedor = idFornecedor;
    }

    public Entrada(int chaveAcesso, float valorTotal, Date data, int idFornecedor) {
        this.chaveAcesso = chaveAcesso;
        this.valorTotal = valorTotal;
        this.data = data;
        this.idFornecedor = idFornecedor;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(int chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
}
