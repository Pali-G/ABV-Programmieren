package uebung_5;

import java.util.Random;

public class Haus {
                    
	int AnWohn;
	int Strnr;
	int Hnr;// Grundstücknummer
	int Baujahr;
	//boolean Hbewohnt;// true ist bewohnt, false ist leer
	boolean Hgebaut;// true ist gebaut
	boolean[] wohnungen;// sh. Anzahlwohnungen

// Konstruktor Klasse Haus
	public Haus(int AW, int HN, int BJ, boolean geb, int St) {
		this.AnWohn = AW;// So wird der Variable Hausnummer im Konstruktor ein wert zugeordnet
		this.Strnr =
		this.Hnr = HN;
		this.Baujahr = BJ;
		this.Hgebaut = geb;
		this.wohnungen = defwohnungen(AnWohn, Hgebaut);
	}

	public static boolean[] defwohnungen(int Anzahlwohnungen, boolean gebaut) {
		boolean[] wng = new boolean[Anzahlwohnungen];
		if (gebaut == true) {
  		for (int i = 0; i < Anzahlwohnungen; i++) {
  			wng[i] = new Random().nextBoolean();
		}
		}else {
			for (int i = 0; i < Anzahlwohnungen; i++) {
				wng[i] = false;
			}
		}
		return wng;
	}
}
