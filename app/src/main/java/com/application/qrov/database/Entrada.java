package com.application.qrov.database;

import java.sql.Date;

public class Entrada {

    private int Id_Entrada;
    private int Chave_Acesso;
    private float Valor_Total;
    private Date Data_Entrada;
    private int Id_Fornecedor;

    public Entrada() {
    }

    public Entrada(int Id_Entrada, int Chave_Acesso, float Valor_Total, Date Data_Entrada, int Id_Fornecedor) {
        this.Id_Entrada = Id_Entrada;
        this.Chave_Acesso = Chave_Acesso;
        this.Valor_Total = Valor_Total;
        this.Data_Entrada = Data_Entrada;
        this.Id_Fornecedor = Id_Fornecedor;
    }

    public Entrada(int Chave_Acesso, float Valor_Total, Date Data_Entrada, int Id_Fornecedor) {
        this.Chave_Acesso = Chave_Acesso;
        this.Valor_Total = Valor_Total;
        this.Data_Entrada = Data_Entrada;
        this.Id_Fornecedor = Id_Fornecedor;
    }

    public int getId_Entrada() {
        return Id_Entrada;
    }

    public void setId_Entrada(int id_Entrada) {
        this.Id_Entrada = id_Entrada;
    }

    public int getChave_Acesso() {
        return Chave_Acesso;
    }

    public void setChave_Acesso(int chave_Acesso) {
        this.Chave_Acesso = chave_Acesso;
    }

    public float getValor_Total() {
        return Valor_Total;
    }

    public void setValor_Total(float valor_Total) {
        this.Valor_Total = valor_Total;
    }

    public Date getData_Entrada() {
        return Data_Entrada;
    }

    public void setData_Entrada(Date data_Entrada) {
        this.Data_Entrada = data_Entrada;
    }

    public int getId_Fornecedor() {
        return Id_Fornecedor;
    }

    public void setId_Fornecedor(int id_Fornecedor) {
        this.Id_Fornecedor = id_Fornecedor;
    }
}
