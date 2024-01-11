import java.util.Scanner;

public class SubMenu {
    public static void MenuListagem(){
        Scanner s = new Scanner(System.in);
//        ListaProdutos lista = new ListaProdutos();

        int opcao = 0;

        while (opcao != 10){

            System.out.println(
                    "\n1 - ordem crescente de codigo" +
                            "\n2 - ordem alfabetica" +
                            "\n3 - ordem de quantidade de estoque maior" +
                            "\n4 - ordem de quantidade de estoque menor" +
                            "\n5 - somente ativos" +
                            "\n6 - somente inativos" +
                            "\n7 - somente com estoque"+
                            "\n8 - somente sem estoque" +
                            "\n9 - filtrando por nome" +
                            "\nDigite uma das opções: ");
            opcao = s.nextInt();

            switch (opcao){

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

                case 7:

                    break;

                case 8:

                    break;

                case 9:
                    Scanner s7 = new Scanner(System.in);
                    System.out.println("Digite o nome do produto: ");
                    String nome = s7.next();

                 //   lista.FiltrarNome(nome, lista);

                    break;

                case 10:
                    break;
            }
        }
    }
}
