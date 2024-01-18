public enum SituacaoLivro {
    ATIVO("Ativo"),
    Inativo("Inativo");

    private final String label;

    SituacaoLivro(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
