package com.application.qrov.database;

public class Usuario {

    private String Nome_Usuario;
    private String Senha;

    public Usuario() {
    }

    public Usuario(String nome_Usuario, String senha) {
        Nome_Usuario = nome_Usuario;
        Senha = senha;
    }

    public Usuario(String senha) {
        Senha = senha;
    }

    public String getNome_Usuario() {
        return Nome_Usuario;
    }

    public void setNome_Usuario(String nome_Usuario) {
        Nome_Usuario = nome_Usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
