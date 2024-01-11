/*

* visualiar produtos
* cadastrar produtos
* ativar/inativar produtos
* adicionar estoque
* retirar estoque

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Integer opcao = 0;

         while (opcao != 9){
             Scanner s = new Scanner(System.in);



             System.out.println(
                     "\n1 - visualizar produtos" +
                             "\n2 - Cadastrar produto" +
                             "\n3 - ativar produto" +
                             "\n4 - inativar produto" +
                             "\n5 - adicionar estoque" +
                             "\n6 - retirar estoque" +
                             "\n7 - Buscar somente um produto por id"+
                             "\n8 - listar" +
                             "\n9 - sair" +
                             "\nDigite uma das opções: ");


             opcao = Integer.parseInt(s.nextLine());
             //ListaProdutos lista = new ListaProdutos();

            switch (opcao){

                 case 1:
                    ListaProdutos.Apresentar();
                    break;

                  case 2:
                    Scanner s2 = new Scanner(System.in);

                    System.out.println("Digite o nome do seu produto: ");
                    String nome = s2.nextLine();

                    System.out.println("Digite a quantidade em estoque: ");
                    int qtdeEstoque = s2.nextInt();

                    System.out.println("Digite o id do produto: ");
                    int id = s2.nextInt();

                    Produto p = new Produto(nome, qtdeEstoque, id);
                    ListaProdutos.AdicionarProduto(p);
                    break;

                 case 3:
                    Scanner s3 = new Scanner(System.in);

                    System.out.println("Digite o id do produto: ");
                     id = s3.nextInt();

                     ListaProdutos.Localizar(id).ifPresentOrElse(
                             produto ->{
                                 produto.AtivarProdutos();
                                 System.out.println("Produto ativado");
                             },
                             () ->  System.out.println("Produto nao localizado")
                     );
                    break;

                 case 4:
                     Scanner s4 = new Scanner(System.in);

                     System.out.println("Digite o id do produto: ");
                     id = s4.nextInt();

                     ListaProdutos.Localizar(id).ifPresentOrElse(
                             produto -> {
                                 produto.InativarProdutos();
                                 System.out.println("Produto inativado com sucesso!");
                             },
                             () ->  System.out.println("Produto nao localizado")
                     );
                    break;

                 case 5:
                     Scanner s5 = new Scanner(System.in);

                     System.out.println("Digite o id do produto: ");
                     id = s5.nextInt();

                     System.out.println("Digite a quantidade de estoque que deseja adicionar: ");
                     int qtdeAdd = s5.nextInt();

                     ListaProdutos.AdicionarEstoque(id, qtdeAdd);
                    break;


                 case 6:
                     Scanner s6 = new Scanner(System.in);

                     System.out.println("Digite o id do produto: ");
                     id = s6.nextInt();

                     System.out.println("Digite a quantidade de estoque que deseja remover: ");
                     int qtdeEstoqueRemover = s6.nextInt();

                     ListaProdutos.RemoverEstoque(id, qtdeEstoqueRemover);
                    break;

                case 7:

                    Scanner s7 = new Scanner(System.in);
                    System.out.println("Digite o id do produto: ");
                    id = s7.nextInt();

                    ListaProdutos.BuscarPorId(id);
                    break;

                 case 8:
                     Scanner s8 = new Scanner(System.in);

                     SubMenu.MenuListagem();
//                        MenuListagem(lista);
                    break;

                case 9:
                    break;
               }
         }
    }
}