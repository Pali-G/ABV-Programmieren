package uebung5;

import java.util.Random;

public class Strasse {
	int Strassennummer;
	int AnzahlGrundstücke;
	Haus[] Häuser;
	
	public Strasse (int StN, int AGr, int Jahr) {
		this.Strassennummer = StN;
		this.AnzahlGrundstücke = AGr;
		Haus[] Häuser = new Haus[AGr];
		for (int j = 0; j < AGr; j++) {
			int Anzahlwohnungen = new Random().nextInt(20) + 1;
			int Hausnummer = j+1;
			int Baujahr = Jahr - new Random().nextInt(60);
			boolean gebaut = new Random().nextBoolean();
			Häuser[j] = new Haus(Anzahlwohnungen, Hausnummer, Baujahr, gebaut);
		}	
		this.Häuser = Häuser;
	}
	public int Grbebaut (Haus[] Häuser) {
		int Grbebaut = 0;
		for (int i = 0; i <Häuser.length; i++) {
			if (Häuser[i].Hgebaut==true) {
				Grbebaut++;
			}
		}
		return Grbebaut;
	}
	
}
