package uebung5;

import java.util.Random;

import uebung5.Haus;

public class Stadt {

	public Stadt() {

	}

	public int[] Wohnungsstatistik(Haus[] haus) {
		int[] whnstats = new int[2];
		for (int i = 0; i < haus.length; i++) {
			whnstats[0] += haus[i].wohnungen.length;
			for (int j = 0; j < haus[i].wohnungen.length; j++) {
				if (haus[i].Hgebaut == true) {
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
		meldeamt[0] = new Random().nextInt(whnstats[0] / 3);// herziehenden Haushalte
		meldeamt[1] = new Random().nextInt(whnstats[0] / 4);// wegziehende Haushalte
		return meldeamt;
	}

	public Haus[] Wohnraumanpassen(Haus[] haus, Strasse strasse[], int[] meldeamt, int[] whnstats, int jahr) {
		for (int i = 0; i < meldeamt[1]; i++) {// Ausziehen
			int[] mieter = Rausschmiss(haus);
			haus[mieter[0]].wohnungen[mieter[1]] = false;
		}
		int FreieWhn = whnstats[0] - whnstats[1];// Freie Wohnungen
		int benWhn = meldeamt[0] - meldeamt[1];// benötigte Wohnungen
		if (benWhn < 0) {
			benWhn = 0;
		}
		int Whnbauen = FreieWhn - benWhn;
		if (Whnbauen < 0) {
			haus = Wohnraumschaffen(haus, Whnbauen);
		}

		return haus;
	}

	public int[] Rausschmiss(Haus[] haus) {
		int[] mieter = new int[2];
		for (int k = 0; k < haus.length; k++) {
			for (int j = 0; j < haus[k].AnWohn; j++) {
				if (haus[k].wohnungen[j] == true) {
					mieter[0] = k;
					mieter[1] = j;
					return mieter;
				}
			}
		}
		return mieter;
	}

	public Haus[] Wohnraumschaffen(Haus[] haus, int Whnbauen) {
		while (Whnbauen > 0) {
			int[] HN = Grundstückfinden(haus);
			if (HN[0] < 0) {
				//haus = Strassebauen(haus);
				
			}
		}
		return haus;
	}

	public int[] Grundstückfinden(Haus[] haus) {
		int[] HN = new int[2];
		HN[0] = -1; // UNBEDINGT UNBEDINGT ÜBERPRÜFEN!!!
		for (int i = 0; i < haus.length; i++) {
			if (haus[i].Hgebaut == false) {
				HN[0] = haus[i].Hnr;
				HN[1] = haus[i].Strnr;
				break;
			}
		}
		return HN;
	}

	/*public Haus[] Strassebauen(Haus[] haus) {
		int AnzGr = new Random().nextInt(20) + 10;
		
	}*/
}
