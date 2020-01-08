package com.application.qrov.util;

public class Opcao {

    private final int iconId;
    private final String opcao;

    public Opcao(int iconId, String opcao) {
        this.iconId = iconId;
        this.opcao = opcao;
    }

    public int getIconId() {
        return iconId;
    }

    public String getOpcao() {
        return opcao;
    }

}
