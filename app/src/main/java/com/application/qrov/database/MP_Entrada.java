package com.application.qrov.database;

public class MP_Entrada {

    private int Id_MpEntrada;
    private int Estoque_Minimo;
    private float Preco;
    private int Quantidade;
    private float Total;
    private int CodProduto;

    public MP_Entrada() {
    }

    public MP_Entrada(int Id_MpEntrada, int Estoque_Minimo, float preco, int Quantidade, float total, int CodProduto) {
        this.Id_MpEntrada = Id_MpEntrada;
        this.Estoque_Minimo = Estoque_Minimo;
        this.Preco = preco;
        this.Quantidade = Quantidade;
        this.Total = total;
        this.CodProduto = CodProduto;
    }

    public MP_Entrada(int Estoque_Minimo, float preco, int Quantidade, float total, int CodProduto) {
        this.Estoque_Minimo = Estoque_Minimo;
        this.Preco = preco;
        this.Quantidade = Quantidade;
        this.Total = total;
        this.CodProduto = CodProduto;
    }

    public int getId_MpEntrada() {
        return Id_MpEntrada;
    }

    public void setId_MpEntrada(int id_MpEntrada) {
        this.Id_MpEntrada = id_MpEntrada;
    }

    public int getEstoque_Minimo() {
        return Estoque_Minimo;
    }

    public void setEstoque_Minimo(int estoque_Minimo) {
        this.Estoque_Minimo = estoque_Minimo;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float preco) {
        this.Preco = preco;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.Quantidade = quantidade;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        this.Total = total;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int codProduto) {
        this.CodProduto = codProduto;
    }
}
