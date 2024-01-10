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
        Scanner s = new Scanner(System.in);
        ListaProdutos lista = new ListaProdutos();

        int opcao = 0;

         while (opcao != 8){

             System.out.println(
                     "\n1 - visualizar produtos" +
                             "\n2 - Cadastrar produto" +
                             "\n3 - ativar produto" +
                             "\n4 - inativar produto" +
                             "\n5 - adicionar estoque" +
                             "\n6 - retirar estoque" +
                             "\n7 - Buscar somente um produto por id"+
                             "\nDigite uma das opções: ");
                              opcao = s.nextInt();

            switch (opcao){

                 // visualizar
                 case 1:
                    lista.Apresentar();
                    break;

                  //cadastrar
                  case 2:
                    Scanner s2 = new Scanner(System.in);

                    System.out.println("Digite o nome do seu produto: ");
                    String nome = s2.nextLine();

                    System.out.println("Digite a quantidade em estoque: ");
                    int qtdeEstoque = s2.nextInt();

                    System.out.println("Digite o id do produto: ");
                    int id = s2.nextInt();

                    Produto p = new Produto(nome, qtdeEstoque, id);
                    lista.AdicionarProduto(p);
                    break;


                  // ativar produto
                 case 3:
                    Scanner s3 = new Scanner(System.in);

                    System.out.println("Digite o id do produto: ");
                     id = s3.nextInt();

                    // p.AtivarProdutos(id);
                    break;


                 // inativar produto
                 case 4:
                     Scanner s4 = new Scanner(System.in);
                     boolean inativo = false;

                     System.out.println("Digite o id do produto: ");
                     id = s4.nextInt();


                    break;

                 //adicionar estoque
                 case 5:
                     Scanner s5 = new Scanner(System.in);

                     System.out.println("Digite o id do produto: ");
                     id = s5.nextInt();

                     System.out.println("Digite a quantidade de estoque que deseja adicionar: ");
                     int qtdeAdd = s5.nextInt();

                    lista.AdicionarEstoque(id, qtdeAdd);
                    break;

                 // retirar estoque
                 case 6:
                     Scanner s6 = new Scanner(System.in);

                     System.out.println("Digite o id do produto: ");
                     id = s6.nextInt();

                     System.out.println("Digite a quantidade de estoque que deseja remover: ");
                     int qtdeEstoqueRemover = s6.nextInt();

                    lista.RemoverEstoque(id, qtdeEstoqueRemover);
                    break;

                case 7:

                    Scanner s7 = new Scanner(System.in);
                    System.out.println("Digite o id do produto: ");
                    id = s7.nextInt();

                    lista.Localizar(id);
                    break;

                 case 8:
                    break;

               }
         }
    }
}