import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Produto[] p = new Produto[5];




        p[0] = new Produto("arroz", "arroz branco", 2);
        p[1] = new Produto("feijao", "feijao carioca", 4);
        p[2] = new Produto("caixa de chocolate", "caixa de chocolate da garoto", 1);
        p[3] = new Produto("coca cola", "refrigerante cola cola", 3);
        p[4] = new Produto("oleo", "lata de oleo 2 litros", 1);


            System.out.println(p[4].toString());
            System.out.println(p[2].toString());
            System.out.println(p[0].toString());
            System.out.println(p[3].toString());
            System.out.println(p[1].toString());








    }
}