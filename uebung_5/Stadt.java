package uebung_5;

import java.util.Random;

public class Stadt {

	public Stadt() {

	}

	public int[] Wohnungsstatistik(Haus[] haus) {
		int[] whnstats = new int[2];
		for (int i = 0; i < haus.length; i++) {
			if (haus[i].Hgebaut == true) {
				whnstats[0] += haus[i].wohnungen.length;
				for (int j = 0; j < haus[i].wohnungen.length; j++) {
					if (haus[i].wohnungen[j] == true) {
						whnstats[1]++;
					}
				}
			}
		}
		return whnstats;
	}

	public int[] Meldeamt(int[] whnstats) {
		int[] meldeamt = new int[2];
		meldeamt[0] = new Random().nextInt(100);// herziehenden Haushalte
		meldeamt[1] = new Random().nextInt(whnstats[1]);// wegziehende Haushalte
		return meldeamt;
	}

	public Haus[] Wohnraumanpassen(Haus[] haus, Strasse[] strasse, int[] meldeamt, int[] whnstats, int jahr) {
		for (int i = 0; i < meldeamt[1]; i++) {// Ausziehen
			int[] mieter = Rausschmiss(haus);
			haus[mieter[0]].wohnungen[mieter[1]] = false;
		}
		int FreieWhn = whnstats[0] - whnstats[1];// Freie Wohnungen
		int benWhn = meldeamt[0] - meldeamt[1];// benoetigte Wohnungen
		if (benWhn < 0) {
			benWhn = 0;
		}
		int Whnbauen = FreieWhn - benWhn;
		if (Whnbauen < 0) {
			haus = Wohnraumschaffen(haus, strasse, Math.abs(Whnbauen), jahr);
		}
		for (int i = 0; i < meldeamt[0]; i++) {
			int[] mieter = Einziehen(haus);
			// System.out.println("Mieter: " + mieter[0] + mieter[1]);
			haus[mieter[0]].wohnungen[mieter[1]] = true;
			// System.out.println("Wohnung: " + haus[mieter[0]].wohnungen[mieter[1]]);
		}
		return haus;
	}

	public int[] Rausschmiss(Haus[] haus) {
		int[] mieter = new int[2];
		for (int k = 0; k < haus.length; k++) {
			for (int j = 0; j < haus[k].AnWohn; j++) {
				if (haus[k].Hgebaut == true) {
					if (haus[k].wohnungen[j] == true) {
						mieter[0] = k;
						mieter[1] = j;
						return mieter;
					}
				}
			}
		}
		return mieter;
	}

	public int[] Einziehen(Haus[] haus) {
		int[] mieter = new int[2];
		for (int k = 0; k < haus.length; k++) {
			if (haus[k].Hgebaut == true) {
				for (int j = 0; j < haus[k].AnWohn; j++) {
					if (haus[k].wohnungen[j] == false) {
						// System.out.println("Bevor: " + haus[k].wohnungen[j]);
						mieter[0] = k;
						mieter[1] = j;
						return mieter;
					}
				}
			}
		}
		return mieter;
	}

	public Haus[] Wohnraumschaffen(Haus[] haus, Strasse[] strasse, int Whnbauen, int jahr) {
		while (0<Whnbauen) {
			int HN = Grundstueckfinden(haus);
			if (HN < 0) {
				haus = Strassebauen(haus, strasse);
				HN = Grundstueckfinden(haus);
			}
			haus[HN] = Hausbauen(haus[HN], jahr);
			Whnbauen -= haus[HN].AnWohn;
		}
		return haus;
	}

	public int Grundstueckfinden(Haus[] haus) {
		int HN;
		HN = -1; // UNBEDINGT UNBEDINGT ueBERPRueFEN!!!
		for (int i = 0; i < haus.length; i++) {
			if (haus[i].Hgebaut == false) {
				HN = i;
				break;
			}
		}
		return HN;
	}

	public Haus[] Strassebauen(Haus[] haus, Strasse[] strasse) {
		int AnzGr = new Random().nextInt(20) + 10;
		for (int i = 0; i < AnzGr; i++) {
			int AnWohn = 0;
			int Hnr = i;
			int Baujahr = 0000;
			boolean Hgebaut = false;
			Haus[] htmp = new Haus[haus.length + 1];
			for (int j = 0; j < haus.length; j++) {
				htmp[j] = haus[j];
			}
			htmp[haus.length] = new Haus(AnWohn, Hnr, Baujahr, Hgebaut, strasse.length);
			haus = htmp;
		}
		return haus;
	}

	public Haus Hausbauen(Haus haus, int jahr) {
		haus.AnWohn = new Random().nextInt(20) + 1;
		haus.Baujahr = jahr;
		haus.Hgebaut = true;
		haus.wohnungen = Haus.defwohnungen(haus.AnWohn, haus.Hgebaut);
		return haus;
	}

	public Strasse[] Strassenverzeichnis(Haus[] haus, Strasse[] strasse) {
		int strassenanzahl = 0;
		for (int i = 0; i<haus.length; i++) {
			if (haus[i].Strnr > strassenanzahl) {
				strassenanzahl = haus[i].Strnr;
			}
		}
		Strasse[] strtmp = new Strasse[strassenanzahl];
		for (int j = 0; j<strtmp.length;j++) {
			strtmp[j] = new Strasse(j);
		}
		strasse = strtmp;
		return strasse;
	}
}
