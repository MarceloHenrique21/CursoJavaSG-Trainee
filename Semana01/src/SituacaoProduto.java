    public enum SituacaoProduto{
        ATIVO("Ativo"),
        Inativo("Inativo");

        private final String label;

        SituacaoProduto(String label){
            this.label = label;
        }

        public String getLabel(){
            return this.label;
        }
    }

