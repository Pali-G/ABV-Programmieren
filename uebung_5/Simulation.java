package uebung_5;

import java.util.Random;
import java.util.Scanner;

public class Simulation {
	public static void main(String[] args) {
		
		//Attribute
		Scanner scn = new Scanner(System.in);
		int Anfangsjahr;
		boolean yesno;
		
		//Simulationsl�nge Eingabe
		System.out.println("In welchem Jahr willst du die Simulation beginnen?");
		  Anfangsjahr = scn.nextInt();
		  
		System.out.println("Jahr:" + Anfangsjahr + ", Beginnen Sie das n�chste Jahr mit der Eingabe: true");
		    yesno = scn.nextBoolean();
		    
	    while (yesno == true) {

	        int jahr = Anfangsjahr ++; //Jahres Z�hler
	
			Stadt stadt = new Stadt();
			Strasse strasse[] = new Strasse[1];//Am Anfang der Simulation gibt es 1 Strasse mit 10 Grundst�cken
			strasse[0] = new Strasse(10);
			Haus haus[] = new Haus[strasse[0].AGr];
			for (int i = 0; i < haus.length; i++) {
				int AnWohn = new Random().nextInt(20) + 1;
				int Hnr = i;
				int Baujahr = Anfangsjahr;
				boolean Hgebaut = new Random().nextBoolean();
				haus[i] = new Haus(AnWohn, Hnr, Baujahr, Hgebaut, 0);
			}
			
			int[] whnstats = stadt.Wohnungsstatistik(haus);
			int[] meldeamt = stadt.Meldeamt(whnstats);
			strasse = stadt.Strassenverzeichnis(haus, strasse);
			haus = stadt.Wohnraumanpassen(haus, strasse, meldeamt, whnstats, jahr);
	
			//Info print out
			System.out.println("Jahr: " + jahr);
			System.out.println("Es ziehen " + meldeamt[1] + " Leute weg und " + meldeamt[0] + " her.");
			System.out.println("Es gibt " + strasse + " Stra�en");
			System.out.println("Es sind in Strasse " + strasse + ", "+ whnstats[1] + " von " + whnstats[0] + " Wohnungen bewohnt.");
			System.out.println("Es gibt " + strasse.length + " H�user");
	
			//Strasse betrachten
			/*System.out.println("Willst du eine Stra�e genau betrachten?");
			String Aw1;
		    Aw1 = scn.nextLine();
		    if (Aw1.contains("t")==true) {
	          int Aw2;
	          System.out.println("Welche Stra�e?");
	          Scanner sc7 = new Scanner(System.in);
	          Aw2 = sc7.nextInt();
	          System.out.println("Stra�e " + Stra�en[Aw2-1].Stra�ennummer + "hat " + Stra�en[Aw2-1].AnzahlGrundst�cke + " Grundst�cke");
	          int Hgebaut = 0;
	          for (int k = 0; k <Stra�en[Aw2-1].H�user.length; k++) {
	            if (Stra�en[Aw2-1].H�user[k].gebaut==true) {
	              Hgebaut++;
	            }
	          }
		    }*/
		    System.out.println("Das Jahr: " + jahr + " endet , Beginnen Sie das n�chste Jahr mit der Eingabe: true, oder beenden sie die Simulation mit: false");
		    yesno = scn.nextBoolean(); //neues Jahr
	    }   
	    if (yesno == false){
	    	System.out.println("Die Simulation wurde beendet.");
	    }
		
		scn.close();
		
	
	}
}
