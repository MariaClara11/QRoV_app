package com.application.qrov.database;

import java.sql.Date;

public class Entrada {

    private int idEntrada;
    private int chaveAcesso;
    private float valorTotal;
    private Date data;
    private int cnpj;

    public Entrada(int idEntrada, int chaveAcesso, float valorTotal, Date data, int cnpj) {
        this.idEntrada = idEntrada;
        this.chaveAcesso = chaveAcesso;
        this.valorTotal = valorTotal;
        this.data = data;
        this.cnpj = cnpj;
    }

    public Entrada(int chaveAcesso, float valorTotal, Date data, int cnpj) {
        this.chaveAcesso = chaveAcesso;
        this.valorTotal = valorTotal;
        this.data = data;
        this.cnpj = cnpj;
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

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
}
