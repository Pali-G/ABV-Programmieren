	package uebung4;
	
	import java.util.Random;
	import java.util.Scanner;
	
	public class Strasse{
	
		public static void main (String[] args){
		
	    }
		int AnzahlGrundstücke;
		
		public static boolean WreckingBall(int Baujahr, boolean[] wohnungen, int Anzahlwohnungen, boolean gebaut, int jahr){
			if ((Haus.WohnungenLeer(wohnungen, Anzahlwohnungen) == true) && ((jahr - Baujahr) >= 60) && gebaut == true){
			    gebaut = false;
			}
			return gebaut;
		}
		
		public static Haus Hausbauen(Haus H, int aktuellesJahr) {
			H.gebaut = true;
			H.Baujahr = aktuellesJahr;
			System.out.println("Bitte geben sie die Anzahl der Wohnungen ein");
			Scanner scanner = new Scanner(System.in);
		    String input = scanner.nextLine();
		    H.Anzahlwohnungen = Integer.parseInt(input);
	
		    return H;
		}
		
		//public static void 
		public static void Simulation(int AGr,int Anfangsjahr, int Endjahr) {//AnzahlGrundstücke
			Haus[] Häuser = new Haus[AGr];
			for (int i = 0; i<AGr; i++) {
				int Anzahlwohnungen = new Random().nextInt(10)+1;
				int Hausnummer = i;
				int Baujahr = new Random().nextInt(70)+1950;
				boolean gebaut = new Random().nextBoolean();
				boolean[] wng = new boolean[Anzahlwohnungen];
				wng = Haus.defwohnungen(Anzahlwohnungen);
			}
			for (int jahr = Anfangsjahr; jahr <= Endjahr; jahr++) {
				
			}
		}
		
	}
