public class Produto {
    private String descricao;
    private int  estoque;
    private String nome;

    public Produto(String nome, String descricao, int estoque) {
        this.descricao = descricao;
        this.estoque = estoque;
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Produto {\n"
                +"nome= " + nome +
                "\ndescricao= " + descricao +
                ",\nestoque= " + estoque +

                "\n}";
    }
}
