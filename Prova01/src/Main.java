import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaLivros lista = new ListaLivros();

        Scanner scanner = new Scanner(System.in);

        int opcao = 100;

        while (opcao != 0) {
            exibirMenu();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner, lista);
                    break;

                case 2:
                    ListaLivros.apresentarLivrosOrdemAlfabetica();
                    break;

                case 3:
                    apresentarLivrosNome(scanner, lista);
                    break;

                case 4:
                   alugarLivro(scanner, lista);
                    break;

                case 5:
                    devolverLivro(scanner, lista);
                    break;

                case 6:
                    removerLivro(scanner, lista);
                    break;

                case 7:
                    inativarLivro(scanner, lista);
                    break;

                case 8:
                    AtivarLivro(scanner, lista);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

    }

    private static void exibirMenu() {
        System.out.print(
                        "\n1  - cadastrar livro" +
                        "\n2  - apresentar livro em ordem alfabetica" +
                        "\n3  - apresentar livros por nome" +
                        "\n4  - alugar livro" +
                        "\n5  - devolver livro" +
                        "\n6  - excluir livro" +
                        "\n7 -  inativar livro" +
                        "\n8 -  ativar livro"+
                        "\n0  - sair" +
                        "\nDigite uma das opções: ");
    }

    private static void cadastrarLivro(Scanner scanner, ListaLivros lista) {

        System.out.println("Digite o nome do livro: ");
        String nome = scanner.nextLine();

        System.out.println("Digite a quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        Livro livro = new Livro(nome, quantidade);
        ListaLivros.cadastrarLivros(livro);

    }

    public static void inativarLivro(Scanner scanner, ListaLivros lista){
        System.out.println("Digite o codigo do livro que deseja inativar: ");
        int CodInativar = Integer.parseInt(scanner.nextLine());

        ListaLivros.LocalizarId(CodInativar).ifPresentOrElse(
               livro -> {
                    livro.InativarLivro();
                    System.out.println("Produto inativado com sucesso!");
                },
                () -> System.out.println("Produto não localizado")
        );
    }

    public static void AtivarLivro(Scanner scanner, ListaLivros lista){
        System.out.println("Digite o codigo do livro que deseja ativar: ");
        int CodAtivar = Integer.parseInt(scanner.nextLine());

        ListaLivros.LocalizarId(CodAtivar).ifPresentOrElse(
                livro -> {
                    livro.AtivarLivro();
                    System.out.println("Produto inativado com sucesso!");
                },
                () -> System.out.println("Produto não localizado")
        );
    }

    public static void apresentarLivrosNome(Scanner scanner, ListaLivros lista){

        System.out.println("Digite o nome do livro: ");
        String nome = scanner.nextLine();

        ListaLivros.ApresentarLivrosPorNome(nome);
    }

    public static void alugarLivro(Scanner scanner, ListaLivros lista){

        System.out.println("digite o codigo do livro: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        ListaLivros.alugarLivro(codigo);
    }

    public static void devolverLivro(Scanner scanner, ListaLivros lista){

        System.out.println("digite o codigo do livro: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        ListaLivros.devolverLivro(codigo);
    }

    private static void removerLivro(Scanner scanner, ListaLivros lista) {

        System.out.println("Digite o codigo do produto que deseja excluir: ");
        int cod = Integer.parseInt(scanner.nextLine());

        boolean sucesso = ListaLivros.removerLivro(cod);

        if (sucesso) {
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não localizado. Exclusão não realizada.");
        }
    }
}