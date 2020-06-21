

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
	Simulationn(2000, 2050);
    }
	
    public static void Simulationn(int Anfangsjahr, int Endjahr) throws InterruptedException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Wie viele Starthäuser soll es geben?");
	String starthaeuser = scanner.nextLine();
	int starth = Integer.parseInt(starthaeuser);
	System.out.println("Wie viel Prozent aller Einwohner sollen maximal nach einem Jahr wegziehen?");
	String wegziehen = scanner.nextLine();
	try {
	    int hinz = Integer.parseInt(wegziehen);
	}catch(Exception e){
	    if (wegziehen.contains("%") == true) {
		int k = -1;
		for(int i = 0; i < wegziehen.length(); i++) {
		    if (wegziehen.charAt(i) == '%') {
			k = i;
		    }
		}
		wegziehen = wegziehen.substring(0, k);
	    }else {
		System.out.println("Bitte geben sie nur eine Zahl ein?");
		wegziehen = scanner.nextLine();
	    }
	}
	int wegz = Integer.parseInt(wegziehen);
	System.out.println("Wie viel Prozent aller Einwohner sollen maximal in einem Jahr in die Stadt ziehen?");
	String hinziehen = scanner.nextLine();
	try {
	    int hinz = Integer.parseInt(hinziehen);
	}catch(Exception e){
	    if (hinziehen.contains("%") == true) {
		int k = -1;
		for(int i = 0; i < hinziehen.length(); i++) {
		    if (hinziehen.charAt(i) == '%') {
			k = i;
		    }
		}
		hinziehen = hinziehen.substring(0, k);
	    }else {
		System.out.println("Bitte geben sie nur eine Zahl ein?");
		hinziehen = scanner.nextLine();
	    }
	}
	int hinz = Integer.parseInt(hinziehen);
	Stadt stadt = new Stadt();
	Strasse strasse[] = new Strasse[1];//Am Anfang der Simulation gibt es 1 Strasse mit 10 Grundstücken
	strasse[0] = new Strasse(starth);
	Hochhaus hochhaus[] = new Hochhaus[strasse[0].AGr/2];
	Einfamilienhaus einfamhaus[] = new Einfamilienhaus[strasse[0].AGr/2];
	for (int i = 0; i < hochhaus.length; i++) {
	    int AnWohn = new Random().nextInt(20) + 1;
	    int Hnr = i;
	    int Baujahr = Anfangsjahr;
	    boolean Hgebaut = new Random().nextBoolean();
	    hochhaus[i] = new Hochhaus(AnWohn, Hnr, Baujahr, Hgebaut, 0);
	}
	for (int i = 0; i < einfamhaus.length; i++) {
	    int AnWohn = new Random().nextInt(1) + 1;
	    int Hnr = i + hochhaus.length;
	    int Baujahr = Anfangsjahr;
	    boolean Hgebaut = new Random().nextBoolean();
	    einfamhaus[i] = new Einfamilienhaus(AnWohn, Hnr, Baujahr, Hgebaut, 0);
	}
	for (int jahr = Anfangsjahr; jahr <= Endjahr; jahr++) {
	    int[] whnstats = stadt.Wohnungsstatistik(hochhaus, einfamhaus);
	    int[] meldeamt = stadt.Meldeamt(whnstats, wegz, hinz);
	    strasse = stadt.Strassenverzeichnis(hochhaus, einfamhaus, strasse);
	    Info(jahr, whnstats, meldeamt, strasse);
	    stadt.Wohnraumanpassen(hochhaus, einfamhaus, strasse, meldeamt, whnstats, jahr);
	    hochhaus = (Hochhaus[]) stadt.stmp.pop();
	    einfamhaus = (Einfamilienhaus[]) stadt.stmp.pop();
	    Thread.sleep(1000);
	}
    }
    public static void Info(int jahr, int[] whnstats, int[] meldeamt, Strasse[] strasse) {
        clearScreen();
	
	System.out.println("    _m_    Es ist das Jahr " + jahr);
	System.out.println("  /\\___\\   Es sind " + whnstats[1] + " von " + whnstats[0] + " Wohnungen bewohnt.");
	System.out.println("  |_|\"\"|   Es ziehen " + meldeamt[1] + " Leute weg und " + meldeamt[0] + " her.");
	System.out.println("_/______\\__Es gibt " + strasse.length + " Straßen");
    }
    public static void clearScreen() {  
	System.out.print("\033[H\033[2J");  
	System.out.flush();  
    }  

}
