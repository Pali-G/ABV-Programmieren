package uebung4;
import java.util.Random;


public class Haus{
    
    static int Anzahlwohnungen;//static nur solange bis diese Variablen nicht mehr direkt von der mainfunction aufgerufen werden
    int Hausnummer;//Grundstücknummer
    int Baujahr;
    boolean Hausbewohnt;// true ist bewohnt, false ist leer
    boolean gebaut;//true ist gebaut
    static boolean[] wohnungen;//sh. Anzahlwohnungen
    //evtl Strasse

    //Konstruktor Klasse Haus
    public Haus(int AW ,int HN, int BJ, boolean geb){
	this.Anzahlwohnungen = AW;//So wird der Variable Hausnummer im Konstruktor ein wert zugeordnet
	this.Hausnummer = HN;
	this.Baujahr = BJ;
	this.gebaut = geb;
	Haus.wohnungen = defwohnungen(Anzahlwohnungen);
    }

    //Funktion zur eingabe von welche Wohnungen besetzt sind
    public static boolean[] defwohnungen(int Anzahlwohnungen){
	boolean[] wng = new boolean[Anzahlwohnungen];
	for (int i = 0; i < Anzahlwohnungen; i++){
	    wng[i] = new Random().nextBoolean();
	}
	return wng;
    }
    
    public static boolean WohnungenLeer(boolean[] wohnungen, int Anzahlwohnungen){//boolean[] wohnungen, int Anzahlwohnungen
	int bewohnt = 0;
	boolean leer = false;
	for (int i = 0; i <= wohnungen.length -1; i++){
	    if (wohnungen[i] == true){
		bewohnt++;
	    }
	}
	
	//System.out.println("Es sind " + bewohnt + " von " + Anzahlwohnungen + " bewohnt");
	if (bewohnt == 0){
	    leer = true;
	}
	return leer;
    }

}
