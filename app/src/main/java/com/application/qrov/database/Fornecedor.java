package com.application.qrov.database;

public class Fornecedor {

    private int CNPJ;
    private String Nome;
    private String Email;
    private int IE;
    private int Telefone1;
    private int Telefone2;
    private int CEP;
    private String UF;
    private String Bairro;
    private String Cidade;
    private String Rua;
    private int Num;

    public Fornecedor() {
    }

    public Fornecedor(int CNPJ, String nome, String email, int IE, int telefone1, int telefone2, int CEP, String UF, String bairro, String cidade, String rua, int num) {
        this.CNPJ = CNPJ;
        this.Nome = nome;
        this.Email = email;
        this.IE = IE;
        this.Telefone1 = telefone1;
        this.Telefone2 = telefone2;
        this.CEP = CEP;
        this.UF = UF;
        this.Bairro = bairro;
        this.Cidade = cidade;
        this.Rua = rua;
        this.Num = num;
    }

    public Fornecedor(String nome, String email, int IE, int telefone1, int telefone2, int CEP, String UF, String bairro, String cidade, String rua, int num) {
        this.Nome = nome;
        this.Email = email;
        this.IE = IE;
        this.Telefone1 = telefone1;
        this.Telefone2 = telefone2;
        this.CEP = CEP;
        this.UF = UF;
        this.Bairro = bairro;
        this.Cidade = cidade;
        this.Rua = rua;
        this.Num = num;
    }

    public int getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public int getIE() {
        return IE;
    }

    public void setIE(int IE) {
        this.IE = IE;
    }

    public int getTelefone1() {
        return Telefone1;
    }

    public void setTelefone1(int telefone1) {
        this.Telefone1 = telefone1;
    }

    public int getTelefone2() {
        return Telefone2;
    }

    public void setTelefone2(int telefone2) {
        this.Telefone2 = telefone2;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        this.Bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        this.Cidade = cidade;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        this.Rua = rua;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        this.Num = num;
    }
}
