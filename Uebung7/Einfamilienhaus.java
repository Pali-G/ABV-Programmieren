package uebung5;

public class Einfamilienhaus extends Haus<Einfamilienhaus> {
	
	public Einfamilienhaus (int AW, int HN, int BJ, boolean geb) {
		this.AnWohn = AW;// So wird der Variable Hausnummer im Konstruktor ein wert zugeordnet
		//this.Strnr = 
		this.Hnr = HN;
		this.Baujahr = BJ;
		this.Hgebaut = geb;
		this.wohnungen = defwohnungen(AnWohn, Hgebaut);
		this.wohnungenbewohnt = wb(wohnungen);
		this.Habgerissen = false;
	}
	public boolean Hausleer(Einfamilienhaus haus) {
		boolean leer = true;
		for (int i = 0;i<haus.wohnungen.length; i++) {
			if (haus.wohnungen[i] == true) {
				leer = false;
			}
		}
		return leer;
	}
	
}

