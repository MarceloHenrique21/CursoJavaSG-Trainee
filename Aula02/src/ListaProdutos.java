import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ListaProdutos {
    private static List<Produto> listaProdutos = new ArrayList<>();

    public static void AdicionarProduto(Produto p){
        listaProdutos.add(p);
        System.out.println(listaProdutos);
    }
    public static void Apresentar(){
        System.out.println(listaProdutos);
    }
    public static Optional<Produto> Localizar (int id){
        return listaProdutos.stream().
                filter(produto -> produto.getId()==id).findFirst();
    }
    public static List<Produto>  LocalizarNome (String nome, List<Produto> listaProdutos) {
        System.out.println("##");
        System.out.println(listaProdutos);
        List<Produto> listaProd = listaProdutos.stream().filter((produto -> produto.getNome().contains(nome))).collect(Collectors.toList());
        System.out.println("--------------");
        System.out.println(listaProd);
        return listaProd;
    }
    public static void BuscarPorId(int id){
        Optional<Produto> p = Localizar(id);
        System.out.println(p);
    }
    public void FiltrarNome(String nome, List<Produto> lista){
       List<Produto> p = LocalizarNome(nome, lista);
        System.out.println(p);
    }
    public static void AdicionarEstoque (int id, int qtdeAdd){
       Optional<Produto> p = Localizar(id);
         if (p.isEmpty()) {
           System.out.println("Produto não localizado");
         }else{
           p.get().AdicionarEstoque(qtdeAdd);
         }
    }
    public static void RemoverEstoque (int id, int qtdeRem){
        Optional<Produto> p = Localizar(id);
        if(p.isEmpty()){
            System.out.println("Produto não localizado");
        }else{
            p.get().RetirarEstoque(qtdeRem);
        }
    }
}
