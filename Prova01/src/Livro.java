import java.util.Date;

public class Livro {
    private int codigo;
    private String nome;
    private Date data;
    private int qtdeTotal;
    private int qtdeDisponivel;
    private int qtdeAlugada;
    private SituacaoLivro situacao;
    private SituacaoAluguel situacaoDoAluguel;

    public Livro( String nome, int qtdeTotal) {
        this.codigo = codigo;
        this.nome = nome;
        this.data = new Date();
        this.qtdeTotal = qtdeTotal;
        this.qtdeDisponivel = qtdeTotal;
        this.qtdeAlugada = 0;
        this.situacao = SituacaoLivro.ATIVO;
        this.situacaoDoAluguel = SituacaoAluguel.NaoAlugado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void AtivarLivro() {this.situacao = SituacaoLivro.ATIVO;}
    public void InativarLivro() {this.situacao = SituacaoLivro.Inativo;}
    public boolean isAtivo() {return situacao == SituacaoLivro.ATIVO;}

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQtdeTotal() {
        return qtdeTotal;
    }

    public void setQtdeTotal(int qtdeTotal) {
        this.qtdeTotal = qtdeTotal;
    }

    public int getQtdeDisponivel() {
        return qtdeDisponivel;
    }

    public void setQtdeDisponivel(int qtdeDisponivel) {
        this.qtdeDisponivel = qtdeDisponivel;
    }

    public int getQtdeAlugada() {
        return qtdeAlugada;
    }

    public void setQtdeAlugada(int qtdeAlugada) {
        this.qtdeAlugada = qtdeAlugada;
    }

    public SituacaoAluguel getSituacaoDoAluguel() {return situacaoDoAluguel; }

    public void setSituacaoDoAluguel(SituacaoAluguel situacaoDoAluguel) {this.situacaoDoAluguel = situacaoDoAluguel; }

    @Override
    public String toString() {
        return  "\ncodigo: " + codigo +
                "\nnome: " + nome + '\'' +
                "\nSituacao: " + situacao +
                "\nsituação do aluguel: " + situacaoDoAluguel +
                "\ndata de cadastro: " + data +
                "\nquantidade total: " + qtdeTotal +
                "\nquantidade disponivel: " + qtdeDisponivel +
                "\nquantidade alugada=" + qtdeAlugada;
    }
}
