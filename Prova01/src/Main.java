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

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

    }

    private static void deletarLivro(Scanner scanner, ListaLivros lista) {

        System.out.println("Digite o codigo do produto que deseja excluir: ");
        int idDeletar = Integer.parseInt(scanner.nextLine());

        boolean sucesso = lista. (idDeletar);

        if (sucesso) {
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não localizado. Exclusão não realizada.");
        }
    }
}