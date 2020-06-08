package uebung7;

public class Einfamilienhaus extends Haus<Einfamilienhaus> {
	
	public Einfamilienhaus (int AW, int HN, int BJ, boolean geb) {
		this.AnWohn = AW;// So wird der Variable Hausnummer im Konstruktor ein wert zugeordnet
		//this.Strnr = 
		this.Hnr = HN;
		this.Baujahr = BJ;
		this.Hgebaut = geb;
		this.wohnungen = defwohnungen(AnWohn, Hgebaut);
		this.wohnungenbewohnt = wb(wohnungen);
	}
	public static boolean Hausleer(Einfamilienhaus haus) {
		boolean leer = true;
		for (int i = 0;i<haus.wohnungen.length; i++) {
			if (haus.wohnungen[i] == true) {
				leer = false;
			}
		}
		return leer;
	}
	public static Einfamilienhaus[] WreckingBall(Einfamilienhaus[] haus, int jahr) {
		for (int i = 0; i < haus.length; i++) {
			if (haus[i].Hgebaut == true && Hausleer(haus[i]) == true && haus[i].Baujahr < (jahr-60)) {
				haus[i].Hgebaut = false;
				System.out.println("Ein Haus wurde abgerissen" + haus[i].Baujahr);
			}
		}
		return haus;
	}
}
