package uebung5;

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
				int Baujahr = Jahr - new Random().nextInt(66);
				boolean gebaut = new Random().nextBoolean();
				if(j%2 == 0 ) {
					int Anzahlwohnungenh = new Random().nextInt(20) + 2;
					hh�user[j/2] = new Hochhaus(Anzahlwohnungenh, Hausnummer, Baujahr, gebaut);
				}else {
					int Anzahlwohnungene = 1;
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
	public Einfamilienhaus[] WreckingBallE(int jahr) {
		for (int i = 0; i < Eh�user.length; i++) {
			if (Eh�user[i].Hgebaut == true && Eh�user[i].Hausleer(Eh�user[i]) == true && Eh�user[i].Baujahr < (jahr-60)) {
				Eh�user[i].Hgebaut = false;
				Eh�user[i].Habgerissen = true;
				Eh�user[i].AnWohn = 0;
				Eh�user[i].Baujahr = 0000;
				Eh�user[i].wohnungen = Eh�user[i].defwohnungen(Eh�user[i].AnWohn, Eh�user[i].Hgebaut);
				//System.out.println("Ein Haus wurde abgerissen" + Eh�user[i].Baujahr);
			}
		}
		return Eh�user;
	}
	public Hochhaus[] WreckingBallH(int jahr) {
		for (int i = 0; i < Hh�user.length; i++) {
			if (Hh�user[i].Hgebaut == true && Hh�user[i].Hausleer(Hh�user[i]) == true && Hh�user[i].Baujahr < (jahr-60)) {
				Hh�user[i].Hgebaut = false;
				Hh�user[i].Habgerissen = true;
				Hh�user[i].AnWohn = 0;
				Hh�user[i].Baujahr = 0000;
				Hh�user[i].wohnungen = Hh�user[i].defwohnungen(Hh�user[i].AnWohn, Hh�user[i].Hgebaut);
				//System.out.println("Ein Haus wurde abgerissen" + haus[i].Baujahr);
			}
		}
		return Hh�user;
	}
}
