package uebung7;

public class Hochhaus extends Haus<Hochhaus>{
	
	boolean Feuertreppe;
	
	public Hochhaus(int AW, int HN, int BJ, boolean geb, int St) {
		this.AnWohn = AW;// So wird der Variable Hausnummer im Konstruktor ein wert zugeordnet
		this.Strnr = St;
		this.Hnr = HN;
		this.Baujahr = BJ;
		this.Hgebaut = geb;
		this.wohnungen = defwohnungen(AnWohn, Hgebaut);
		this.wohnungenbewohnt = wb(wohnungen);
		this.Feuertreppe = Brandschutzgesetz(AnWohn);
	}
	public boolean Brandschutzgesetz(int AnWohn) {
		boolean Feuertreppe = false;
		if (AnWohn >= 10) {
			Feuertreppe = true;
		}
		return Feuertreppe;
	}
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