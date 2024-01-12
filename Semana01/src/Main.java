import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaProdutos lista = new ListaProdutos();
        Scanner scanner = new Scanner(System.in);
        int opcao = 100;

        while (opcao != 0) {
            exibirMenu();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    ListaProdutos.Apresentar();
                    break;

                case 2:
                    cadastrarProduto(scanner, lista);
                    break;

                case 3:
                    ativarProduto(scanner, lista);
                    break;

                case 4:
                    inativarProduto(scanner, lista);
                    break;

                case 5:
                    adicionarEstoque(scanner, lista);
                    break;

                case 6:
                    removerEstoque(scanner, lista);
                    break;

                case 7:
                    buscarPorId(scanner, lista);
                    break;

                case 8:
                    SubMenu.MenuListagem(lista);
                    break;

                case 9:
                    deletarProduto(scanner, lista);
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
                        "\n1  - Visualizar todos os produtos" +
                        "\n2  - Cadastrar um produto" +
                        "\n3  - Ativar um produto" +
                        "\n4  - Inativar um produto" +
                        "\n5  - Adicionar estoque a um produto" +
                        "\n6  - Retirar estoque de um produto" +
                        "\n7  - Buscar um produto" +
                        "\n8  - opcoes para listar os produtos" +
                        "\n9 - deletar um produto" +
                        "\n0  - sair" +
                        "\nDigite uma das opções: ");
    }

    private static void cadastrarProduto(Scanner scanner, ListaProdutos lista) {

        System.out.println("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.println("Digite a quantidade em estoque: ");
        int quantidadeEstoque = Integer.parseInt(scanner.nextLine());



        Produto produto = new Produto(nomeProduto, quantidadeEstoque);
        ListaProdutos.AdicionarProduto(produto);
    }

    private static void ativarProduto(Scanner scanner, ListaProdutos lista) {
        System.out.println("Digite o ID do produto: ");
        int idAtivar = Integer.parseInt(scanner.nextLine());

        ListaProdutos.Localizar(idAtivar).ifPresentOrElse(
                produto -> {
                    produto.AtivarProdutos();
                    System.out.println("Produto ativado");
                },
                () -> System.out.println("Produto não localizado")
        );
    }

    private static void inativarProduto(Scanner scanner, ListaProdutos lista) {
        System.out.println("Digite o ID do produto: ");
        int idInativar = Integer.parseInt(scanner.nextLine());

        ListaProdutos.Localizar(idInativar).ifPresentOrElse(
                produto -> {
                    produto.InativarProdutos();
                    System.out.println("Produto inativado com sucesso!");
                },
                () -> System.out.println("Produto não localizado")
        );
    }

    private static void adicionarEstoque(Scanner scanner, ListaProdutos lista) {
        System.out.println("Digite o ID do produto: ");
        int idAdicionarEstoque = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a quantidade de estoque que deseja adicionar: ");
        int qtdeAdicionarEstoque = Integer.parseInt(scanner.nextLine());

        ListaProdutos.AdicionarEstoque(idAdicionarEstoque, qtdeAdicionarEstoque);
    }

    private static void removerEstoque(Scanner scanner, ListaProdutos lista) {
        System.out.println("Digite o ID do produto: ");
        int idRemoverEstoque = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite a quantidade de estoque que deseja remover: ");
        int qtdeRemoverEstoque = Integer.parseInt(scanner.nextLine());

        ListaProdutos.RemoverEstoque(idRemoverEstoque, qtdeRemoverEstoque);
    }

    private static void buscarPorId(Scanner scanner, ListaProdutos lista) {
        System.out.println("Digite o ID do produto: ");
        int idBuscar = Integer.parseInt(scanner.nextLine());

        ListaProdutos.BuscarPorId(idBuscar);
    }

    private static void deletarProduto(Scanner scanner, ListaProdutos lista) {
        System.out.println("Digite o ID do produto que deseja excluir: ");
        int idDeletar = Integer.parseInt(scanner.nextLine());

        boolean sucesso = lista.DeletarProduto(idDeletar);

        if (sucesso) {
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não localizado. Exclusão não realizada.");
        }
    }
}

