package com.application.qrov.database;

import java.sql.Date;

public class Saida {

    private int Id_Saida;
    private float Preco;
    private float Quantidade;
    private Date Data_Saida;
    private float Valor_Total;
    private int CodProduto;

    public Saida() {
    }

    public Saida(int Id_Saida, float preco, float Quantidade, Date Data_Saida, float Valor_Total, int CodProduto) {
        this.Id_Saida = Id_Saida;
        this.Preco = preco;
        this.Quantidade = Quantidade;
        this.Data_Saida = Data_Saida;
        this.Valor_Total = Valor_Total;
        this.CodProduto = CodProduto;
    }

    public Saida(float preco, float Quantidade, Date Data_Saida, float Valor_Total, int CodProduto) {
        this.Preco = preco;
        this.Quantidade = Quantidade;
        this.Data_Saida = Data_Saida;
        this.Valor_Total = Valor_Total;
        this.CodProduto = CodProduto;
    }

    public int getId_Saida() {
        return Id_Saida;
    }

    public void setId_Saida(int id_Saida) {
        this.Id_Saida = id_Saida;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float preco) {
        this.Preco = preco;
    }

    public float getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.Quantidade = quantidade;
    }

    public Date getData_Saida() {
        return Data_Saida;
    }

    public void setData_Saida(Date data_Saida) {
        this.Data_Saida = data_Saida;
    }

    public float getValor_Total() {
        return Valor_Total;
    }

    public void setValor_Total(float valor_Total) {
        this.Valor_Total = valor_Total;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int codProduto) {
        this.CodProduto = codProduto;
    }
}
