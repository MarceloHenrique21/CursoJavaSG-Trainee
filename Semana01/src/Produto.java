import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.util.Date;

public class Produto{
    private int id;
    private String nome;
    private int estoque;
    private SituacaoProduto situacao;
    private Date data;

    public Produto(String nome, int estoque) {
        this.nome = nome;
        this.estoque = estoque;
        this.id = id;
        this.situacao = situacao.ATIVO;
        this.data = new Date();
    }

    public Date getData() {return data;}

    public void setData(Date data) {this.data = data;}

    public boolean isAtivo() {return situacao == SituacaoProduto.ATIVO;}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {this.nome = nome;}
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public SituacaoProduto getSituacao() {return situacao;}
    public void setSituacao(SituacaoProduto situacao) {this.situacao = situacao;}

    public void AtivarProdutos() {this.situacao = SituacaoProduto.ATIVO;}
    public void InativarProdutos() {this.situacao = SituacaoProduto.Inativo;}
    public void AdicionarEstoque(int qtdeEstoqueAdd) {
        this.estoque = estoque + qtdeEstoqueAdd;
    }
    public void RetirarEstoque(int qtdeEstoqueRemover) {
        this.estoque = estoque - qtdeEstoqueRemover;
    }

    @Override
    public String toString() {
        return "\nnome: " + nome +
                "\nid: "+ id +
                "\nqtde em estoque: " + estoque +
                "\nsituação do produto: " + situacao +
                "\ndata de cadastro: "+data+
                "\n\n";
    }
}
