package uebung7;

import java.util.Random;
//import java.util.Vector;

public class Strasse {
	int Strassennummer;
	int AnzahlGrundstücke;
	Hochhaus[] hochhaus;
	Einfamilienhaus[] einfamhaus;
	
	public Strasse (int StN, int AGr, int Jahr) {
		this.Strassennummer = StN;
		this.AnzahlGrundstücke = AGr;
		Hochhaus[] hochhaus = new Hochhaus[AGr/2+AGr%2];
		Einfamilienhaus[] einfamhaus = new Einfamilienhaus[AGr/2];
		for (int j = 0; j < AGr; j++) {
				int Hausnummer = j+1;
				int Baujahr = Jahr - new Random().nextInt(60);
				boolean gebaut = new Random().nextBoolean();
				if(j%2 == 0 ) {
					int Anzahlwohnungenh = new Random().nextInt(20) + 2;
					hochhaus[j/2] = new Hochhaus(Anzahlwohnungenh, Hausnummer, Baujahr, gebaut);
				}else {
					int Anzahlwohnungene = 1;
					einfamhaus[j/2] = new Einfamilienhaus(Anzahlwohnungene, Hausnummer, Baujahr, gebaut);
				}
	
			
		}
		this.hochhaus = hochhaus; 
		this.einfamhaus = einfamhaus;
	}
	public int Grbebaut () {
		int Grbebaut = 0;
		for (int i = 0; i < hochhaus.length; i++) {
			if (hochhaus[i].Hgebaut==true) {
				Grbebaut++;
			}
		}
		for (int i = 0; i < einfamhaus.length; i++) {
			if (einfamhaus[i].Hgebaut==true) {
				Grbebaut++;
			}
		}
		return Grbebaut;
	}
	
}