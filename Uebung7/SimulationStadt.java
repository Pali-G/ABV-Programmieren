package uebung5;

import java.util.Random;
import java.util.Scanner;

public class SimulationStadt {
	public static void main(String[] args) {
		SimulationS();
	}

	/*
	 *public static void Simulation(int Anfangsjahr, int Endjahr) { 
		Stadt stadt = new Stadt(); 
		Strasse strasse[] = new Strasse[1]; //Am Anfang der Simulationgibt es 1 Strasse mit 10 Grundst�cken 
		strasse[0] = new Strasse(10); Haus
	 * 	haus[] = new Haus[strasse[0].AGr]; 
	 *	for (int i = 0; i < haus.length; i++) {
	 * 		int AnWohn = new Random().nextInt(20) + 1; 
	 * 		int Hnr = i; 
	 * 		int Baujahr = Anfangsjahr; 
	 * 		boolean Hgebaut = new Random().nextBoolean(); 
	 * 		haus[i] = new
	 * 		Haus(AnWohn, Hnr, Baujahr, Hgebaut, 0); } 
	 * 
	 * 	for (int jahr = Anfangsjahr; jahr<= Endjahr; jahr++) { 
	 * 		int[] whnstats = stadt.Wohnungsstatistik(haus); 
	 * 		int[]meldeamt = stadt.Meldeamt(whnstats); 
	 * 		strasse = stadt.Strassenverzeichnis(haus, strasse); 
	 * 		Info(jahr, whnstats, meldeamt,strasse); 
	 * 		haus = stadt.Wohnraumanpassen(haus, strasse, meldeamt, whnstats,jahr);
	 * 		}
	 * } public static void Info(int jahr, int[] whnstats, int[] meldeamt,Strasse[] strasse) { 
	 * 			System.out.println("Jahr: " + jahr);
	 * 			System.out.println("Es sind " + whnstats[1] + " von " + whnstats[0] +
	 * 				" Wohnungen bewohnt."); System.out.println("Es ziehen " + meldeamt[1] +
	 * 				" Leute weg und " + meldeamt[0] + " her."); System.out.println("Es gibt " +strasse.length + " Stra�en");
	 * }
	 */
	public static void printStrasse(Stadt stadt, Strasse[] strassen, int Stnr) {
		int Grbebaut = strassen[Stnr - 1].Grbebaut();
		int[] whnstats = stadt.Wohnungsstatistik(strassen[Stnr - 1].Hh�user, strassen[Stnr - 1].Eh�user);
		System.out.println("Stra�e " + strassen[Stnr - 1].Strassennummer + " hat "
				+ strassen[Stnr - 1].AnzahlGrundst�cke + " Grundst�cke.");
		System.out.println(Grbebaut + " der Grundst�cke sind bebaut.");
		System.out.println("Es gibt " + whnstats[0] + " Wohnungen, " + "davon sind " + whnstats[1]
				+ " Wohnungen bewohnt und " + (whnstats[0] - whnstats[1]) + " unbewohnt.");
	}

	public static void printStrassenListe(Stadt stadt, Strasse[] strassen) {
		System.out.println("|Strassennummer\t|" + "Anzahl grundst�cke\t|" + "bebaute Grundst�cke\t|" 
				+ "Anzahl Wohnungen insg.\t|" + "bewohnte Wohnungen insg.\t|");
		for (int i = 0; i < strassen.length; i++) {
			int Grbebaut = strassen[i].Grbebaut();
			int[] whnstats = stadt.Wohnungsstatistik(strassen[i].Hh�user, strassen[i].Eh�user);
			System.out.println("|" + strassen[i].Strassennummer + "\t\t|" + strassen[i].AnzahlGrundst�cke + "\t\t\t|"
					+ Grbebaut + "\t\t\t|" + whnstats[0] + "\t\t\t|" + whnstats[1] + "\t\t\t\t|");
		}
	}

	public static void printHaus(Stadt stadt, Strasse[] strassen, int Stnr, int Hnr) {
		for (int i=0; i < strassen[Stnr-1].Hh�user.length; i++) {		
			if (strassen[Stnr-1].Hh�user[i].Hnr==Hnr) {
				if (strassen[Stnr - 1].Hh�user[i].Hgebaut == true) {
					System.out.println("Das Hochhaus " + strassen[Stnr-1].Hh�user[i].Hnr + " wurde im Jahr " 
						+strassen[Stnr - 1].Hh�user[i].Baujahr + " gebaut.");
					System.out.println("Es hat " + strassen[Stnr - 1].Hh�user[i].AnWohn + " Wohnungen, davon sind "
						+ strassen[Stnr - 1].Hh�user[i].wohnungenbewohnt + " bewohnt.");
				}else {
					System.out.println("Grundst�ck " + Hnr + " ist leer.");
				}
			}	
		}
		for (int i = 0; i < strassen[Stnr-1].Eh�user.length; i++) {
			if (strassen[Stnr-1].Eh�user[i].Hnr==Hnr) {
				if (strassen[Stnr - 1].Eh�user[i].Hgebaut == true) {
					System.out.println("Das Einfamilienhaus " + strassen[Stnr-1].Eh�user[i].Hnr + " wurde im Jahr " 
						+strassen[Stnr - 1].Hh�user[i].Baujahr + " gebaut.");
					System.out.println("Es hat " + strassen[Stnr - 1].Eh�user[i].AnWohn + " Zimmer.");
				}else {
					System.out.println("Grundst�ck " + Hnr + " ist leer.");
				}
			}
		}
	}

	public static void printHausListe(Stadt stadt, Strasse[] strassen, int Stnr) {
		System.out.println("|Hausnummer\t|" + "Baujahr\t|" + "Haustyp\t|" +"#Wohnungen/Zimmer\t|" + "bewohnte Wohnungen\t|" + "Feuertreppe\t|");
		for (int i = 1; i <= strassen[Stnr - 1].Hh�user.length*2; i++) {			//i=Hausnummer
			for (int j = 0; j < strassen[Stnr-1].Hh�user.length; j++) {			//j=position im Array Hh�user
				if (strassen[Stnr - 1].Hh�user[j].Hnr==i) {
					if (strassen[Stnr - 1].Hh�user[j].Hgebaut == true) {
						if(strassen[Stnr - 1].Hh�user[j].Feuertreppe==true) {
							System.out.println("|" + i + "\t\t|"+ strassen[Stnr - 1].Hh�user[j].Baujahr + "\t\t|" + "Hochhaus\t|"
									+ strassen[Stnr - 1].Hh�user[j].AnWohn+ "\t\t\t|" + strassen[Stnr - 1].Hh�user[j].wohnungenbewohnt 
									+ "\t\t\t|"+"ja\t\t|");
						} else {
							System.out.println("|" + i + "\t\t|"+ strassen[Stnr - 1].Hh�user[j].Baujahr + "\t\t|" + "Hochhaus\t|"
									+ strassen[Stnr - 1].Hh�user[j].AnWohn+ "\t\t\t|" + strassen[Stnr - 1].Hh�user[j].wohnungenbewohnt 
									+ "\t\t\t|"+"nein\t\t|");
						}
					} else {
						System.out.println("|" + strassen[Stnr - 1].Hh�user[j].Hnr + "\t\t|Grundst�ck leer|/\t\t|/\t\t\t|/\t\t\t|/\t\t|");
					}
				}
			}
			for (int j = 0; j < strassen[Stnr-1].Eh�user.length; j++) {			//j=position im array Eh�user
				if (strassen[Stnr - 1].Eh�user[j].Hnr==i) {
					if (strassen[Stnr - 1].Eh�user[j].Hgebaut == true) {
						System.out.println("|" + i + "\t\t|"
								+ strassen[Stnr - 1].Eh�user[j].Baujahr + "\t\t|" + "Einfamilienhaus|" + strassen[Stnr - 1].Eh�user[j].AnWohn
								+ "\t\t\t|" + strassen[Stnr - 1].Eh�user[j].wohnungenbewohnt +"\t\t\t|"+"/\t\t|");
					} else {
						System.out.println("|" + strassen[Stnr - 1].Eh�user[j].Hnr + "\t\t|Grundst�ck leer|/\t\t|/\t\t\t|/\t\t\t|/\t\t|");
					}
				}
			}
		}
	}
	
	public static void printAbriss (Strasse[] strassen, int jahr, Stadt stadt) {
		if(stadt.abgerisseneH�user(strassen, jahr)[0]==0 && stadt.abgerisseneH�user(strassen, jahr)[1]==jahr) {
			System.out.println("Keine H�user abgerissen im Jahr " + jahr);
		}else {
			System.out.println("Abgerissene H�user im Jahr " + jahr + ":");
			System.out.println("|Stra�e\t|Hausnummer\t|Haustyp\t|");
			for (int i=0; i < strassen.length; i++) { //Strassennummer
				for (int j=1; j <= strassen[i].Hh�user.length*2; j++) { //Hausnummer
					for (int k=0; k < strassen[i].Hh�user.length; k++) {  //pos. im array Hh�user
						if (strassen[i].Hh�user[k].Hnr==j) {
							if (strassen[i].Hh�user[k].Habgerissen==true) {
								System.out.println("|"+ (i+1) + "\t|" + j + "\t\t|" + "Hochhaus\t|");
							}
						}
					}
					for (int k=0; k < strassen[i].Eh�user.length; k++) {
						if (strassen[i].Eh�user[k].Hnr==j) {
							if (strassen[i].Eh�user[k].Habgerissen==true) {
								System.out.println("|"+ (i+1) + "\t|" + j + "\t\t|" + "Einfamilienhaus|");
							}
						}
					}
				}
			}
		}
	}
		

	public static void SimulationS() {
		Scanner sc1 = new Scanner(System.in);
		Stadt stadt = new Stadt();

		System.out.println("In welchem Jahr willst du die Simulation beginnen?");
		int Anfangsjahr = sc1.nextInt();

		System.out.println("In welchem Jahr soll die Simulation enden?");
		int Endjahr = sc1.nextInt();

		System.out.println("Wie viele Stra�en m�chtest du verwalten?");
		int AS = sc1.nextInt();

		Strasse[] Strassen = new Strasse[AS];
		for (int i = 0; i < AS; i++) {
			int SNr = i + 1;
			int SAGr = new Random().nextInt(20) + 3;
			Strassen[i] = new Strasse(SNr, SAGr, Anfangsjahr);

		}
		for (int Jahr = Anfangsjahr; Jahr <= Endjahr; Jahr++) {
			System.out.println("Es ist das Jahr " + Jahr);
			System.out.println("Es gibt " + AS + " Stra�en");
			System.out.println("Willst du eine Stra�e genau betrachten? (ja/nein)");
			Scanner sc2 = new Scanner(System.in);
			String Aw1 = sc2.nextLine();
			if (Aw1.contains("ja") == true) {
				while (Aw1.contains("ja") == true) {
					System.out.println("Welche Stra�e? (Stra�ennummer)");
					int Aw2 = sc2.nextInt();
					printStrasse(stadt, Strassen, Aw2);
					System.out.println(
							"Willst du eine Liste aller H�user oder nur 1 bestimmtes Haus betrachten? (ja/nein)");
					Scanner sc3 = new Scanner(System.in);
					String Aw3 = sc3.nextLine();
					if (Aw3.contains("nein") == true) {
						String Aw5 = "ja";
						while (Aw5.contains("ja") == true) {
							System.out.println("Hausnummer:");
							int Aw4 = sc3.nextInt();
							printHaus(stadt, Strassen, Aw2, Aw4);
							System.out.println("Willst du ein weiteres Haus betrachten? (ja/nein)");
							Scanner sc4 = new Scanner(System.in);
							Aw5 = sc4.nextLine();
						}
						System.out.println("Willst du jetzt eine Liste aller H�user sehen? (ja/nein)");
						Scanner sc6 = new Scanner(System.in);
						Aw3 = sc6.nextLine();
					}
					if (Aw3.contains("ja") == true) {
						printHausListe(stadt, Strassen, Aw2);
					}
					System.out.println("Willst du eine weitere Stra�e betrachten? (ja/nein)");
					Scanner sc4 = new Scanner(System.in);
					Aw1 = sc4.nextLine();
				}

			}
			if (Aw1.contains("nein") == true) {
				String Aw7 = "ja";
				System.out.println("Willst du eine Liste aller Stra�en sehen? (ja/nein)");
				System.out.println("Wenn nicht beginnt ein neues Jahr.");
				Scanner sc5 = new Scanner(System.in);
				Aw7 = sc5.nextLine();
				while (Aw7.contains("ja") == true) {
					if (Aw7.contains("ja") == true) {
						printStrassenListe(stadt, Strassen);
						System.out.println("Willst du jetzt eine Strasse genauer betrachten? (ja/nein)");
						Aw1 = sc5.nextLine();
						while (Aw1.contains("ja") == true) {
							System.out.println("Welche Stra�e? (Stra�ennummer)");
							int Aw2 = sc2.nextInt();
							printStrasse(stadt, Strassen, Aw2);
							System.out.println("Willst du eine Liste aller H�user oder nur 1 bestimmtes Haus betrachten? (ja/nein)");
							Scanner sc3 = new Scanner(System.in);
							String Aw3 = sc3.nextLine();
							if (Aw3.contains("nein") == true) {
								String Aw5 = "ja";
								while (Aw5.contains("ja") == true) {
									System.out.println("Hausnummer:");
									int Aw4 = sc3.nextInt();
									printHaus(stadt, Strassen, Aw2, Aw4);
									System.out.println("Willst du ein weiteres haus betrachten? (ja/nein)");
									Scanner sc4 = new Scanner(System.in);
									Aw5 = sc4.nextLine();
								}
							}
							if (Aw3.contains("ja") == true) {
								printHausListe(stadt, Strassen, Aw2);
							}
							System.out.println("Willst du eine weitere Stra�e betrachten? (ja/nein)");
							Scanner sc4 = new Scanner(System.in);
							Aw1 = sc4.nextLine();

						}
						System.out.println("Willst du die Liste der Stra�en erneut sehen? (ja/nein)");
						System.out.println("Wenn nicht beginnt ein neues Jahr.");
						Aw7 = sc5.nextLine();
					}
				}
			}
			stadt.Wegziehen(stadt, Strassen);
			stadt.Abriss(Strassen, stadt, Jahr);
			printAbriss(Strassen, Jahr, stadt);
			stadt.Wohnraumanpassen(Strassen, Jahr);
		}
	}
}
