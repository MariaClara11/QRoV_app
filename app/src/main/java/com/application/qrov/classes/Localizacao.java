package com.application.qrov.classes;

public class Localizacao {

    private int andar;
    private int corredor;
    private int prateleira;
    private int nivel;

    public Localizacao() {
    }

    public Localizacao(int andar, int corredor, int prateleira, int nivel) {
        this.andar = andar;
        this.corredor = corredor;
        this.prateleira = prateleira;
        this.nivel = nivel;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getCorredor() {
        return corredor;
    }

    public void setCorredor(int corredor) {
        this.corredor = corredor;
    }

    public int getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(int prateleira) {
        this.prateleira = prateleira;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "A" + andar + "-C" + corredor + "-P" + prateleira + "-N" + nivel;
    }
}
