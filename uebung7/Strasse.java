package uebung7;

import java.util.Random;
import java.util.Vector;

public class Strasse {
	int Strassennummer;
	int AnzahlGrundstücke;
	Hochhaus[] Hhäuser;
	Einfamilienhaus[] Ehäuser;
	
	public Strasse (int StN, int AGr, int Jahr) {
		this.Strassennummer = StN;
		this.AnzahlGrundstücke = AGr;
		Hochhaus[] hhäuser = new Hochhaus[AGr/2+AGr%2];
		Einfamilienhaus[] ehäuser = new Einfamilienhaus[AGr/2];
		for (int j = 0; j < AGr; j++) {
				int Hausnummer = j+1;
				int Baujahr = Jahr - new Random().nextInt(60);
				boolean gebaut = new Random().nextBoolean();
				if(j%2 == 0 ) {
					int Anzahlwohnungenh = new Random().nextInt(20) + 1;
					hhäuser[j/2] = new Hochhaus(Anzahlwohnungenh, Hausnummer, Baujahr, gebaut);
				}else {
					int Anzahlwohnungene = new Random().nextInt(1) + 1;
					ehäuser[j/2] = new Einfamilienhaus(Anzahlwohnungene, Hausnummer, Baujahr, gebaut);
				}
	
			
		}
		this.Hhäuser = hhäuser; 
		this.Ehäuser = ehäuser;
	}
	public int Grbebaut () {
		int Grbebaut = 0;
		for (int i = 0; i < Hhäuser.length; i++) {
			if (Hhäuser[i].Hgebaut==true) {
				Grbebaut++;
			}
		}
		for (int i = 0; i < Ehäuser.length; i++) {
			if (Ehäuser[i].Hgebaut==true) {
				Grbebaut++;
			}
		}
		return Grbebaut;
	}
	
}