package com.application.qrov.database;

public class Possui {

    private int idEntrada;
    private int idMPEntrada;

    public Possui(int idEntrada, int idMPEntrada) {
        this.idEntrada = idEntrada;
        this.idMPEntrada = idMPEntrada;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdMPEntrada() {
        return idMPEntrada;
    }

    public void setIdMPEntrada(int idMPEntrada) {
        this.idMPEntrada = idMPEntrada;
    }
}
