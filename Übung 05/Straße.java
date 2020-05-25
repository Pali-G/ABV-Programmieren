import java.util.Random;
import java.util.Scanner;

public class Straße {
static int Anzahlwohnungslose = 0;
int Straßennummer;
int AnzahlGrundstücke;
Haus[] Häuser;

public Straße (int StN, int AGr) {
	this.Straßennummer = StN;
	this.AnzahlGrundstücke = AGr;
	Haus[] Häuser = new Haus[AGr];
	for (int j = 0; j < AGr; j++) {
		int Anzahlwohnungen = new Random().nextInt(20) + 1;
		int Hausnummer = j;
		int Baujahr = new Random().nextInt(70) + 1950;
		boolean gebaut = new Random().nextBoolean();
		Häuser[j] = new Haus(Anzahlwohnungen, Hausnummer, Baujahr, gebaut);
	}	
	this.Häuser = Häuser;
}
	public static Haus Hausbauen(Haus H, int jahr) {
		H.gebaut = true;
		H.Baujahr = jahr;
		H.Anzahlwohnungen= new Random().nextInt(20)+1;
		return H;
	}
	public static Haus[] Wohnraumschaffen(Haus[] H, int Jahr, int benötigteWng) {
		int i = 0;
		int Hausnummer;
		while (i < benötigteWng) {
			Hausnummer = Grundstückfinden(H);
			System.out.println(Hausnummer);
			if (Hausnummer < 0) {
				System.out.println("Es gibt zu wenig Grundstücke");
				Anzahlwohnungslose += benötigteWng - i;
				break;
			} else {
				System.out.println(H[Hausnummer].gebaut);
				H[Hausnummer] = Hausbauen(H[Hausnummer], Jahr);
				System.out.println(H[Hausnummer].gebaut);
				i += H[Hausnummer].wohnungen.length;
			}
		}
		return H;
	}


	
	public static int Grundstückfinden(Haus[] H) {
		int HN = -1;
		//System.out.println(FreieGrundstücke(H));
		for (int i = 0; i < H.length; i++) {
			if (H[i].gebaut == false) {
				HN = i;
				break;
			}
		}
		return HN;
	}

	/*public static boolean FreieGrundstücke(Haus[] H) {
		boolean FrGr = false;
		for (int i = 0; i < H.length; i++) {
			if (H[i].gebaut == false) {
				FrGr =true;
			}
		}
		return FrGr;
	}*/

	public static int[] Wohnungenbewohnt(Haus[] H) {
		int[] Wohnungsstats = new int[2];
		Wohnungsstats[0] = 0;// Anzahlwohnungenallgemein
		Wohnungsstats[1] = 0;// belegteWohnungen
		for (int i = 0; i < H.length; i++) {
			for (int j = 0; j < H[i].Anzahlwohnungen; j++) {
				if (H[i].gebaut == true) {
					if (H[i].wohnungen[j] == true) {
						Wohnungsstats[1]++;
					}
					Wohnungsstats[0]++;
				}
			}
		}
		return Wohnungsstats;
	}

	public static int[] MieterzumRausschmeißenfinden(Haus[] H) {
		int[] Mieter = new int[2];
		for (int k = 0; k < H.length; k++) {// Es wird durch die Haus liste iteriert
			for (int j = 0; j < H[k].Anzahlwohnungen; j++) {// Es wird durch die Listes des kten Haus iteriert
				if (H[k].wohnungen[j] == true) {
					Mieter[0] = k;
					Mieter[1] = j;
					return Mieter;
				}
			}
		}
		return Mieter;
	}

	public static int[] Wohnungssuche(Haus[] H) {
		int[] Mieter = new int[2];
		for (int k = 0; k < H.length; k++) {// Es wird durch die Haus liste iteriert
			for (int j = 0; j < H[k].Anzahlwohnungen; j++) {// Es wird durch die Listes des kten Haus iteriert
				if (H[k].gebaut == true) {
					if (H[k].wohnungen[j] == false) {
						Mieter[0] = k;
						Mieter[1] = j;
						return Mieter;
					}
				}
			}
		}
		return Mieter;
	}

	public static Haus[] umziehen(Haus[] H, int[] whnstats, int[] kug, int jahr) {
		// Wegziehen
		for (int i = 0; i < kug[1]; i++) {
			int[] mieter = MieterzumRausschmeißenfinden(H);
			H[mieter[0]].wohnungen[mieter[1]] = false;
		}
		//System.out.println(FreieGrundstücke(H));
		H = Haus.Wreckingball(jahr, H);
		if (whnstats[0] - whnstats[1] < (kug[0] - kug[1]) && (kug[0] - kug[1]) > 0) {
			System.out.println("Es gibt zuwenig Wohnungen, es müssen neue Häuser gebaut werden");
			int benWhng = Math.abs(whnstats[0] - whnstats[1] - kug[0] - kug[1]);
			System.out.println(benWhng);
			H = Wohnraumschaffen(H, jahr, benWhng);
		}
		for (int i = 0; i < kug[0]; i++) {
			int[] mieter = Wohnungssuche(H);
			H[mieter[0]].wohnungen[mieter[1]] = true;
		}
		return H;
	}

	public static int[] Wohnungsmarkt(int[] wohnungsstats) {
		int FreieWohnungen = wohnungsstats[0] - wohnungsstats[1];
		int[] kommenundgehen = new int[2];
		kommenundgehen[0] = new Random().nextInt(FreieWohnungen + 10) + (wohnungsstats[0] / 4);// Anzahl der
																								// hinzuziehenden
		kommenundgehen[1] = new Random().nextInt(wohnungsstats[1]);// Anzahl der wegziehenden
		return kommenundgehen;
	}
	/*public static void SimulationS(int AGr, int Anfangsjahr, int Endjahr) throws InterruptedException {// AnzahlGrundstücke
		Haus[] Häuser = new Haus[AGr];
		for (int i = 0; i < AGr; i++) {
			int Anzahlwohnungen = new Random().nextInt(20) + 1;
			int Hausnummer = i;
			int Baujahr = new Random().nextInt(70) + 1950;
			boolean gebaut = new Random().nextBoolean();
			Häuser[i] = new Haus(Anzahlwohnungen, Hausnummer, Baujahr, gebaut);
		}
		for (int jahr = Anfangsjahr; jahr <= Endjahr; jahr++) {
			int[] whnstats = Wohnungenbewohnt(Häuser);
			System.out.println("Es ist Das Jahr " + jahr);
			System.out.println("Es sind " + whnstats[1] + " von " + whnstats[0] + " Wohnungen bewohnt");
			int[] kommenundgehen = Wohnungsmarkt(whnstats);
			Thread.sleep(1500);
			System.out.println("Es ziehen " + kommenundgehen[0] + " Menschen hinzu und " + kommenundgehen[1] + " weg");
			Häuser = Straße.umziehen(Häuser, whnstats, kommenundgehen, jahr);
			if (Anzahlwohnungslose > 0) {
				System.out.println("Es gibt " + Anzahlwohnungslose + " Wohnungslose in diese Strasse");
			}
			Thread.sleep(1500);
		}
	}*/
	public static void SimulationS() {
		System.out.println("In welchem Jahr willst du die Simulation beginnen?");
		Scanner sc1 = new Scanner(System.in);
		int Anfangsjahr = sc1.nextInt();
		
		System.out.println("In welchem Jahr soll die Simulation enden?");
		Scanner sc2 = new Scanner(System.in);
		int Endjahr = sc2.nextInt();
		
		System.out.println("Wie viele Straßen möchtest du verwalten?");
		Scanner sc3 = new Scanner(System.in);
		int AS = sc3.nextInt();
		
		Straße[] Straßen = new Straße[AS];
		for (int i = 0; i < AS; i++) {
			int SName = i+1;
			int SAGr = new Random().nextInt(20) + 1;
			Straßen[i] =new Straße(SName, SAGr);	
			
		}
		for (int Jahr = Anfangsjahr; Jahr <= Anfangsjahr; Jahr++) {
				System.out.println("Es ist das Jahr "+Jahr);
				System.out.println("Es gibt "+AS+" Straßen");
				System.out.println("Willst du eine Straße genau betrachten?");
				String Aw1;
				Scanner sc6 = new Scanner(System.in);
				Aw1 = sc6.nextLine();
				if (Aw1.contains("t")==true) {
						int Aw2;
						System.out.println("Welche Straße?");
						Scanner sc7 = new Scanner(System.in);
						Aw2 = sc7.nextInt();
						System.out.println("Straße "+Straßen[Aw2-1].Straßennummer+"hat "+Straßen[Aw2-1].AnzahlGrundstücke+" Grundstücke");
						int Hgebaut = 0;
						for (int k = 0; k <Straßen[Aw2-1].Häuser.length; k++) {
							if (Straßen[Aw2-1].Häuser[k].gebaut==true) {
								Hgebaut++;
							}
						}
						System.out.println(Hgebaut+" der Grundstücke sind bebaut");
						int[] whnstats = Wohnungenbewohnt(Straßen[Aw2-1].Häuser);
						System.out.println("Es gibt "+whnstats[0]+" Wohnungen, "+"davon sind "+whnstats[1]+" Wohnungen bewohnt und "+(whnstats[0]-whnstats[1])+" unbewohnt");
						
						
				}
		}
	}
}
