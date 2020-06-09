package uebung7;

import java.util.Random;
import java.util.Scanner;

import uebung_5.Haus;

public class SimulationStadt {
	public static void main(String[] args) {
		SimulationS();
	}

	public static void printStrasse(Stadt stadt, Strasse[] strassen, int Stnr) {
		int Grbebaut = strassen[Stnr - 1].Grbebaut();
		int[] whnstats = stadt.Wohnungsstatistik(strassen[Stnr - 1].hochhaus, strassen[Stnr - 1].einfamhaus);
		System.out.println("Straße " + strassen[Stnr - 1].Strassennummer + " hat "
				+ strassen[Stnr - 1].AnzahlGrundstücke + " Grundstücke.");
		System.out.println(Grbebaut + " der Grundstücke sind bebaut.");
		System.out.println("Es gibt " + whnstats[0] + " Wohnungen, " + "davon sind " + whnstats[1]
				+ " Wohnungen bewohnt und " + (whnstats[0] - whnstats[1]) + " unbewohnt.");
	}

	public static void printStrassenListe(Stadt stadt, Strasse[] strassen) {
		System.out.println("|Strassennummer\t|" + "Anzahl grundstücke\t|" + "bebaute Grundstücke\t|" 
				+ "Anzahl Wohnungen insg.\t|" + "bewohnte Wohnungen insg.\t|");
		for (int i = 0; i < strassen.length; i++) {
			int Grbebaut = strassen[i].Grbebaut();
			int[] whnstats = stadt.Wohnungsstatistik(strassen[i].hochhaus, strassen[i].einfamhaus);
			System.out.println("|" + strassen[i].Strassennummer + "\t\t|" + strassen[i].AnzahlGrundstücke + "\t\t\t|"
					+ Grbebaut + "\t\t\t|" + whnstats[0] + "\t\t\t|" + whnstats[1] + "\t\t\t\t|");
		}
	}

	public static void printHaus(Stadt stadt, Strasse[] strassen, int Stnr, int Hnr) {
		for (int i=0; i < strassen[Stnr-1].hochhaus.length; i++) {		
			if (strassen[Stnr-1].hochhaus[i].Hnr==Hnr) {
				if (strassen[Stnr - 1].hochhaus[i].Hgebaut == true) {
					System.out.println("Das Hochhaus " + strassen[Stnr-1].hochhaus[i].Hnr + " wurde im Jahr " 
						+strassen[Stnr - 1].hochhaus[i].Baujahr + " gebaut.");
					System.out.println("Es hat " + strassen[Stnr - 1].hochhaus[i].AnWohn + " Wohnungen, davon sind "
						+ strassen[Stnr - 1].hochhaus[i].wohnungenbewohnt + " bewohnt.");
				}else {
					System.out.println("Grundstück " + Hnr + " ist leer.");
				}
			}	
		}
		for (int i = 0; i < strassen[Stnr-1].einfamhaus.length; i++) {
			if (strassen[Stnr-1].einfamhaus[i].Hnr==Hnr) {
				if (strassen[Stnr - 1].einfamhaus[i].Hgebaut == true) {
					System.out.println("Das Einfamilienhaus " + strassen[Stnr-1].einfamhaus[i].Hnr + " wurde im Jahr " 
						+strassen[Stnr - 1].hochhaus[i].Baujahr + " gebaut.");
					System.out.println("Es hat " + strassen[Stnr - 1].einfamhaus[i].AnWohn + " Zimmer.");
				}else {
					System.out.println("Grundstück " + Hnr + " ist leer.");
				}
			}
		}
	}

	public static void printHausListe(Stadt stadt, Strasse[] strassen, int Stnr) {
		System.out.println("|Hausnummer\t|" + "Baujahr\t|" + "Haustyp\t|" +"#Wohnungen/Zimmer\t|" + "bewohnte Wohnungen\t|" + "Feuertreppe\t|");
		for (int i = 1; i <= strassen[Stnr - 1].hochhaus.length*2; i++) {			//i=Hausnummer
			for (int j = 0; j < strassen[Stnr-1].hochhaus.length; j++) {			//j=position im Array hochhaus
				if (strassen[Stnr - 1].hochhaus[j].Hnr==i) {
					if (strassen[Stnr - 1].hochhaus[j].Hgebaut == true) {
						if(strassen[Stnr - 1].hochhaus[j].Feuertreppe==true) {
							System.out.println("|" + i + "\t\t|"+ strassen[Stnr - 1].hochhaus[j].Baujahr + "\t\t|" + "Hochhaus\t|"
									+ strassen[Stnr - 1].hochhaus[j].AnWohn+ "\t\t\t|" + strassen[Stnr - 1].hochhaus[j].wohnungenbewohnt 
									+ "\t\t\t|"+"ja\t\t|");
						} else {
							System.out.println("|" + i + "\t\t|"+ strassen[Stnr - 1].hochhaus[j].Baujahr + "\t\t|" + "Hochhaus\t|"
									+ strassen[Stnr - 1].hochhaus[j].AnWohn+ "\t\t\t|" + strassen[Stnr - 1].hochhaus[j].wohnungenbewohnt 
									+ "\t\t\t|"+"nein\t\t|");
						}
					} else {
						System.out.println("|" + strassen[Stnr - 1].hochhaus[j].Hnr + "\t\t|Grundstück leer|/\t\t|/\t\t\t|/\t\t\t|/\t\t|");
					}
				}
			}
			for (int j = 0; j < strassen[Stnr-1].einfamhaus.length; j++) {			//j=position im array einfamhaus
				if (strassen[Stnr - 1].einfamhaus[j].Hnr==i) {
					if (strassen[Stnr - 1].einfamhaus[j].Hgebaut == true) {
						System.out.println("|" + i + "\t\t|"
								+ strassen[Stnr - 1].einfamhaus[j].Baujahr + "\t\t|" + "Einfamilienhaus|" + strassen[Stnr - 1].einfamhaus[j].AnWohn
								+ "\t\t\t|" + strassen[Stnr - 1].einfamhaus[j].wohnungenbewohnt +"\t\t\t|"+"/\t\t|");
					} else {
						System.out.println("|" + strassen[Stnr - 1].einfamhaus[j].Hnr + "\t\t|Grundstück leer|/\t\t|/\t\t\t|/\t\t\t|/\t\t|");
					}
				}
			}
		}
	}
	

	public static void SimulationS() {
		//Attribute für die Simulation
		Scanner scn = new Scanner(System.in);
		Stadt stadt = new Stadt();
		int Anfangsjahr;
		boolean yesno;
		int AS;

		Strasse[] Strassen = new Strasse[AS];
		for (int m = 0; m < AS; m++) {
			int SNr = m + 1;
			int SAGr = new Random().nextInt(20) + 1;
			Strassen[m] = new Strasse(SNr, SAGr, Anfangsjahr);
		}
		
		Hochhaus hochhaus[] = new Hochhaus[strasse[0].AGr/2];
		Strasse einfamhaus[] = new Strasse[SNr - 1].einfamhaus[i];
		for (int i = 0; i < hochhaus.length; i++) {
			int AnWohn = new Random().nextInt(20) + 1;
			int Hnr = i;
			int Baujahr = Anfangsjahr;
			boolean Hgebaut = new Random().nextBoolean();
			hochhaus[i] = new Hochhaus(AnWohn, Hnr, Baujahr, Hgebaut, 0);
		}
		for (int i = 0; i < einfamhaus.length; i++) {
			int AnWohn = new Random().nextInt(1) + 1;
			int Hnr = i;
			int Baujahr = Anfangsjahr;
			boolean Hgebaut = new Random().nextBoolean();
			einfamhaus[i] = new Einfamilienhaus(AnWohn, Hnr, Baujahr, Hgebaut, 0);
		}
		
		
		//Simulation beginnt
		System.out.println("In welchem Jahr willst du die Simulation beginnen?");
		Anfangsjahr = scn.nextInt();


		System.out.println("Wie viele Straßen möchtest du, zu Anfang, verwalten?");
		AS = scn.nextInt();
		
		System.out.println("Jahr:" + Anfangsjahr + ", Beginnen Sie das nächste Jahr mit der Eingabe: true");
	    yesno = scn.nextBoolean();

		while (yesno == true) {
			int Jahr = Anfangsjahr ++; //Jahres Zähler
			
			int[] whnstats = stadt.Wohnungsstatistik(Strassen[SNr - 1].hochhaus, Strassen[SNr - 1].einfamhaus);
			int[] meldeamt = stadt.Meldeamt(whnstats);
			

	
			//Info print out
			System.out.println("Es ist das Jahr " + Jahr);
			System.out.println("Es gibt " + AS + " Straßen");
			//System.out.println("Es ziehen " + meldeamt[1] + " Leute weg und " + meldeamt[0] + " her.");
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
						System.out.println("Willst du die Liste der Straßen erneut sehen? (ja/nein)");
						/*System.out.println("Wenn nicht beginnt ein neues Jahr.");
						Aw7 = sc5.nextLine();*/
					}
				}
			}
			
			System.out.println("Das Jahr: " + Jahr + " endet , Beginnen Sie das nächste Jahr mit der Eingabe: true, oder beenden sie die Simulation mit: false");
		    yesno = scn.nextBoolean(); //neues Jahr
		}
		 if (yesno == false){
		    	System.out.println("Die Simulation wurde beendet.");
		    }
			
		scn.close();
	}
}