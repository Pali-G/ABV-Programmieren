package uebung5;

import java.util.Random;

public class Simulation {

	public static void main(String[] args) {
		Simulationn(2000, 2020);
	}
	
	public static void Simulationn(int Anfangsjahr, int Endjahr) {
		Stadt stadt = new Stadt();
		Strasse strasse[] = new Strasse[1];//Am Anfang der Simulation gibt es 1 Strasse mit 10 Grundstücken
		strasse[0] = new Strasse(10);
		Haus haus[] = new Haus[strasse[0].AGr];
		for (int i = 0; i < haus.length; i++) {
			int AnWohn = new Random().nextInt(20) + 1;
			int Hnr = i;
			int Baujahr = Anfangsjahr;
			boolean Hgebaut = new Random().nextBoolean();
			haus[i] = new Haus(AnWohn, Hnr, Baujahr, Hgebaut, 0);
		}
		for (int jahr = Anfangsjahr; jahr <= Endjahr; jahr++) {
			int[] whnstats = stadt.Wohnungsstatistik(haus);
			int[] meldeamt = stadt.Meldeamt(whnstats);
			Info(jahr, whnstats, meldeamt);
			
		}
	}
	public static void Info(int jahr, int[] whnstats, int[] meldeamt) {
		System.out.println("Jahr: " + jahr);
		System.out.println("Es sind " + whnstats[1] + " von " + whnstats[0] + " Wohnungen bewohnt.");
		System.out.println("Es ziehen " + meldeamt[1] + " Leute weg und " + meldeamt[0] + " her.");
		
	}
}
