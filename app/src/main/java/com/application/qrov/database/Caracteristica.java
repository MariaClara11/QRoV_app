package com.application.qrov.database;

public class Caracteristica {

    private int Id_Caracteristica;
    private String Nome;
    private String Descricao;

    public Caracteristica() {
    }

    public Caracteristica(int id_Caracteristica, String nome, String descricao) {
        Id_Caracteristica = id_Caracteristica;
        Nome = nome;
        Descricao = descricao;
    }

    public Caracteristica(String nome, String descricao) {
        Nome = nome;
        Descricao = descricao;
    }

    public int getId_Caracteristica() {
        return Id_Caracteristica;
    }

    public void setId_Caracteristica(int id_Caracteristica) {
        Id_Caracteristica = id_Caracteristica;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
