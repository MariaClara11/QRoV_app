package com.application.qrov.database;

public class Localizacao {

    private int Id_Localizacao;
    private int Andar;
    private int Corredor;
    private int Prateleira;
    private int Nivel;
    private int Disponivel;

    public Localizacao() {
    }

    public Localizacao(int id_Localizacao, int andar, int corredor, int prateleira, int nivel, int disponivel) {
        Id_Localizacao = id_Localizacao;
        Andar = andar;
        Corredor = corredor;
        Prateleira = prateleira;
        Nivel = nivel;
        Disponivel = disponivel;
    }

    public Localizacao(int andar, int corredor, int prateleira, int nivel, int disponivel) {
        Andar = andar;
        Corredor = corredor;
        Prateleira = prateleira;
        Nivel = nivel;
        Disponivel = disponivel;
    }

    public int getId_Localizacao() {
        return Id_Localizacao;
    }

    public void setId_Localizacao(int id_Localizacao) {
        Id_Localizacao = id_Localizacao;
    }

    public int getAndar() {
        return Andar;
    }

    public void setAndar(int andar) {
        Andar = andar;
    }

    public int getCorredor() {
        return Corredor;
    }

    public void setCorredor(int corredor) {
        Corredor = corredor;
    }

    public int getPrateleira() {
        return Prateleira;
    }

    public void setPrateleira(int prateleira) {
        Prateleira = prateleira;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int nivel) {
        Nivel = nivel;
    }

    public int getDisponivel() {
        return Disponivel;
    }

    public void setDisponivel(int disponivel) {
        Disponivel = disponivel;
    }
}
