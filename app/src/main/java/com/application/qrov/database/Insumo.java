package com.application.qrov.database;

public class Insumo {

    private int Id_Insumo;
    private String Nome;
    private int Id_Tipo;
    private int Visivel;

    public Insumo() {
    }

    public Insumo(int Id_Insumo, String nome, int Id_Tipo, int Visivel) {
        this.Id_Insumo = Id_Insumo;
        this.Nome = nome;
        this.Id_Tipo = Id_Tipo;
        this.Visivel = Visivel;
    }

    public Insumo(String nome, int Id_Tipo, int Visivel) {
        this.Nome = nome;
        this.Id_Tipo = Id_Tipo;
        this.Visivel = Visivel;
    }

    public int getId_Insumo() {
        return Id_Insumo;
    }

    public void setId_Insumo(int id_Insumo) {
        this.Id_Insumo = id_Insumo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public int getId_Tipo() {
        return Id_Tipo;
    }

    public void setId_Tipo(int id_Tipo) {
        this.Id_Tipo = id_Tipo;
    }

    public int getVisivel() {
        return Visivel;
    }

    public void setVisivel(int visivel) {
        this.Visivel = visivel;
    }

}
