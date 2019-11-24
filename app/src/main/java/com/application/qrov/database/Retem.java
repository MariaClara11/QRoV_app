package com.application.qrov.database;

public class Retem {

    private int idFornecedor;
    private int idSaida;

    public Retem(int idFornecedor, int idSaida) {
        this.idFornecedor = idFornecedor;
        this.idSaida = idSaida;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getIdSaida() {
        return idSaida;
    }

    public void setIdSaida(int idSaida) {
        this.idSaida = idSaida;
    }
}
