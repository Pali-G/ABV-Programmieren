// while loop, each round 1 Year
// random numbers
// print out numbers *enter for next Year
import java.util.Scanner;
import java.util.Random;

public class simulation {

  public static void main(String[] args) {
    // Attribute
    Scanner scn = new Scanner(System.in);
    Random dice = new Random();

    int Anzahlhaeuser = 20;
    int WohnungenBewohnt;
    char yesno;
    int Hausnummer;
    int jahr = 1998;
    int AGr = 100;
    /*
    boolean gebaut = true / false;
    boolean WohnungenBewohnt = true / false;
    int Anzahlwohnungen = 8;
    boolean[] wohnungen;*/

    System.out.println("Jahr:" + jahr + ", Beginnen Sie das nächste Jahr mit der Eingabe: y");
    yesno = scn.next().charAt(0);

      while (yesno == 'y') {
        int j = jahr+1;


        for (Hausnummer=1;Hausnummer<=1;Hausnummer++) {
          Anzahlhaeuser = Anzahlhaeuser + dice.nextInt(5);
          System.out.println (Anzahlhaeuser + " Häuser");
        }
        for (int i=1;i <= Anzahlhaeuser; i++) {
          WohnungenBewohnt = dice.nextInt(8);
          System.out.println (" Haus " + i + " hat "+ WohnungenBewohnt + " bewohnte Wohnungen");
        }

        System.out.println("Jahr: " + j + ", Beginnen Sie das nächste Jahr mit der Eingabe: y");
        yesno = scn.next().charAt(0);
      }
  }

}
