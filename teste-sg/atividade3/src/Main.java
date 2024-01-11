import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("digite 3 palavras separadas por virgula, ex: 'vertebrado, ave, carnivoro': ");
        String sequencia = s.nextLine();

    //    System.out.println(sequencia);

       String sequencia1 = "vertebrado, ave, carnivoro"; //aguia
       String sequencia2 = "vertebrado, ave, onivoro"; //pomba

       String sequencia3 = "vertebrado, mamifero, onivoro";   //homem
       String sequencia4 = "vertebrado, mamifero, herbivoro"; //vaca

       String sequencia5 = "invertebrado, inseto, hematofago"; //pulga
       String sequencia6 = "invertebrado, inseto, herbivoro"; //lagarta

       String sequencia7 = "invertebrado, anelideo, hematofago"; //sanguesuga
       String sequencia8 = "invertebrado, anelideo, onivoro"; //minhoca



      if (sequencia.equals(sequencia1)){
          System.out.println("aguia");
      } else if (sequencia.equals(sequencia2)) {
          System.out.println("pomba");
      } else if (sequencia.equals(sequencia3)) {
          System.out.println("homem");
      } else if (sequencia.equals(sequencia4)) {
          System.out.println("vaca");
      } else if (sequencia.equals(sequencia5)) {
          System.out.println("pulga");
      } else if (sequencia.equals(sequencia6)) {
          System.out.println("lagarta");
      } else if (sequencia.equals(sequencia7)) {
          System.out.println("sanguesuga");
      } else if (sequencia.equals(sequencia8)) {
          System.out.println("minhoca");
      }else{
          System.out.println("digite uma sequencia valida!");
      }
    }
}