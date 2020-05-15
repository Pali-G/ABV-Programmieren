public class Haus{
    public static void main (String[] args){
	/*int x = 5;
	boolean[] w = new boolean[5];
	w[0] = true;
	w[1] = false;
	w[2] = false;
	w[3] = false;
	w[4] = true;
	boolean k = WohnungenBewohnt(w, x);
	System.out.println(k);*/
	Haus Haus1 = new Haus(4);// 1, 1998, true
	System.out.println(Haus1.WohnungenBewohnt());

       
    }
    public int Anzahlwohnungen;
    int Hausnummer;//Grundstücknummer
    int Baujahr;
    boolean Hausleer;
    boolean gebaut;
    //evtl Strasse
    

    public Haus(int AW){//, int Hausnummer, int Baujahr, boolean gebaut
	this.Anzahlwohnungen = AW;
	boolean[] wohnungen = new boolean[Anzahlwohnungen-1];
	for (int i = 0; i < AW-1; i++){
	    if (i%2==0){
		wohnungen[i] = true;
	    }else{
		wohnungen[i] = false;
	    }
	}
    }

    

    public boolean WohnungenBewohnt(){//boolean[] wohnungen, int Anzahlwohnungen
	this.AW = Anzahlwohnungen;
	this.wohnungen = wohnungen;
	int bewohnt = 0;
	boolean leer = false;
	for (int i = 0; i <= wohnungen.length -1; i++){
	    if (wohnungen[i] == true){
		    bewohnt++;
		}
	}
	System.out.println("Es sind " + bewohnt + " von " + Anzahlwohnungen + " bewohnt");
	if (bewohnt == 0){
		leer = true;
	    }
	return leer;
    }
}
