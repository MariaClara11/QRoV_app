package com.application.qrov.database;

public class Unidade {

    private int Id_Unidade;
    private String Nome;
    private float Equivalencia_SI;
    private String Sigla;
    private boolean selecionada;

    public Unidade() {
    }

    public Unidade(int id_Unidade, String nome, float equivalencia_SI, String sigla) {
        Id_Unidade = id_Unidade;
        Nome = nome;
        Equivalencia_SI = equivalencia_SI;
        Sigla = sigla;
    }

    public Unidade(String nome, float equivalencia_SI, String sigla) {
        Nome = nome;
        Equivalencia_SI = equivalencia_SI;
        Sigla = sigla;
    }

    public int getId_Unidade() {
        return Id_Unidade;
    }

    public void setId_Unidade(int id_Unidade) {
        Id_Unidade = id_Unidade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public float getEquivalencia_SI() {
        return Equivalencia_SI;
    }

    public void setEquivalencia_SI(float equivalencia_SI) {
        Equivalencia_SI = equivalencia_SI;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String sigla) {
        Sigla = sigla;
    }

    public boolean isSelecionada() {
        return selecionada;
    }

    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }

    @Override
    public String toString() {
        return Nome + "\n (" + Sigla + ")";
    }
}
