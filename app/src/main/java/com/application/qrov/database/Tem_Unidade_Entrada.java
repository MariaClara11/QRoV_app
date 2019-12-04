package com.application.qrov.database;

public class Tem_Unidade_Entrada {

    private int Id_Unidade;
    private int CodProduto;
    private int Id_Insumo;

    public Tem_Unidade_Entrada() {
    }

    public Tem_Unidade_Entrada(int Id_Unidade, int CodProduto, int Id_Insumo) {
        this.Id_Unidade = Id_Unidade;
        this.CodProduto = CodProduto;
        this.Id_Insumo = Id_Insumo;
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

    public int getId_Insumo() {
        return Id_Insumo;
    }

    public void setId_Insumo(int id_Insumo) {
        this.Id_Insumo = id_Insumo;
    }
}
