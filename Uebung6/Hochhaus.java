package uebung6;

public class Hochhaus extends Haus<Hochhaus>{

	boolean Feuertreppe;
	
	public Hochhaus(int AW, int HN, int BJ, boolean geb, int St) {
		this.AnWohn = AW;// So wird der Variable Hausnummer im Konstruktor ein wert zugeordnet
		this.Strnr = 
		this.Hnr = HN;
		this.Baujahr = BJ;
		this.Hgebaut = geb;
		this.wohnungen = defwohnungen(AnWohn, Hgebaut, false);
		this.Feuertreppe = Brandschutzgesetz(AnWohn);
	}
	
	public boolean Brandschutzgesetz(int AnWohn) {
		boolean Feuertreppe = false;
		if (AnWohn >= 10) {
			Feuertreppe = true;
		}
		return Feuertreppe;
	}
	
	//Ich habe bei den beiden Funktionen versucht mit abstrakten Methoden zu arbeiten
	//Jedoch gab es ein Problem mit den return types, welches ich versucht habe mit generics zu lösen
	//Da bei WreckingBall aber Arrays verwendet werden, hat dies leider nicht funktioniert
	public static boolean Hausleer(Hochhaus haus) {
		boolean leer = true;
		for (int i = 0;i<haus.wohnungen.length; i++) {
			if (haus.wohnungen[i] == true) {
				leer = false;
			}
		}
		return leer;
	}
	
	public static Hochhaus[] WreckingBall(Hochhaus[] haus, int jahr) {
		for (int i = 0; i < haus.length; i++) {
			if (haus[i].Hgebaut == true && Hausleer(haus[i]) == true && haus[i].Baujahr < (jahr-60)) {
				haus[i].Hgebaut = false;
				System.out.println("Ein Haus wurde abgerissen" + haus[i].Baujahr);
			}
		}
		return haus;
	}
	

}
