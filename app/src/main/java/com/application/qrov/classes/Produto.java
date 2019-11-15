package com.application.qrov.classes;

import java.util.ArrayList;

public class Produto {

    public static ArrayList<Produto> produtos = new ArrayList<>();

    private int id;
    private String nome;
    private String fornecedor; //cnpj
    private int unidadeSaida;
    private double minimo;
    private double quantidade;
    private String localizacao;
    private String descricao;
    private String QRCode;

    public Produto() {
        produtos.add(this);
    }

    public Produto(int id, String nome, String fornecedor, int unidadeSaida, double minimo, double quantidade, String localizacao, String descricao) {
        this.id = id;
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.unidadeSaida = unidadeSaida;
        this.minimo = minimo;
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.QRCode = toString();

        produtos.add(this);
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

    public int getUnidadeSaida() {
        return unidadeSaida;
    }

    public void setUnidadeSaida(int unidadeSaida) {
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

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode() {
        this.QRCode = toString();
    }

    @Override
    public String toString() {
        return "Produto" +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nFornecedor (CNPJ): " + fornecedor +
                "\nUnidade de saída: " + unidadeSaida +
                "\nEstoque mínimo: " + minimo +
                "\nQuantidade: " + quantidade +
                "\nLoalização: " + localizacao +
                "\nDescrição: " + descricao;
    }
}
