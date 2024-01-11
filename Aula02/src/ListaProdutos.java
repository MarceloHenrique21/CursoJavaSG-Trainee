import java.util.*;
import java.util.stream.Collectors;

public class ListaProdutos {
    private static List<Produto> listaProdutos = new ArrayList<>();
    private static int proximoId = 1;
    public static void AdicionarProduto(Produto p) {
        p.setId(proximoId);
        proximoId++;
        listaProdutos.add(p);
    }

    public static void Apresentar() {
        System.out.println(listaProdutos);
    }

    public static Optional<Produto> Localizar(int id) {
        return listaProdutos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    public static List<Produto> LocalizarNome(String nome) {
        return listaProdutos.stream()
                .filter(produto -> produto.getNome().contains(nome))
                .collect(Collectors.toList());
    }

    public static void BuscarPorId(int id) {
        Optional<Produto> p = Localizar(id);
        System.out.println(p);
    }

    public void FiltrarNome(String nome) {
        List<Produto> p = LocalizarNome(nome);
        System.out.println(p);
    }

    public static void AdicionarEstoque(int id, int qtdeAdd) {
        Optional<Produto> p = Localizar(id);
        if (p.isEmpty()) {
            System.out.println("Produto não localizado");
        } else {
            p.get().AdicionarEstoque(qtdeAdd);
        }
    }

    public static void RemoverEstoque(int id, int qtdeRem) {
        Optional<Produto> p = Localizar(id);
        if (p.isEmpty()) {
            System.out.println("Produto não localizado");
        } else {
            p.get().RetirarEstoque(qtdeRem);
        }
    }
        public static void OrdenarPorNome() {
            Collections.sort(listaProdutos, Comparator.comparing(Produto::getNome));
            System.out.println(listaProdutos);
        }

        public static void OrdenarPorIdCrescente() {
            Collections.sort(listaProdutos, Comparator.comparingInt(Produto::getId));
            System.out.println(listaProdutos);
        }

        public static void OrdenarPorQuantidadeEstoqueMaior() {
        Collections.sort(listaProdutos, Comparator.comparingInt(Produto::getEstoque).reversed());
        System.out.println(listaProdutos);
        }

        public static void OrdenarPorQuantidadeEstoqueMenor() {
            Collections.sort(listaProdutos, Comparator.comparingInt(Produto::getEstoque));
            System.out.println(listaProdutos);
        }

        public static void FiltrarAtivos() {
            List<Produto> produtosAtivos = listaProdutos.stream()
                    .filter(Produto::isAtivo)
                    .collect(Collectors.toList());
            System.out.println(produtosAtivos);
        }

    public static void FiltrarInativos() {
        List<Produto> produtosInativos = listaProdutos.stream()
                .filter(produto -> !produto.isAtivo())
                .collect(Collectors.toList());

        if (produtosInativos.isEmpty()) {
            System.out.println("Não existem produtos inativos.");
        } else {
            System.out.println(produtosInativos);
        }
    }

    public static void FiltrarComEstoque() {
            List<Produto> produtosComEstoque = listaProdutos.stream()
                    .filter(produto -> produto.getEstoque() > 0)
                    .collect(Collectors.toList());
            System.out.println(produtosComEstoque);
        }

        public static void FiltrarSemEstoque() {
            List<Produto> produtosSemEstoque = listaProdutos.stream()
                    .filter(produto -> produto.getEstoque() == 0)
                    .collect(Collectors.toList());
            System.out.println(produtosSemEstoque);
        }
    public static boolean DeletarProduto(int id) {
        Optional<Produto> produtoOptional = Localizar(id);

        if (produtoOptional.isPresent()) {
            listaProdutos.remove(produtoOptional.get());
            return true;
        } else {
            return false;
        }
    }

}
