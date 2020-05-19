package uebung4;

import java.util.Random;

public class Strasse {

	public static void main(String[] args) throws InterruptedException {
		Simulation(10, 2000, 2050);

	}

	static int Anzahlwohnungslose = 0;

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
				H[Hausnummer] = Hausbauen(H[Hausnummer], Jahr);
				i += H[Hausnummer].wohnungen.length;
			}
		}
		return H;
	}

	
	public static int Grundstückfinden(Haus[] H) {
		int HN = -1;
		for (int i = 0; i < H.length; i++) {
			if (H[i].gebaut == false) {
				HN = i;
				break;
			}
		}
		return HN;
	}

	public static boolean FreieGrundstücke(Haus[] H) {
		boolean FrGr = false;
		for (int i = 0; i < H.length; i++) {
			if (H[i].gebaut == false) {
				FrGr =true;
			}
		}
		return FrGr;
	}
	
	public static Haus Hausbauen(Haus H, int jahr) {
		H.Baujahr = jahr;
		H.gebaut = true;
		H.Anzahlwohnungen = new Random().nextInt(20) + 1;
		H.wohnungen = new boolean[H.Anzahlwohnungen];
		for (int i = 0; i < H.Anzahlwohnungen; i++) {
			H.wohnungen[i] = false;
		}
		return H;
	}

	public static int[] Wohnungenbewohnt(Haus[] H) {
		int[] Wohnungsstats = new int[2];
		Wohnungsstats[0] = 0;// Anzahlwohnungenallgemein
		Wohnungsstats[1] = 0;// belegteWohnungen
		for (int i = 0; i < H.length; i++) {
			for (int j = 0; j < H[i].wohnungen.length; j++) {
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
			for (int j = 0; j < H[k].wohnungen.length; j++) {// Es wird durch die Listes des kten Haus iteriert
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
		System.out.println(FreieGrundstücke(H));
		H = Haus.WreckingBall(jahr, H);
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
		int Wngingsmt = wohnungsstats[0];
		int[] kommenundgehen = new int[2];
		
		kommenundgehen[0] = new Random().nextInt(Wngingsmt/(Anzahlwohnungslose+1)) + FreieWohnungen;// Anzahl der
																								// hinzuziehenden
		kommenundgehen[1] = new Random().nextInt((wohnungsstats[1]+2/2)*(Anzahlwohnungslose+1));// Anzahl der wegziehenden
		return kommenundgehen;
	}

	// public static void
	public static void Simulation(int AGr, int Anfangsjahr, int Endjahr) throws InterruptedException {// AnzahlGrundstücke
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
			//Thread.sleep(1000);
			System.out.println("Es ziehen " + kommenundgehen[0] + " Menschen hinzu und " + kommenundgehen[1] + " weg");
			Häuser = umziehen(Häuser, whnstats, kommenundgehen, jahr);
			if (Anzahlwohnungslose > 0) {
				System.out.println("Es gibt " + Anzahlwohnungslose + " Wohnungslose");
			}
			Thread.sleep(1000);
		}
	}

}
