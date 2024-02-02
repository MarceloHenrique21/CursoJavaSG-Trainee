package com.lanchonete.lanchonete.StatusProduto;

public enum StatusProduto {
    NAOFABRICAVEL("NaoFabricavel"),
    FABRICAVEL("Fabricavel"),
    JAFABRICADO("JaFabricado");

    private final String label;

    StatusProduto(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
