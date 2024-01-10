import java.util.Optional;

public interface InterfaceDaListaProdutos {
    public void AdicionarProduto(Produto p);
    public void Apresentar();
    public Optional<Produto> Localizar (int id);
    public void BuscarPorId(int id);
    public void AdicionarEstoque (int id, int qtdeAdd);
    public void RemoverEstoque (int id, int qtdeRem);
}
