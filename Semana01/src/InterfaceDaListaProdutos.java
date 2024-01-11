import java.util.Optional;

public interface InterfaceDaListaProdutos {
    public void AdicionarProduto(Produto p);
    public void Apresentar();
    public Optional<Produto> Localizar (int id);
    public void BuscarPorId(int id);
    public void AdicionarEstoque (int id, int qtdeAdd);
    public void RemoverEstoque (int id, int qtdeRem);
    public void OrdenarPorNome();
    public void OrdenarPorIdCrescente();
    public void OrdenarPorQuantidadeEstoqueMaior();
    public void OrdenarPorQuantidadeEstoqueMenor();
    public void FiltrarAtivos();
    public void FiltrarInativos();
    public void FiltrarComEstoque();
    public void FiltrarSemEstoque();
    public boolean DeletarProduto(int id);
}
