import java.util.*;
import java.util.stream.Collectors;

public class ListaLivros {
    static List<Livro> listaLivros = new ArrayList<>();
    private static int proximoCod = 1;

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

    public static void alugarLivro(){
        List<Livro> livrosAtivos = listaLivros.stream()
                .filter(Livro::isAtivo)
                .collect(Collectors.toList());

        if (livrosAtivos.isEmpty()) {
            System.out.println("Esse livro não esta ativo");
        } else {
                livrosAtivos.stream().filter(livro -> livro.getQtdeAlugada() == livro.getQtdeAlugada()+1);
                livrosAtivos.stream().filter(livro -> livro.getQtdeDisponivel() == livro.getQtdeDisponivel()-1);
                System.out.println("Livro alugado");
        }
    }

    public static void devolverLivro(){
       List<Livro> livrosAtivos = listaLivros.stream()
                .filter(Livro::isAtivo)
                .collect(Collectors.toList());

        if (livrosAtivos.isEmpty()) {
            System.out.println("esse livro não foi alugado ou esta inativo");
        } else {
            livrosAtivos.stream().filter(livro -> livro.getQtdeDisponivel() == livro.getQtdeDisponivel() + 1);
            livrosAtivos.stream().filter(livro -> livro.getQtdeAlugada() == livro.getQtdeAlugada() - 1);
            System.out.println("Livro devolvido");
        }

    }

    public static void removerLivro(int id){
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
