package com.Biblioteca.Biblioteca.Situacao;

public enum SituacaoLivro {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private final String label;

    SituacaoLivro(String label){
        this.label = label;
    }

    public String getLabel(){ return this.label; }
}
