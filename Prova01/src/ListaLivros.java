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

    public static void alugarLivro(int id){
        Optional<Livro> l = LocalizarId(id);

        if (l.isEmpty()) {
            System.out.println("esse livro nao foi encontrado");
        } else {
            List<Livro> livrosAtivos = listaLivros.stream()
                    .filter(Livro::isAtivo)
                    .collect(Collectors.toList());

            if (livrosAtivos.isEmpty()) {
                System.out.println("Esse livro não esta ativo");
            } else {
                alugado++;
              // ??  listaLivros.stream().filter(livro -> livro.setQtdeAlugada(alugado));
                System.out.println("Livro alugado");
            }
        }
    }

    public static void devolverLivro(int id){
        Optional<Livro> l = LocalizarId(id);

        if (l.isEmpty()) {
            System.out.println("esse livro nao foi encontrado");
        } else {
            List<Livro> livrosAtivos = listaLivros.stream()
                    .filter(Livro::isAtivo)
                    .collect(Collectors.toList());

            if (livrosAtivos.isEmpty()) {
                System.out.println("Esse livro não esta ativo");
            } else {
                alugado++;
                System.out.println("devolvido");
            }
        }

    }

    public static boolean removerLivro(int id){
    Optional<Livro> livroOptional = LocalizarId(id);

        if(livroOptional.isPresent()){
            listaLivros.remove(livroOptional.get());
            return true;
        }
            else {
            return false;
            }
    }
}
