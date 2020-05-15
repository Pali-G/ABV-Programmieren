public class Haus{
    public static void main (String[] args){
	int x = 5;
	boolean[] w = new boolean[5];
	w[0] = true;
	w[1] = false;
	w[2] = false;
	w[3] = false;
	w[4] = true;
	boolean k = WohnungenBewohnt(w, x);
	System.out.println(k);
    }
    int Anzahlwohnungen;
    int Hausnummer;//Grundstücknummer
    int Baujahr;
    boolean Hausleer;
    boolean gebaut;
    //evtl Strasse
    boolean[] wohnungen = new boolean[Anzahlwohnungen-1];
    
    public static boolean WohnungenBewohnt(boolean[] wohnungen, int Anzahlwohnungen){
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
