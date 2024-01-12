public enum SituacaoAluguel {
    Alugado("ALUGADO"),
    NaoAlugado("Nao Alugado");

    private final String label;

    SituacaoAluguel(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
