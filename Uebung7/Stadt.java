package uebung5;

import java.util.Random;

public class Stadt {
	public Stadt () {
		
	}
	public int[] Wohnungsstatistik(Hochhaus[] hhäuser, Einfamilienhaus[] ehäuser) {
		int[] whnstats = new int [2];
		for (int i=0; i < hhäuser.length; i++) {
			if(hhäuser[i].Hgebaut==true) {
				whnstats[0] += hhäuser[i].wohnungen.length;
				for (int j=0; j<hhäuser[i].wohnungen.length; j++) {
					if(hhäuser[i].wohnungen[j]==true) {
						whnstats[1]++;
					}
				}
			}
		}
		for (int i=0; i < ehäuser.length; i++) {
			if(ehäuser[i].Hgebaut==true) {
				whnstats[0] += ehäuser[i].wohnungen.length;
				for (int j=0; j<ehäuser[i].wohnungen.length; j++) {
					if(ehäuser[i].wohnungen[j]==true) {
						whnstats[1]++;
					}
				}
			}
		}
		return whnstats; //[0]=Wohnungen insgesamt; [1]=Wohnungen bewohnt
	}
	
	public int[] Meldeamt (int[]whnstats) {
		int[] meldeamt = new int [2];
		meldeamt[0] = new Random().nextInt(100);			//zuziehende Haushalte
		meldeamt[1] = new Random().nextInt(whnstats[1]);   	//wegziehende Haushalte
		return meldeamt;
	}
	
	public void Wegziehen (Stadt stadt, Strasse[] strassen) {
		for (int i=0; i< strassen.length; i++) {
			int[] ma = Meldeamt(stadt.Wohnungsstatistik(strassen[i].Hhäuser, strassen[i].Ehäuser));
			for (int j=0; j <= ma[1]; j++) {
				if (j%2==0) {
					int[] mieter = HRausschmiss(strassen[i].Hhäuser);
					strassen[i].Hhäuser[mieter[0]].wohnungen[mieter[1]] = false;
				}else {
					int[] mieter = ERausschmiss(strassen[i].Ehäuser);	
					strassen[i].Ehäuser[mieter[0]].wohnungen[mieter[1]] = false;
					
				}		
			}
		}
	}
	
	public int[] HRausschmiss(Hochhaus[] haus) {
		int[] mieter = new int[2];
		for (int k = 0; k < haus.length; k++) {
			for (int j = 0; j < haus[k].AnWohn; j++) {
				if (haus[k].Hgebaut == true) {
					if (haus[k].wohnungen[j] == true) {
						mieter[0] = k;			//Hausnummer 
						mieter[1] = j;			//Wohnungsnummer
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
						mieter[0] = k;			//Hausnummer 
						mieter[1] = j;			//Wohnungsnummer
						return mieter;
					}
				}
			}
		}
		return mieter;
	}
	
	public void Abriss (Strasse[] strassen, Stadt stadt, int jahr) {
		for ( int i = 0; i < strassen.length; i++) {
			strassen[i].Hhäuser = strassen[i].WreckingBallH(jahr);
			strassen[i].Ehäuser = strassen[i].WreckingBallE(jahr);
		}
		
	}
	
	public int [] abgerisseneHäuser(Strasse[] strassen, int jahr) {
		int[] aH = new int[2];
		aH[1] = jahr;
			for (int i=0; i<strassen.length; i++) {
				for (int j= 0; j < strassen[i].Hhäuser.length; j++) {
					if (strassen[i].Hhäuser[j].Habgerissen==true) {
						aH[0]++;
					}
				}
				for (int j= 0; j < strassen[i].Ehäuser.length; j++) {
					if (strassen[i].Ehäuser[j].Habgerissen==true) {
						aH[0]++;
					}
				}
			}
		return aH;
	}
	
	public void Wohnraumanpassen (Strasse[] strassen, int jahr) {
		
		int[]wstats = new int[2];
		for(int i=0; i<strassen.length; i++) {
			int[] whnstats = Wohnungsstatistik(strassen[i].Hhäuser, strassen[i].Ehäuser);
			wstats[0] += whnstats[0];
			wstats[1] += whnstats[1];
		}
		int FreieWhn = wstats[0] - wstats[1];
		int[] meldeamt = Meldeamt(wstats);
		int benWhn = meldeamt[0] - meldeamt[1];
		if(benWhn<0) {
			benWhn = 0;
		}
		int Whnbauen = benWhn - FreieWhn;		//benWhn<FreieWhn=> Whnbauen<0 => kein Wohnraumschaffen; benWhn>FreieWhn=> Whnbauen>0
		while (Whnbauen>0) {
			int[] HN = Grundstückfinden(strassen);
			if (HN[0] < 0) {
				strassen = Strassebauen(strassen, jahr);
				HN = Grundstückfinden(strassen);
			}
			if (HN[1] == 0) {
				strassen[HN[2]].Hhäuser[HN[0]] = Hochhausbauen(strassen[HN[2]].Hhäuser[HN[0]], jahr);
				Whnbauen -= strassen[HN[2]].Hhäuser[HN[0]].AnWohn;
			} else if (HN[1] == 1) {
				strassen[HN[2]].Ehäuser[HN[0]] = Einfamilienhausbauen(strassen[HN[2]].Ehäuser[HN[0]], jahr);
				Whnbauen -= strassen[HN[2]].Ehäuser[HN[0]].AnWohn;
			}
		}
		for (int i = 0; i <= meldeamt[0]; i++) {
			if (i % 2 == 0) {
				int[] mieterh = EinziehenH(strassen);
				strassen[mieterh[2]].Ehäuser[mieterh[0]].wohnungen[mieterh[1]] = true;
			} else {
				int[] mietere = EinziehenE(strassen);
				strassen[mietere[2]].Ehäuser[mietere[0]].wohnungen[mietere[1]] = true;
			}
		}
	}
	
	public int[] Grundstückfinden(Strasse[] strassen) {
		int[] HN = new int[3];
		HN[0] = -1; // UNBEDINGT UNBEDINGT ÜBERPRÜFEN!!!
		for (int i = 0; i < strassen.length; i++) {
			for (int j=0; j < strassen[i].Hhäuser.length; j++) {
				if (strassen[i].Hhäuser[j].Hgebaut == false) {
					HN[0] = j;		//Hausnummer 
					HN[1] = 0;
					HN[2] = i;
					return HN;
				}
			}
		}
		for (int i = 0; i < strassen.length; i++) {
			for (int j = 0; j<strassen[i].Ehäuser.length; j++) {
				if (strassen[i].Ehäuser[j].Hgebaut == false) {
					HN[0] = j;
					HN[1] = 0;
					HN[2] = i;
					return HN;
				}
			}
		}
		return HN;
	}
	
	public Strasse[] Strassebauen (Strasse[] strassen, int jahr) {
		Strasse[] newstrassen = new Strasse[strassen.length+1];		//neuer strassen array, der 1 strasse mehr hat als der alte
		for(int i=0; i<strassen.length; i++) {						
			newstrassen[i] = strassen[i];							// Übergabe aller Werte des alten Arrays an den neuen
		}
		int AGr = new Random().nextInt(20)+1;
		newstrassen[strassen.length] = new Strasse (strassen.length, AGr, jahr); 		//Erzeugung einer Strasse an der noch leeren, letzten stelle
		for (int i=0; i < newstrassen[strassen.length].Hhäuser.length; i++) { 			//da der Konstruktor für strasse automatisch Werte für					
			newstrassen[strassen.length].Hhäuser[i].Hgebaut=false;						//Hgebaut generiert, werden hier alle false auf gesetzt
		}
		for (int i=0; i < newstrassen[strassen.length].Ehäuser.length; i++) { 
			newstrassen[strassen.length].Ehäuser[i].Hgebaut=false;
		}
		return newstrassen;
	}
	
	public Hochhaus Hochhausbauen(Hochhaus hochhaus, int jahr) {
		hochhaus.AnWohn = new Random().nextInt(20) + 1;
		hochhaus.Baujahr = jahr;
		hochhaus.Hgebaut = true;
		hochhaus.wohnungen = hochhaus.defwohnungen(hochhaus.AnWohn, hochhaus.Hgebaut);
		hochhaus.wohnungenbewohnt = hochhaus.wb(hochhaus.wohnungen);
		hochhaus.Feuertreppe = hochhaus.Brandschutzgesetz(hochhaus.AnWohn);
		hochhaus.Habgerissen = false;
		return hochhaus;
	}

	public Einfamilienhaus Einfamilienhausbauen(Einfamilienhaus einfamhaus, int jahr) {
		einfamhaus.AnWohn = new Random().nextInt(1) + 1;
		einfamhaus.Baujahr = jahr;
		einfamhaus.Hgebaut = true;
		einfamhaus.wohnungen = einfamhaus.defwohnungen(einfamhaus.AnWohn, einfamhaus.Hgebaut);
		einfamhaus.wohnungenbewohnt = einfamhaus.wb(einfamhaus.wohnungen);
		einfamhaus.Habgerissen = false;
		return einfamhaus;
	}
	
	public int[] EinziehenH(Strasse[] strassen) {
		int[] mieter = new int [3];
		for (int i = 0; i < strassen.length; i++) {
			for (int j = 0; j < strassen[i].Hhäuser.length; j++) {
				if (strassen[i].Hhäuser[j].Hgebaut == true) {
					for (int k = 0; k < strassen[i].Hhäuser[j].AnWohn; k++) {
						if (strassen[i].Hhäuser[j].wohnungen[k] == false) {
							mieter[0] = j;			//Hausnummer 
							mieter[1] = k;			//Wohnungsnummer
							mieter[2] = i;			//Strassennummer
							return mieter;
						}
					}
				}
			}	
		}
		return mieter;
	}
	

	public int[] EinziehenE(Strasse[] strassen) {
		int[] mieter = new int [3];
		for (int i = 0; i < strassen.length; i++) {
			for (int j = 0; j < strassen[i].Ehäuser.length; j++) {
				if (strassen[i].Ehäuser[j].Hgebaut == true) {
					for (int k = 0; k < strassen[i].Ehäuser[j].AnWohn; k++) {
						if (strassen[i].Ehäuser[j].wohnungen[k] == false) {
							mieter[0] = j;			//Hausnummer 
							mieter[1] = k;			//Wohnungsnummer
							mieter[2] = i;			//Strassennummer
							return mieter;
						}
					}
				}
			}	
		}
		return mieter;
	}
	/*public void Wohnraumanpassen(Hochhaus[] hochhaus, Einfamilienhaus[] einfamhaus, Strasse[] strasse, int[] meldeamt,
			int[] whnstats, int jahr) {
			
		hochhaus = Hochhaus.WreckingBall(hochhaus, jahr);
		einfamhaus = Einfamilienhaus.WreckingBall(einfamhaus, jahr);
		int FreieWhn = whnstats[0] - whnstats[1];// Freie Wohnungen
		int benWhn = meldeamt[0] - meldeamt[1];// benötigte Wohnungen
		if (benWhn < 0) {
			benWhn = 0;
		}
		int Whnbauen = FreieWhn - benWhn;
		if (Whnbauen < 0) {
			Wohnraumschaffen(hochhaus, einfamhaus, strasse, Math.abs(Whnbauen), jahr);
			hochhaus = (Hochhaus[]) stmp.pop();
			einfamhaus = (Einfamilienhaus[]) stmp.pop();
		}
		for (int i = 0; i <= meldeamt[0]; i++) {
			if (i % 2 == 0) {
				int[] mieterh = HEinziehen(hochhaus);
				hochhaus[mieterh[0]].wohnungen[mieterh[1]] = true;
			} else {
				int[] mietere = EEinziehen(einfamhaus);
				einfamhaus[mietere[0]].wohnungen[mietere[1]] = true;
			}
		}
		stmp.push(einfamhaus);
		stmp.push(hochhaus);
		return;
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
	}*/
}































