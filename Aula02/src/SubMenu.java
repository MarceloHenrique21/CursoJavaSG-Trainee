import java.util.Scanner;

public class SubMenu {
    public static void MenuListagem(ListaProdutos lista) {
        Scanner s = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 10) {

            System.out.println(
                    "\n1 - Ordem crescente de código" +
                            "\n2 - Ordem alfabética" +
                            "\n3 - Ordem de quantidade de estoque maior" +
                            "\n4 - Ordem de quantidade de estoque menor" +
                            "\n5 - Somente ativos" +
                            "\n6 - Somente inativos" +
                            "\n7 - Somente com estoque" +
                            "\n8 - Somente sem estoque" +
                            "\n9 - Filtrando por nome" +
                            "\n10 - voltar" +
                            "\nDigite uma das opções: ");
            opcao = s.nextInt();

            switch (opcao) {

                case 1:
                    lista.OrdenarPorIdCrescente();
                    break;

                case 2:
                    lista.OrdenarPorNome();
                    break;

                case 3:
                    lista.OrdenarPorQuantidadeEstoqueMaior();
                    break;

                case 4:
                    lista.OrdenarPorQuantidadeEstoqueMenor();
                    break;

                case 5:
                    lista.FiltrarAtivos();
                    break;

                case 6:
                    lista.FiltrarInativos();
                    break;

                case 7:
                    lista.FiltrarComEstoque();
                    break;

                case 8:
                    lista.FiltrarSemEstoque();
                    break;

                case 9:
                    Scanner s9 = new Scanner(System.in);
                    System.out.println("Digite o nome do produto: ");
                    String nome = s9.next();

                    lista.FiltrarNome(nome);
                    break;

                case 10:
                    break;
            }
        }
    }
}
