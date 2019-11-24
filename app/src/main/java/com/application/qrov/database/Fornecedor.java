package com.application.qrov.database;

public class Fornecedor {

    private int cnpj;
    private String nome;
    private String email;
    private int ie;
    private int telefone1;
    private int telefone2;
    private int cep;
    private String uf;
    private String bairro;
    private String cidade;
    private String rua;
    private int num;

    public Fornecedor(int cnpj, String nome, String email, int ie, int telefone1, int telefone2, int cep, String uf, String bairro, String cidade, String rua, int num) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.email = email;
        this.ie = ie;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cep = cep;
        this.uf = uf;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.num = num;
    }

    public Fornecedor(String nome, String email, int ie, int telefone1, int telefone2, int cep, String uf, String bairro, String cidade, String rua, int num) {
        this.nome = nome;
        this.email = email;
        this.ie = ie;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cep = cep;
        this.uf = uf;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.num = num;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIe() {
        return ie;
    }

    public void setIe(int ie) {
        this.ie = ie;
    }

    public int getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(int telefone1) {
        this.telefone1 = telefone1;
    }

    public int getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(int telefone2) {
        this.telefone2 = telefone2;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
