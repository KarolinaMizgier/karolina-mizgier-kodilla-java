package com.kodilla.patterns.builder.bigmac;

public enum Ingredients {
    SALATA("salata"),
    CEBULA("cebula"),
    BEKON("bekon"),
    OGOREK("ogorek"),
    PAPRYCZKI_CHILLI("papryczki chilli"),
    PIECZARKI("pieczarki"),
    SER("ser"),
    KREWETKI("krewetki");
    private String ingredient;

    Ingredients(String ingredient) {
        this.ingredient = ingredient;
    }

    public String value() {
        return ingredient;
    }
}
