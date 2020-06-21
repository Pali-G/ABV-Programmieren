package uebung6;

import java.util.Random;
import java.util.Stack;

public class Stadt {

	public Stadt() {
	}
	Stack<Haus[]> stmp = new Stack<Haus[]>();

	public int[] Wohnungsstatistik(Hochhaus[] hochhaus, Einfamilienhaus[] einfamhaus) {
		int[] whnstats = new int[2];
		for (int i = 0; i < hochhaus.length; i++) {
			if (hochhaus[i].Hgebaut == true) {
				whnstats[0] += hochhaus[i].wohnungen.length;
				for (int j = 0; j < hochhaus[i].wohnungen.length; j++) {
					if (hochhaus[i].wohnungen[j] == true) {
						whnstats[1]++;
					}
				}
			}
		}
		for (int i = 0; i < einfamhaus.length; i++) {
			if (einfamhaus[i].Hgebaut == true) {
				whnstats[0] += einfamhaus[i].wohnungen.length;
				for (int j = 0; j < einfamhaus[i].wohnungen.length; j++) {
					if (einfamhaus[i].wohnungen[j] == true) {
						whnstats[1]++;
					}
				}
			}
		}
		return whnstats;
	}

	public int[] Meldeamt(int[] whnstats, int wegz, int hinz) {
		int[] meldeamt = new int[2];
		double tmp = whnstats[0]*((1.0*hinz)/100);
		int inttmp = (int) tmp;
		if (inttmp < 2) {inttmp = 2;}
		meldeamt[0] = new Random().nextInt(inttmp);// herziehenden Haushalte
		tmp = whnstats[1]*((1.0*wegz)/100);
		inttmp = (int) tmp;
		if (inttmp < 2) {inttmp = 210
				;}
		meldeamt[1] = new Random().nextInt(inttmp);// wegziehende Haushalte
		System.out.println(meldeamt[0]);
		System.out.println(meldeamt[1]);
		return meldeamt;
	}

	public void Wohnraumanpassen(Hochhaus[] hochhaus, Einfamilienhaus[] einfamhaus, Strasse[] strasse, int[] meldeamt,
			int[] whnstats, int jahr) {
		for (int i = 0; i < meldeamt[1]; i++) {// Ausziehen
			if (i % 2 == 0) {
				// System.out.println(i + "wegziehen");
				int[] mieter = HRausschmiss(hochhaus);
				hochhaus[mieter[0]].wohnungen[mieter[1]] = false;
			} else {
				// System.out.println(i + "wegziehen");
				int[] mieter = ERausschmiss(einfamhaus);
				einfamhaus[mieter[0]].wohnungen[mieter[1]] = false;
			}
		}
		hochhaus = Hochhaus.WreckingBall(hochhaus, jahr);
		einfamhaus = Einfamilienhaus.WreckingBall(einfamhaus, jahr);
		int FreieWhn = whnstats[0] - whnstats[1];// Freie Wohnungen
		int benWhn = meldeamt[0] - meldeamt[1];// benötigte Wohnungen
		if (benWhn < 0) {
			benWhn = 0;
		}
		int Whnbauen = (FreieWhn - benWhn) * 2;
		if (Whnbauen < 0) {
			Wohnraumschaffen(hochhaus, einfamhaus, strasse, Math.abs(Whnbauen), jahr);
			hochhaus = (Hochhaus[]) stmp.pop();
			einfamhaus = (Einfamilienhaus[]) stmp.pop();
		}
		for (int i = 0; i < meldeamt[0]; i++) {
			if (i % 2 == 0) {
				int[] mieterh = HEinziehen(hochhaus);
				hochhaus[mieterh[0]].wohnungen[mieterh[1]] = true;
			} else {
				int[] mietere = EEinziehen(einfamhaus);
				if (mietere[0] == -2) {
					int[] mieterh = HEinziehen(hochhaus);
					hochhaus[mieterh[0]].wohnungen[mieterh[1]] = true;
				} else {
					einfamhaus[mietere[0]].wohnungen[mietere[1]] = true;
				}
			}
		}
		stmp.push(einfamhaus);
		stmp.push(hochhaus);
		return;
	}

	public int[] HRausschmiss(Hochhaus[] haus) {
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

	public int[] ERausschmiss(Einfamilienhaus[] haus) {
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

	public int[] HEinziehen(Hochhaus[] haus) {
		int[] mieter = new int[2];
		for (int k = 0; k < haus.length; k++) {
			if (haus[k].Hgebaut == true) {
				for (int j = 0; j < haus[k].AnWohn; j++) {
					if (haus[k].wohnungen[j] == false) {
						mieter[0] = k;
						mieter[1] = j;
						return mieter;
					}
				}
			}
		}
		return mieter;
	}

	public int[] EEinziehen(Einfamilienhaus[] haus) {
		int[] mieter = new int[2];
		for (int k = 0; k < haus.length; k++) {
			if (haus[k].Hgebaut == true) {
				for (int j = 0; j < haus[k].AnWohn; j++) {
					if (haus[k].wohnungen[j] == false) {
						mieter[0] = k;
						mieter[1] = j;

						return mieter;
					}
				}
			}
		}
		mieter[0] = -2;
		return mieter;
	}

	public void Wohnraumschaffen(Hochhaus[] hochhaus, Einfamilienhaus[] einfamhaus, Strasse[] strasse, int Whnbauen,
			int jahr) {
		while (0 < Whnbauen) {
			int[] HN = Grundstückfinden(hochhaus, einfamhaus);
			if (HN[0] < 0) {
				Strassebauen(hochhaus, einfamhaus, strasse);
				hochhaus = (Hochhaus[]) stmp.pop();
				einfamhaus = (Einfamilienhaus[]) stmp.pop();
				HN = Grundstückfinden(hochhaus, einfamhaus);
			}
			if (HN[1] == 0) {
				hochhaus[HN[0]] = Hochhausbauen(hochhaus[HN[0]], jahr);
				Whnbauen -= hochhaus[HN[0]].AnWohn;
			} else if (HN[1] == 1) {
				einfamhaus[HN[0]] = Einfamilienhausbauen(einfamhaus[HN[0]], jahr);
				Whnbauen -= einfamhaus[HN[0]].AnWohn;
			}
		}
		stmp.push(einfamhaus);
		stmp.push(hochhaus);
		return;
	}

	public int[] Grundstückfinden(Hochhaus[] hochhaus, Einfamilienhaus[] einfamhaus) {
		int[] HN = new int[2];
		HN[0] = -1; // UNBEDINGT UNBEDINGT ÜBERPRÜFEN!!!
		for (int i = 0; i < einfamhaus.length; i++) {
			if (einfamhaus[i].Hgebaut == false) {
				HN[0] = i;
				HN[1] = 1;
				return HN;
			}
		}
		for (int i = 0; i < hochhaus.length; i++) {
			if (hochhaus[i].Hgebaut == false) {
				HN[0] = i;
				HN[1] = 0;
				return HN;
			}
		}
		return HN;
	}

	public void Strassebauen(Hochhaus[] hochhaus, Einfamilienhaus[] einfamhaus, Strasse[] strasse) {
		int AnzGr = new Random().nextInt(20) + 10;
		for (int i = 0; i < AnzGr; i++) {
			int AnWohn = 0;
			int Hnr = i;
			int Baujahr = 0000;
			boolean Hgebaut = false;
			if (i % 2 == 0) {
				Hochhaus[] hhtmp = new Hochhaus[hochhaus.length + 1];
				for (int j = 0; j < hochhaus.length; j++) {
					hhtmp[j] = hochhaus[j];
				}
				hhtmp[hochhaus.length] = new Hochhaus(AnWohn, Hnr, Baujahr, Hgebaut, strasse.length);
				hochhaus = hhtmp;
			} else {
				Einfamilienhaus[] ehtmp = new Einfamilienhaus[einfamhaus.length + 1];
				for (int j = 0; j < einfamhaus.length; j++) {
					ehtmp[j] = einfamhaus[j];
				}
				ehtmp[einfamhaus.length] = new Einfamilienhaus(AnWohn, Hnr, Baujahr, Hgebaut, strasse.length);
				einfamhaus = ehtmp;
			}
		}
		stmp.push(einfamhaus);
		stmp.push(hochhaus);
		return;
	}

	public Hochhaus Hochhausbauen(Hochhaus hochhaus, int jahr) {
		hochhaus.AnWohn = new Random().nextInt(20) + 1;
		hochhaus.Baujahr = jahr;
		hochhaus.Hgebaut = true;
		hochhaus.wohnungen = hochhaus.defwohnungen(hochhaus.AnWohn, hochhaus.Hgebaut, true);
		return hochhaus;
	}

	public Einfamilienhaus Einfamilienhausbauen(Einfamilienhaus einfamhaus, int jahr) {
		einfamhaus.AnWohn = new Random().nextInt(1) + 1;
		einfamhaus.Baujahr = jahr;
		einfamhaus.Hgebaut = true;
		einfamhaus.wohnungen = einfamhaus.defwohnungen(einfamhaus.AnWohn, einfamhaus.Hgebaut, true);
		return einfamhaus;
	}

	public Strasse[] Strassenverzeichnis(Hochhaus[] hochhaus, Einfamilienhaus[] einfamhaus, Strasse[] strasse) {
		int strassenanzahl = 0;
		for (int i = 0; i < hochhaus.length; i++) {
			if (hochhaus[i].Strnr > strassenanzahl) {
				strassenanzahl = hochhaus[i].Strnr;
			}
		}
		for (int i = 0; i < einfamhaus.length; i++) {
			if (einfamhaus[i].Strnr > strassenanzahl) {
				strassenanzahl = einfamhaus[i].Strnr;
			}
		}
		Strasse[] strtmp = new Strasse[strassenanzahl];
		for (int j = 0; j < strtmp.length; j++) {
			strtmp[j] = new Strasse(j);
		}
		strasse = strtmp;
		return strasse;
	}
}
