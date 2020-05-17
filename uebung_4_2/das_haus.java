/*
Haus:
  //Attribute
  Anzahlwohnungen;
  Hausnummer;//Grundstücknummer
  Baujahr;
  Hausbewohnt;// true ist bewohnt, false ist leer
  gebaut;//true ist gebaut
  wohnungen;

  //Methoden
  Anzahl bewohnte wohnungen;
  Anzahl unbewohnte Wohnungen;
  Anzahl Wohnungen;

  Alter > 50 => Haus abreisen
*/

package uebung_4_2;

public class das_haus{

  // Attribute
  static int Anzahlwohnungen;//static nur solange bis diese Variablen nicht mehr direkt von der mainfunction aufgerufen werden
  int Hausnummer;//Grundstücknummer
  static int Baujahr;
  boolean Hausbewohnt;// true ist bewohnt, false ist leer
  static boolean gebaut;//true ist gebaut
  static boolean[] wohnungen;//sh. Anzahlwohnungen
  //evtl Strasse

  //Konstruktor Klasse Haus
  public das_haus(int AW ,int HN, int BJ, boolean HL, boolean geb) {
    this.Anzahlwohnungen = AW;//So wird der Variable Hausnummer im Konstruktor ein wert zugeordnet
    this.Hausnummer = HN;
    this.Baujahr = BJ;
    this.Hausbewohnt = HL;
    this.gebaut = geb;
    this.wohnungen = defwohnungen(Anzahlwohnungen);
  }


}
