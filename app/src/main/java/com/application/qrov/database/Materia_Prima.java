package com.application.qrov.database;

public class Materia_Prima {

    private int CodProduto;
    private String Nome;
    private int Id_Insumo;
    private int Id_Localizacao;
    private int Visivel;

    public Materia_Prima() {
    }

    public Materia_Prima(int CodProduto, String nome, int Id_Insumo, int Id_Localizacao, int Visivel) {
        this.CodProduto = CodProduto;
        this.Nome = nome;
        this.Id_Insumo = Id_Insumo;
        this.Id_Localizacao = Id_Localizacao;
        this.Visivel = Visivel;
    }

    public Materia_Prima(String nome, int Id_Insumo, int Visivel) {
        this.Nome = nome;
        this.Id_Insumo = Id_Insumo;
        this.Id_Localizacao = Id_Localizacao;
        this.Visivel = Visivel;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int codProduto) {
        this.CodProduto = codProduto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public int getId_Insumo() {
        return Id_Insumo;
    }

    public void setId_Insumo(int id_Insumo) {
        this.Id_Insumo = id_Insumo;
    }

    public int getId_Localizacao() {
        return Id_Localizacao;
    }

    public void setId_Localizacao(int id_Localizacao) {
        this.Id_Localizacao = id_Localizacao;
    }

    public int getVisivel() {
        return Visivel;
    }

    public void setVisivel(int visivel) {
        this.Visivel = visivel;
    }

    @Override
    public String toString() { //QR Code
        return "Matéria-prima: " + CodProduto;
    }
}
