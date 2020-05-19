
import java.util.Scanner;
import java.util.Random;

public class simulation {

  public static void main(String[] args) {
    // Attribute
    Scanner scn = new Scanner(System.in);//Eingabe
    Random dice = new Random();//zufällige Zahl

    char yesno;
    int Anzahlhaeuser = 20;//Start-Wert Häuser
    int WohnungenBewohnt;
    int AGr = 100;// AnzahlGrundstücke
    int jahr = 1998;//Start Jahr
    int Baujahr = 1970;


    System.out.println("Jahr:" + jahr + ", Beginnen Sie das nächste Jahr mit der Eingabe: y");
    yesno = scn.next().charAt(0);

    //while schleife, symbolisiert ein Jahr
    while (yesno == 'y') {

      int j = jahr ++; //Jahres Zähler

      //gebaute Häuser
      for (int x=1;x<=1;x++) {
        Anzahlhaeuser = Anzahlhaeuser + dice.nextInt(3);
        System.out.println (Anzahlhaeuser + " gebaute Häuser von " + AGr + " Grundstücken");
      }

      // Haus Eigenschaften
      for (int i=1;i <= Anzahlhaeuser; i++) {
        WohnungenBewohnt = dice.nextInt(8);
        int Bj = j - new Random().nextInt(60);
        System.out.println (" Hausnummer " + i + " hat "+ WohnungenBewohnt + " bewohnte Wohnungen und wurde: " + Bj + " erbaut");

      }

      System.out.println("Das Jahr: " + j + " endet , Beginnen Sie das nächste Jahr mit der Eingabe: y");
      yesno = scn.next().charAt(0); //neues Jahr
    }
  }

}
