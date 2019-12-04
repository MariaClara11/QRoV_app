package com.application.qrov.database;

public class Imagem {

    private String Endereco;
    private String Nome;
    private int CodProduto;
    private int Id_Insumo;

    public Imagem() {
    }

    public Imagem(String endereco, String nome, int CodProduto, int Id_Insumo) {
        this.Endereco = endereco;
        this.Nome = nome;
        this.CodProduto = CodProduto;
        this.Id_Insumo = Id_Insumo;
    }

    public Imagem(String nome, int CodProduto, int Id_Insumo) {
        this.Nome = nome;
        this.CodProduto = CodProduto;
        this.Id_Insumo = Id_Insumo;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        this.Endereco = endereco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
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
