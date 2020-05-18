	package uebung4;
	
	import java.util.Random;
	import java.util.Scanner;
	
	public class Strasse{
	
		private static final Haus[] Haus = null;

		public static void main (String[] args){
			Simulation(7, 2000, 2100);
		
	    }
		int AnzahlGrundstücke;
		
		public static Haus WreckingBall(int jahr, Haus H){
			if ((H.WohnungenLeer(H.wohnungen, H.Anzahlwohnungen) == true) && ((jahr - H.Baujahr) >= 60) && H.gebaut == true){
			    H.gebaut = false;
			}
			return H;
		}
		
		public static Haus Hausbauen(Haus H, int aktuellesJahr) {
			H.gebaut = true;
			H.Baujahr = aktuellesJahr;
			System.out.println("Bitte geben sie die Anzahl der Wohnungen ein");
			Scanner scanner = new Scanner(System.in);
		    int input = scanner.nextInt();
		    H.Anzahlwohnungen = input;
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
				System.out.println(Anzahlwohnungen + Hausnummer + Baujahr);
				System.out.println(gebaut);
				Häuser[i] = new Haus(Anzahlwohnungen, Hausnummer, Baujahr, gebaut);
			}
			
			for (int jahr = Anfangsjahr; jahr <= Endjahr; jahr++) {
				
			}
		}

		
		}
