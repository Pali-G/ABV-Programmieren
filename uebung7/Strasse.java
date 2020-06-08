package uebung7;

import java.util.Random;
import java.util.Vector;

public class Strasse {
	int Strassennummer;
	int AnzahlGrundst�cke;
	Hochhaus[] Hh�user;
	Einfamilienhaus[] Eh�user;
	
	public Strasse (int StN, int AGr, int Jahr) {
		this.Strassennummer = StN;
		this.AnzahlGrundst�cke = AGr;
		Hochhaus[] hh�user = new Hochhaus[AGr/2+AGr%2];
		Einfamilienhaus[] eh�user = new Einfamilienhaus[AGr/2];
		for (int j = 0; j < AGr; j++) {
				int Hausnummer = j+1;
				int Baujahr = Jahr - new Random().nextInt(60);
				boolean gebaut = new Random().nextBoolean();
				if(j%2 == 0 ) {
					int Anzahlwohnungenh = new Random().nextInt(20) + 1;
					hh�user[j/2] = new Hochhaus(Anzahlwohnungenh, Hausnummer, Baujahr, gebaut);
				}else {
					int Anzahlwohnungene = new Random().nextInt(1) + 1;
					eh�user[j/2] = new Einfamilienhaus(Anzahlwohnungene, Hausnummer, Baujahr, gebaut);
				}
	
			
		}
		this.Hh�user = hh�user; 
		this.Eh�user = eh�user;
	}
	public int Grbebaut () {
		int Grbebaut = 0;
		for (int i = 0; i < Hh�user.length; i++) {
			if (Hh�user[i].Hgebaut==true) {
				Grbebaut++;
			}
		}
		for (int i = 0; i < Eh�user.length; i++) {
			if (Eh�user[i].Hgebaut==true) {
				Grbebaut++;
			}
		}
		return Grbebaut;
	}
	
}