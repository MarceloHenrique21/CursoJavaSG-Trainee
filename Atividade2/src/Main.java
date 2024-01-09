import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int numApostado[] = new int[6];

        for (int x = 0; x<=6; x++){
            Scanner s = new Scanner(System.in);

            System.out.println("digite um numero de 1 a 99: ");
             numApostado[x] = s.nextInt();
        }

        
        double numA = Math.random() * 99;

        int N1 = (int) numA;

        double numB = Math.random() * 99;

        int N2 = (int) numB;


        double numC = Math.random() * 99;

        int N3 = (int) numC;

        double numD = Math.random() * 99;

        int N4 = (int) numD;


        double numE = Math.random() * 99;

        int N5 = (int) numE;

        double numF = Math.random() * 99;

        int N6 = (int) numF;


        System.out.println("Numeros escolhidos: "+numero1+ ", "+numero2+", "+numero3+", "+numero4+", "+numero5+", "+numero6);
        System.out.println("Numeros sorteados: "+N1+ ", "+N2+", "+N3+", "+N4+", "+N5+", "+N6);

        int acertos = 0;

        if (numero1 == N1 || numero1 == N2 || numero1 == N3 || numero1 == N4 || numero1 == N5 || numero1 == N6){
            acertos ++;
        } else if(numero2 == N1 || numero2 == N2 || numero2 == N3 || numero2 == N4 || numero2 == N5 || numero2 == N6){
            acertos ++;
        }else if(numero3 == N1 || numero3 == N2 || numero3 == N3 || numero3 == N4 || numero3 == N5 || numero3 == N6) {
            acertos ++;

        }else if(numero4 == N1 || numero4 == N2 || numero4 == N3 || numero4 == N4 || numero4 == N5 || numero4 == N6) {
            acertos++;

        }else if(numero5 == N1 || numero5 == N2 || numero5 == N3 || numero5 == N4 || numero5 == N5 || numero5 == N6){
            acertos++;

        }else if(numero6 == N1 || numero6  == N2 || numero6  == N3 || numero6  == N4 || numero6  == N5 || numero6  == N6) {
            acertos++;
        }else{
            System.out.println("voce nao acertou nenhum numero");
        }

        if (acertos == 1){
            System.out.println("voce nao ganhou nada");
        }else if (acertos == 2){
            System.out.println("voce nao ganhou nada");
        }else if (acertos == 3){
            System.out.println("voce acertou um terno, parabens!");
        }else if (acertos == 4){
            System.out.println("voce acertou uma quadra, parabens!");
        }else if(acertos == 5){
            System.out.println("voce acertou uma quina, parabens!");
        }else if(acertos == 6){
            System.out.println("voce acertou uma quina, parabens!");
        }




    }
}