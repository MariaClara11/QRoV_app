package com.application.qrov.util;

public class Opcao {

    private int iconId;
    private String opcao;

    public Opcao() {
    }

    public Opcao(int iconId, String opcao) {
        this.iconId = iconId;
        this.opcao = opcao;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }
}
