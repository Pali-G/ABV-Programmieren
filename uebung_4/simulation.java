// while loop, each round 1 Year
// random numbers
// print out numbers *enter for next Year

import java.util.Random;

public class simulation {

  public static void main(String[] args) {
    // Attribute
    Random dice = new Random();
    int Anzahlhaeuser = 20;
    int WohnungenBewohnt;
    char yesno;
    int Hausnummer = 100;
    int jahr = 1998
    /*int Baujahr;
    boolean gebaut = true / false;
    boolean WohnungenBewohnt = true / false;
    int Anzahlwohnungen = 8;
    boolean[] wohnungen;*/

    /*public simulation(int AW ,int HN, int BJ, boolean HL, boolean geb) {
      this.Hausnummer = HN;
      this.Baujahr = BJ;
      this.gebaut = geb;
      this.Hausbewohnt = HL;
      this.Anzahlwohnungen = AW;
      this.wohnungen = defwohnungen(Anzahlwohnungen);

    }*/
    System.out.println("Jahr : 1998, Beginnen Sie das nächste Jahr mit der Eingabe: y");
    yesno = scn.next().charAt(0);

      while (yesno == 'y') {

        for (int counter=1;counter<=100; counter++) {
          Anzahlhaeuser = Anzahlhaeuser + dice.nextInt(5);
          System.out.println (Anzahlhaeuser + " Häuser");
        }
        for (int i=1;i <= Anzahlhaeuser; i++) {
          WohnungenBewohnt = dice.nextInt(8);
          System.out.println (" Haus " + counter + " hat "+ WohnungenBewohnt + " bewohnte Wohnungen");
        }

        System.out.println("Jahr" + jahr + ", Beginnen Sie das nächste Jahr mit der Eingabe: y");
        yesno = scn.next().charAt(0);
      }
  }

}



/*
für jedes Jahr eine ANzahl an Häusern und deren anzahl an bewohnten Wohnungen
+ ein Jahr  */
