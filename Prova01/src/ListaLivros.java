import java.util.*;
import java.util.stream.Collectors;

public class ListaLivros {
    private static List<Livro> listaLivros = new ArrayList<>();
    private static int proximoCod = 1;
    private static int alugado = 0;

    public static List<Livro> LocalizarNome(String nome) {
        return listaLivros.stream()
                .filter(produto -> produto.getNome().contains(nome))
                .collect(Collectors.toList());
    }

    public static Optional<Livro> LocalizarId(int id) {
        return listaLivros.stream()
                .filter(produto -> produto.getCodigo() == id)
                .findFirst();
    }
    public static void cadastrarLivros(Livro l){
        l.setCodigo(proximoCod);
        proximoCod++;
        listaLivros.add(l);
    }

    public static void apresentarLivrosOrdemAlfabetica(){
        Collections.sort(listaLivros, Comparator.comparing(Livro::getNome));
        System.out.println(listaLivros);
    }

    public static void ApresentarLivrosPorNome(String nome){
        List<Livro> l = LocalizarNome(nome);
        System.out.println(l);

    }


    public static void alugarLivro(int id) {
        Optional<Livro> livroOptional = LocalizarId(id);

        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();

            if (livro.isAtivo() && livro.getQtdeDisponivel() > 0) {
                livro.setQtdeDisponivel(livro.getQtdeDisponivel() - 1);
                livro.setQtdeAlugada(livro.getQtdeAlugada() + 1);
                livro.setSituacaoDoAluguel(SituacaoAluguel.Alugado);
                System.out.println("Livro alugado com sucesso!");
            } else {
                System.out.println("Livro não disponível para aluguel.");
            }
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public static void devolverLivro(int id) {
        Optional<Livro> livroOptional = LocalizarId(id);

        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();

            if (livro.isAtivo() && livro.getSituacaoDoAluguel() == SituacaoAluguel.Alugado) {
                livro.setQtdeDisponivel(livro.getQtdeDisponivel() + 1);
                livro.setQtdeAlugada(livro.getQtdeAlugada() - 1);
                livro.setSituacaoDoAluguel(SituacaoAluguel.NaoAlugado);
                System.out.println("Livro devolvido com sucesso!");
            } else {
                System.out.println("Livro não está alugado ou não está ativo.");
            }
        } else {
            System.out.println("Livro não encontrado.");
        }
    }


    public static boolean removerLivro(int id) {
        Optional<Livro> livroOptional = LocalizarId(id);

        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();

            if (livro.getSituacaoDoAluguel() == SituacaoAluguel.NaoAlugado) {
                listaLivros.remove(livro);
                return true;
            } else {
                System.out.println("Não é possível excluir um livro que está sendo alugado.");
                return false;
            }
        } else {
            System.out.println("Livro não encontrado.");
            return false;
        }
    }
}
