package com.application.qrov.database;

public class Retem {

    private int Id_Fornecedor;
    private int Id_Saida;

    public Retem() {
    }

    public Retem(int Id_Fornecedor, int Id_Saida) {
        this.Id_Fornecedor = Id_Fornecedor;
        this.Id_Saida = Id_Saida;
    }

    public int getId_Fornecedor() {
        return Id_Fornecedor;
    }

    public void setId_Fornecedor(int id_Fornecedor) {
        this.Id_Fornecedor = id_Fornecedor;
    }

    public int getId_Saida() {
        return Id_Saida;
    }

    public void setId_Saida(int id_Saida) {
        this.Id_Saida = id_Saida;
    }
}
