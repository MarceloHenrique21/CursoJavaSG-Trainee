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

            /*
            p[x].setNome(nome);
            p[x].setDescricao(descricao);
            p[x].setEstoque(estoque);
            */

            Produto p = new Produto(nome, descricao, estoque);
            lista.add(p);
        }
        List<Produto> listaOrdenada = lista.stream().sorted(Comparator.comparing(Produto::getEstoque)).toList();
        listaOrdenada.forEach((produto ->
                System.out.println("produto: " + produto.getNome() + "| descrição: " + produto.getDescricao() + "|estoque: " + produto.getEstoque())
                ));
//        Comparator<Produto> ProdutoEstoqueComparator = Comparator.comparingInt(Produto::getEstoque);
//        Arrays.sort(lista, ProdutoEstoqueComparator);

    }

}


/*

        p[1] = new Produto("feijao", "feijao carioca", 4);
        p[2] = new Produto("caixa de chocolate", "caixa de chocolate da garoto", 1);
        p[3] = new Produto("coca cola", "refrigerante cola cola", 3);
        p[4] = new Produto("oleo", "lata de oleo 2 litros", 1);
    */