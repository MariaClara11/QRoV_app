package com.application.qrov.database;

public class Possui {

    private int Id_Entrada;
    private int Id_MpEntrada;

    public Possui() {
    }

    public Possui(int Id_Entrada, int Id_MpEntrada) {
        this.Id_Entrada = Id_Entrada;
        this.Id_MpEntrada = Id_MpEntrada;
    }

    public int getId_Entrada() {
        return Id_Entrada;
    }

    public void setId_Entrada(int id_Entrada) {
        this.Id_Entrada = id_Entrada;
    }

    public int getId_MpEntrada() {
        return Id_MpEntrada;
    }

    public void setId_MpEntrada(int id_MpEntrada) {
        this.Id_MpEntrada = id_MpEntrada;
    }
}
