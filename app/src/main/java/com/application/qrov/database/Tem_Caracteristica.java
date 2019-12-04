package com.application.qrov.database;

public class Tem_Caracteristica {

    private int Id_Caracteristica;
    private int idProduto;

    public Tem_Caracteristica() {
    }

    public Tem_Caracteristica(int Id_Caracteristica, int idProduto) {
        this.Id_Caracteristica = Id_Caracteristica;
        this.idProduto = idProduto;
    }

    public int getId_Caracteristica() {
        return Id_Caracteristica;
    }

    public void setId_Caracteristica(int id_Caracteristica) {
        this.Id_Caracteristica = id_Caracteristica;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
}
