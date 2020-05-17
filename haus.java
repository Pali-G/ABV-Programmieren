public class haus{

  // Attribute
  static int Anzahlwohnungen;
  int Hausnummer;//Grundstücknummer
  int Baujahr;
  boolean Hausbewohnt;// true ist bewohnt, false ist leer
  boolean gebaut;//true ist gebaut
  static boolean[] wohnungen;
  //evtl Strasse

  //Konstruktor Klasse Haus
  public Haus(int AW ,int HN, int BJ, boolean HL, boolean geb){
    this.Anzahlwohnungen = AW;//So wird der Variable Hausnummer im Konstruktor ein wert zugeordnet
    this.Hausnummer = HN;
    this.Baujahr = BJ;
    this.Hausbewohnt = HL;
    this.gebaut = geb;
    this.wohnungen = defwohnungen(Anzahlwohnungen);
  }

  //Konstruktor aufrufen

  /*
    public static void main(String[] args){
        haus myObj.Anzahlwohnungen = new haus(5);
        haus myObj.WohnungenBewohnt = new haus (3);
        System.out.println("Freie Wohnungen = " + (myObj.Anzahlwohnungen - myObj.WohnungenBewohnt));
    }
  */

  public static void main (String[] args){
    /*int x = 5;
    boolean[] w = new boolean[5];
    w[0] = true;
    w[1] = false;
    w[2] = false;
    w[3] = false;
    w[4] = true;
    boolean k = WohnungenBewohnt(w, x);
    System.out.println(k);*/
    //Haus Haus1 = new Haus(4);// 1, 1998, true
    //System.out.println(Haus1.WohnungenBewohnt());
    Haus Haus1 = new Haus(5,1,1998,true,true);
    Haus1.WohnungenBewohnt(wohnungen, Anzahlwohnungen);
  }

  //Funktion zur eingabe von welche Wohnungen besetzt sind
  public static boolean[] defwohnungen(int Anzahlwohnungen){
    boolean[] wng = new boolean[Anzahlwohnungen];
    System.out.println("Geben sie true oder false ein um die Wohnunge zu besetzen");
    for (int i = 0; i < Anzahlwohnungen; i++){
        System.out.println("Wohnung " + i);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.contains("t") == true){
          wng[i] = true;
        }else if(input.contains("f") == true){
          wng[i] = false;
        }
    }
    return wng;
  }

  public static boolean WohnungenBewohnt(boolean[] wohnungen, int Anzahlwohnungen){//boolean[] wohnungen, int Anzahlwohnungen
    int bewohnt = 0;
    boolean leer = false;
    for (int i = 0; i <= wohnungen.length -1; i++){
      if (wohnungen[i] == true){
        bewohnt++;
      }
    }
    System.out.println("Es sind " + bewohnt + " von " + Anzahlwohnungen + " bewohnt");
    if (bewohnt == 0){
      leer = true;
    }
    return leer;
  }
}
