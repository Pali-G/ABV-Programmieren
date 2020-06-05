package uebung_5;

import java.util.Random;
import java.util.Scanner;

public class Simulation {
	
	public static void printStrasse(Stadt stadt, Strasse[] strassen, int Stnr) {
		int Grbebaut = strassen[Stnr - 1].Grbebaut(strassen[Stnr - 1].Häuser);
		int[] whnstats = stadt.Wohnungsstatistik(strassen[Stnr - 1].Häuser);
		System.out.println("Straße " + strassen[Stnr - 1].Strassennummer + " hat "
				+ strassen[Stnr - 1].AnzahlGrundstücke + " Grundstücke");
		System.out.println(Grbebaut + " der Grundstücke sind bebaut");
		System.out.println("Es gibt " + whnstats[0] + " Wohnungen, " + "davon sind " + whnstats[1]
				+ " Wohnungen bewohnt und " + (whnstats[0] - whnstats[1]) + " unbewohnt.");
	}

	public static void printStrassenListe(Stadt stadt, Strasse[] strassen) {
		System.out.println("|Strassennummer\t|" + "Anzahl grundstücke\t|" + "bebaute Grundstücke\t|"
				+ "Anzahl Wohnungen insg.\t|" + "bewohnte Wohnungen insg.\t|");
		for (int i = 0; i < strassen.length; i++) {
			int Grbebaut = strassen[i].Grbebaut(strassen[i].Häuser);
			int[] whnstats = stadt.Wohnungsstatistik(strassen[i].Häuser);
			System.out.println("|" + strassen[i].Strassennummer + "\t\t|" + strassen[i].AnzahlGrundstücke + "\t\t\t|"
					+ Grbebaut + "\t\t\t|" + whnstats[0] + "\t\t\t|" + whnstats[1] + "\t\t\t\t|");
		}
	}

	public static void printHaus(Stadt stadt, Strasse[] strassen, int Stnr, int Hnr) {
		if (strassen[Stnr - 1].Häuser[Hnr - 1].Hgebaut == true) {
			System.out.println(
					"Haus " + Hnr + " wurde im Jahr " + strassen[Stnr - 1].Häuser[Hnr - 1].Baujahr + " gebaut.");
			System.out.println("Es hat " + strassen[Stnr - 1].Häuser[Hnr - 1].AnWohn + " Wohnungen, davon sind "
					+ strassen[Stnr - 1].Häuser[Hnr - 1].wohnungenbewohnt + " bewohnt.");
		} else {
			System.out.println("Grundstück " + Hnr + " ist leer.");
		}
	}

	public static void printHausListe(Stadt stadt, Strasse[] strassen, int Stnr) {
		System.out.println("|Hausnummer\t|" + "Baujahr\t|" + "Anzahl Wohnungen\t|" + "bewohnte Wohnungen\t|");
		for (int i = 0; i < strassen[Stnr - 1].Häuser.length; i++) {
			if (strassen[Stnr - 1].Häuser[i].Hgebaut == true) {
				System.out.println("|" + strassen[Stnr - 1].Häuser[i].Hnr + "\t\t|"
						+ strassen[Stnr - 1].Häuser[i].Baujahr + "\t\t|" + strassen[Stnr - 1].Häuser[i].AnWohn
						+ "\t\t\t|" + strassen[Stnr - 1].Häuser[i].wohnungenbewohnt + "\t\t\t|");
			} else {
				System.out.println("leeres Grundstück");
			}
		}
	}
	
	public static void main(String[] args) {
		
		//Attribute
		Scanner scn = new Scanner(System.in);
		int Anfangsjahr;
		boolean yesno;
		
		//Simulationslänge Eingabe
		System.out.println("In welchem Jahr willst du die Simulation beginnen?");
		  Anfangsjahr = scn.nextInt();
		  
		System.out.println("Jahr:" + Anfangsjahr + ", Beginnen Sie das nächste Jahr mit der Eingabe: true");
		    yesno = scn.nextBoolean();
		    
	    while (yesno == true) {

	        int jahr = Anfangsjahr ++; //Jahres Zähler
	
			Stadt stadt = new Stadt();
			Strasse strasse[] = new Strasse[1];//Am Anfang der Simulation gibt es 1 Strasse mit 10 Grundstücken
			strasse[0] = new Strasse(10);
			Haus haus[] = new Haus[strasse[0].AGr];
			Stadt Hausbauen;// Hausbauen funktion aus Stadt aufrufen
			
			int[] whnstats = stadt.Wohnungsstatistik(haus);
			int[] meldeamt = stadt.Meldeamt(whnstats);
			strasse = stadt.Strassenverzeichnis(haus, strasse);
			haus = stadt.Wohnraumanpassen(haus, strasse, meldeamt, whnstats, jahr);
			int anzahlstr = max(Haus [] Strnr);
			
			int[] Strassen = haus[int Strnr];
			int StrAnzahl = max(Strassen);

	
			//Info print out
			System.out.println("Jahr: " + jahr);
			System.out.println("Es ziehen " + meldeamt[1] + " Leute weg und " + meldeamt[0] + " her.");
			System.out.println("Es gibt " + strasse.length + " Straße(n)");
			
			for (int l = -1; l =< Strnr.length; l++) {
				System.out.println("Es sind in Strasse " + strasse.length + ", "+ whnstats[1] + " von " + Haus[geb].length + " Wohnungen bewohnt.");
			}
			
	
			System.out.println("Willst du eine Straße genau betrachten? (ja/nein)");
			Scanner sc2 = new Scanner(System.in);
			String Aw1 = sc2.nextLine();
			if (Aw1.contains("ja") == true) {
				while (Aw1.contains("ja") == true) {
					System.out.println("Welche Straße? (Straßennummer)");
					int Aw2 = sc2.nextInt();
					printStrasse(stadt, Strassen, Aw2);
					System.out.println(
							"Willst du eine Liste aller Häuser oder nur 1 bestimmtes Haus betrachten? (ja/nein=1 Haus)");
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
						System.out.println("Willst du jetzt eine Liste aller Häuser sehen? (ja/nein)");
						Scanner sc6 = new Scanner(System.in);
						Aw3 = sc6.nextLine();
					}
					if (Aw3.contains("ja") == true) {
						printHausListe(stadt, Strassen, Aw2);
					}
					System.out.println("Willst du eine weitere Straße betrachten? (ja/nein)");
					Scanner sc4 = new Scanner(System.in);
					Aw1 = sc4.nextLine();
				}

			}
			if (Aw1.contains("nein") == true) {
				String Aw7 = "ja";
				while (Aw7.contains("ja") == true) {
					System.out.println("Willst du eine Liste aller Straßen sehen? (ja/nein)");
					System.out.println("Wenn nicht beginnt ein neues Jahr.");
					Scanner sc5 = new Scanner(System.in);
					Aw7 = sc5.nextLine();
					if (Aw7.contains("ja") == true) {
						printStrassenListe(stadt, Strassen);
						System.out.println("Willst du jetzt eine Strasse genauer betrachten? (ja/nein)");
						Aw1 = sc5.nextLine();
						while (Aw1.contains("ja") == true) {
							System.out.println("Welche Straße? (Straßennummer)");
							int Aw2 = sc2.nextInt();
							printStrasse(stadt, Strassen, Aw2);
							System.out.println(
									"Willst du eine Liste aller Häuser oder nur 1 bestimmtes Haus betrachten? (ja/nein=1 Haus)");
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
							System.out.println("Willst du eine weitere Straße betrachten? (ja/nein)");
							Scanner sc4 = new Scanner(System.in);
							Aw1 = sc4.nextLine();

						}
					}	
				}
			}	
			

		    System.out.println("Das Jahr: " + jahr + " endet , Beginnen Sie das nächste Jahr mit der Eingabe: true, oder beenden sie die Simulation mit: false");
		    yesno = scn.nextBoolean(); //neues Jahr
	    }   
	    if (yesno == false){
	    	System.out.println("Die Simulation wurde beendet.");
	    }
		
		scn.close();
		
	
	}
}


