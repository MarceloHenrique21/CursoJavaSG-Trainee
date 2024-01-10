public class Produto {

    private int id;
    private String nome;
    private int estoque;
    private boolean ativo;

    public Produto(String nome, int estoque, int id) {
        this.nome = nome;
        this.estoque = estoque;
        this.id = id;
        this.ativo = true;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean isAtivo() {
        return ativo = true;
    }

    public void setAtivo() {
        this.ativo = false;
    }

    public void AtivarProdutos(int id) {
        this.ativo = true;
    }


    public void InativarProdutos(int id) {
        this.ativo = false;
    }


    public void AdicionarEstoque(int qtdeEstoqueAdd) {
        this.estoque = estoque + qtdeEstoqueAdd;
    }


    public void RetirarEstoque(int qtdeEstoqueRemover) {
        this.estoque = estoque - qtdeEstoqueRemover;
    }

    @Override
    public String toString() {
        return "\nnome: " + nome + '\'' +
                "\nid: "+id+
                "\nqtde em estoque: " + estoque +
                "\nsituação do produto: "+ativo+
                "\n\n";
    }
}
