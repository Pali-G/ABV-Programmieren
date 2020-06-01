package uebung6;

import java.util.Random;


public abstract class Haus<T>{

	int AnWohn;
	int Strnr;
	int Hnr;// Grundstücknummer
	int Baujahr;
	//boolean Hbewohnt;// true ist bewohnt, false ist leer
	boolean Hgebaut;// true ist gebaut
	boolean[] wohnungen;// sh. Anzahlwohnungen
	
	public boolean[] defwohnungen(int Anzahlwohnungen, boolean gebaut) {
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
