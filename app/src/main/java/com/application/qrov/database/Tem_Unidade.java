package com.application.qrov.database;

public class Tem_Unidade {

    private int Id_Unidade;
    private int CodProduto;
    private String Tipo;

    public Tem_Unidade() {
    }

    public Tem_Unidade(int Id_Unidade, int CodProduto, String tipo) {
        this.Id_Unidade = Id_Unidade;
        this.CodProduto = CodProduto;
        this.Tipo = tipo;
    }

    public int getId_Unidade() {
        return Id_Unidade;
    }

    public void setId_Unidade(int id_Unidade) {
        this.Id_Unidade = id_Unidade;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int codProduto) {
        this.CodProduto = codProduto;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
