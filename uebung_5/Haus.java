package uebung_5;

import java.util.Random;

public class Haus {
    
	int AnWohn;
	int Strnr;
	int Hnr;// Grundstücknummer
	int Baujahr;
	int Hausart;
	//boolean Hbewohnt;// true ist bewohnt, false ist leer
	boolean Hgebaut;// true ist gebaut
	boolean[] wohnungen;// sh. Anzahlwohnungen
	boolean Feuertreppe;
	

// Konstruktor Klasse Haus
	public Haus(int AW, int HN, int BJ, boolean geb, int St, int HA, boolean FT) {
		this.AnWohn = AW;
		this.Strnr = St;
		this.Hnr = HN;
		this.Baujahr = BJ;
		this.Hgebaut = geb;
		this.wohnungen = defwohnungen(AnWohn, Hgebaut);
		this.Hausart = HA;
		this.Feuertreppe = FT;
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
