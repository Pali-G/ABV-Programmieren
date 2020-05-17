package uebung4;

public class Strasse{

	public static void main (String[] args){
	Haus Haus1 = new Haus(5,1,1950,true);//Anazhlwohnungem, Hausnummer, Bauhjahr, Hausleer, gebaut
	Haus.WohnungenLeer(Haus1.wohnungen, Haus1.Anzahlwohnungen);
	Haus1.gebaut = WreckingBall(Haus1.Baujahr, Haus1.wohnungen, Haus1.Anzahlwohnungen, Haus1.gebaut, 2020);
	
    }
	int AnzahlGrundstücke;
	
	public static boolean WreckingBall(int Baujahr, boolean[] wohnungen, int Anzahlwohnungen, boolean gebaut, int jahr){
		if ((Haus.WohnungenLeer(wohnungen, Anzahlwohnungen) == true) && ((jahr - Baujahr) >= 60) && gebaut == true){
		    gebaut = false;
		}
		return gebaut;
	}
	/*public static void Grundstückeanlegen(AnzahlGrundstücke) {
		for (int i = 0; i < AnzahlGrundstücke; i++) {
			Hausname = "Haus" + i;
			
			Haus Hausname = new Haus()
		}
	}
	public static void Simulation(int AGr,int Anfangsjahr, int Endjahr) {//AnzahlGrundstücke
		
		for (int jahr = Anfangsjahr; jahr <= Endjahr; jahr++) {
			 
		}
	}*/
}
