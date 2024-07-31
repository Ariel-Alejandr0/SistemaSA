package com.example.loginauthapi.service.ru;

public enum Tipo {
    CAMISA(100),
    CALCA(100),
    MEIA(30),
    CAMISETA(100),
    SHORTS(80);

    private int centimetros;
    Tipo(int centimetros) {
        this.centimetros = centimetros;
    }

    public int getCentimetros() {
        return centimetros;
    }
}
