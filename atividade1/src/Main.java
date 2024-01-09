import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();
//    Produto[] p = new Produto[5];

        for(int x = 0; x < 5; x++) {
//            Produto p = new Produto();
            Scanner s = new Scanner(System.in);

            System.out.println("digite um nome: ");
            String nome = s.nextLine();

            System.out.println("digite uma descricao: ");
            String descricao = s.nextLine();

            System.out.println("digite a quantidade em estoque: ");
            int estoque = s.nextInt();

            Produto p = new Produto(nome, descricao, estoque);
            lista.add(p);
        }
        List<Produto> listaOrdenada = lista.stream().sorted(Comparator.comparing(Produto::getEstoque)).toList();
        listaOrdenada.forEach((produto ->
                System.out.println("produto: " + produto.getNome() + "| descrição: " + produto.getDescricao() + "|estoque: " + produto.getEstoque())
                ));
    }
}
//        Comparator<Produto> ProdutoEstoqueComparator = Comparator.comparingInt(Produto::getEstoque);
//        Arrays.sort(lista, ProdutoEstoqueComparator);
