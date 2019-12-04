package com.application.qrov.database;

public class Tipo_Insumo {

    private int Id_Tipo;
    private String Nome;

    public Tipo_Insumo() {
    }

    public Tipo_Insumo(int Id_Tipo, String nome) {
        this.Id_Tipo = Id_Tipo;
        this.Nome = nome;
    }

    public Tipo_Insumo(String nome) {
        this.Nome = nome;
    }

    public int getId_Tipo() {
        return Id_Tipo;
    }

    public void setId_Tipo(int id_Tipo) {
        this.Id_Tipo = id_Tipo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }
}
