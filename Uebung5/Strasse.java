package uebung5;

import java.util.Random;

public class Strasse {
	int Strassennummer;
	int AnzahlGrundst�cke;
	Haus[] H�user;
	
	public Strasse (int StN, int AGr, int Jahr) {
		this.Strassennummer = StN;
		this.AnzahlGrundst�cke = AGr;
		Haus[] H�user = new Haus[AGr];
		for (int j = 0; j < AGr; j++) {
			int Anzahlwohnungen = new Random().nextInt(20) + 1;
			int Hausnummer = j+1;
			int Baujahr = Jahr - new Random().nextInt(60);
			boolean gebaut = new Random().nextBoolean();
			H�user[j] = new Haus(Anzahlwohnungen, Hausnummer, Baujahr, gebaut);
		}	
		this.H�user = H�user;
	}
	public int Grbebaut (Haus[] H�user) {
		int Grbebaut = 0;
		for (int i = 0; i <H�user.length; i++) {
			if (H�user[i].Hgebaut==true) {
				Grbebaut++;
			}
		}
		return Grbebaut;
	}
	
}
