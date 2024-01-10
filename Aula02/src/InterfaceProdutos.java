public interface InterfaceProdutos {

    public void AdicionarProduto(Produto p);
    public void AtivarProdutos(int id);

    public void InativarProdutos(int id);

    public void AdicionarEstoque(int id, int qtdeEstoqueAdd);

    public void RetirarEstoque(int id, int qtdeEstoqueRemover);

}