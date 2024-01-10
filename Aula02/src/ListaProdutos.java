import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListaProdutos implements InterfaceDaListaProdutos{
    private List<Produto> ListaProdutos = new ArrayList<>();

    public void AdicionarProduto(Produto p){
        ListaProdutos.add(p);
    }
    public void Apresentar(){
        System.out.println(this.ListaProdutos);
    }
    public Optional<Produto> Localizar (int id){
        return ListaProdutos.stream().filter(produto -> produto.getId()==id).findFirst();
    }
    public void BuscarPorId(int id){
        Optional<Produto> p = Localizar(id);
        System.out.println(p);
    }
    public void AdicionarEstoque (int id, int qtdeAdd){
       Optional<Produto> p = Localizar(id);
         if (p.isEmpty()) {
           System.out.println("Produto não localizado");
         }else{
           p.get().AdicionarEstoque(qtdeAdd);
         }
    }
    public void RemoverEstoque (int id, int qtdeRem){
        Optional<Produto> p = Localizar(id);
        if(p.isEmpty()){
            System.out.println("...");
        }else{
            p.get().RetirarEstoque(qtdeRem);
        }
    }
}
