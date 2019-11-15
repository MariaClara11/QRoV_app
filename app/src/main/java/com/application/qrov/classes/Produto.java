package com.application.qrov.classes;

import java.util.ArrayList;

public class Produto {

    public static ArrayList<Produto> produtos = new ArrayList<>();

    private int id;
    private String nome;
    private String fornecedor; //cnpj
    private String unidadeSaida;
    private double minimo;
    private double quantidade;
    private String localizacao;
    private String descricao;

    public Produto() {
    }

    public Produto(int id, String nome, String fornecedor, String unidadeSaida, double minimo, double quantidade, String localizacao, String descricao) {
        this.id = id;
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.unidadeSaida = unidadeSaida;
        this.minimo = minimo;
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getUnidadeSaida() {
        return unidadeSaida;
    }

    public void setUnidadeSaida(String unidadeSaida) {
        this.unidadeSaida = unidadeSaida;
    }

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\nFornecedor (CNPJ): " + getFornecedor() +
                "\nUnidade de saída: " + getUnidadeSaida() +
                "\nEstoque mínimo: " + getMinimo() +
                "\nQuantidade: " + getQuantidade() +
                "\nLoalização: " + getLocalizacao() +
                "\nDescrição: " + getDescricao();
    }

    public String QRCode() {
        return "\nID: " + getId() +
                "\nNome: " + getNome() +
                "\nFornecedor (CNPJ): " + getFornecedor() +
                "\nUnidade de saída: " + getUnidadeSaida() +
                "\nLoalização: " + getLocalizacao() +
                "\nDescrição: " + getDescricao();
    }

}
