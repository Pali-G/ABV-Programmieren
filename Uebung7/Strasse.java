package uebung5;

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
				int Baujahr = Jahr - new Random().nextInt(66);
				boolean gebaut = new Random().nextBoolean();
				if(j%2 == 0 ) {
					int Anzahlwohnungenh = new Random().nextInt(20) + 2;
					hhäuser[j/2] = new Hochhaus(Anzahlwohnungenh, Hausnummer, Baujahr, gebaut);
				}else {
					int Anzahlwohnungene = 1;
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
	public Einfamilienhaus[] WreckingBallE(int jahr) {
		for (int i = 0; i < Ehäuser.length; i++) {
			if (Ehäuser[i].Hgebaut == true && Ehäuser[i].Hausleer(Ehäuser[i]) == true && Ehäuser[i].Baujahr < (jahr-60)) {
				Ehäuser[i].Hgebaut = false;
				Ehäuser[i].Habgerissen = true;
				Ehäuser[i].AnWohn = 0;
				Ehäuser[i].Baujahr = 0000;
				Ehäuser[i].wohnungen = Ehäuser[i].defwohnungen(Ehäuser[i].AnWohn, Ehäuser[i].Hgebaut);
				//System.out.println("Ein Haus wurde abgerissen" + Ehäuser[i].Baujahr);
			}
		}
		return Ehäuser;
	}
	public Hochhaus[] WreckingBallH(int jahr) {
		for (int i = 0; i < Hhäuser.length; i++) {
			if (Hhäuser[i].Hgebaut == true && Hhäuser[i].Hausleer(Hhäuser[i]) == true && Hhäuser[i].Baujahr < (jahr-60)) {
				Hhäuser[i].Hgebaut = false;
				Hhäuser[i].Habgerissen = true;
				Hhäuser[i].AnWohn = 0;
				Hhäuser[i].Baujahr = 0000;
				Hhäuser[i].wohnungen = Hhäuser[i].defwohnungen(Hhäuser[i].AnWohn, Hhäuser[i].Hgebaut);
				//System.out.println("Ein Haus wurde abgerissen" + haus[i].Baujahr);
			}
		}
		return Hhäuser;
	}
}
