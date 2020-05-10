import java.util.Scanner;

public class calculator{
    static String term;
    public static void main(String[] args){
	//Überprüfen ob eingabe über args erfolgt und korrekt ist
	if (args.length > 0) {
	    term = args[0];
	    if (args.length > 1) {//Überprüfen pb zu viele Argument in Args
    		System.out.println("Bitte geben sie den Term korrekt ein. Bei Fragen help oder ? eingeben");
		return;
	    }
	}else {
	    System.out.println("Bitte term Eingeben:");
	    Scanner sc = new Scanner(System.in);
	    term = sc.nextLine();  
	}
	if (term.contains("help") || term.contains("?")){
	    help();
	    return;
	}
	//Überprüfen ob Klammersetzung korrekt
	if (correctBrackets(term) == false){
	    System.out.println("Bitte geben sie den Term korrekt ein. Bei Fragen help oder ? eingeben");
	    return;
	}
	//Aufrufen der Funktion zur Lösung des Terms
	double result = reduceTerm(term);
	System.out.println("Das Ergebnis ist: " + result);
    }

    public static double reduceTerm(String term){
	double tmpres = 0;
	int len = term.length();
	for (int i = 0; i <= (len-1); i++){
	    for(int j = (len - 1); 0 <= j; j--){
		//Wenn äußere Klammern da sind, mit neuen Term ohne Klammern reduceTerm erneut aufrufen
		if (term.charAt(i) == '(' && term.charAt(j) == ')' && outerBrackets(term) == true){
		    String newterm = term.substring(i+1,j);
		    System.out.println(newterm);
		    tmpres = reduceTerm(newterm);
		    return tmpres;
		}else if (term.charAt(i) == term.charAt(j) && term.charAt(i) == '-' && inBrackets(term, i) == false){//Wenn ein minus außerhalb von Klammern enthalten ist. Damit Das minus nicht einmal durch die i Schleife und einmal durch die j schleife aufgerufen wird, müssen beide übereinstimmen
		    double[] number = new double[2];
		    String newterm1 = term.substring(0, i); //Am der Stelle wo das minus ist wird der Term in zwei substrings gesplittet
		    String newterm2 = term.substring(i+1, term.length());
		    number[0] = reduceTerm(newterm1);//Diese Substrings werden dann berechnet, in dem reduceTerm aufgerufen wird
		    number[1] = reduceTerm(newterm2);
		    tmpres = number[0]- number[1];//Die ergebnisse der Substrings werden subtraiert
		}else if (term.charAt(i) == term.charAt(j) && term.charAt(i) == '+' && inBrackets(term, i) == false&& cAO(term, '-') == false){//Addition
		    double[] number = new double[2];
		    String newterm1 = term.substring(0, i);
		    String newterm2 = term.substring(i+1, term.length());
		    number[0] = reduceTerm(newterm1);
		    number[1] = reduceTerm(newterm2);
		    tmpres = number[0] + number[1];
		}else if (term.charAt(i) == term.charAt(j) && term.charAt(i) == '*' && inBrackets(term, i) == false && cAO(term, '+') == false && cAO(term, '-') == false){//Multiplikation
		    double[] number = new double[2];
		    String newterm1 = term.substring(0, i);
		    String newterm2 = term.substring(i+1, term.length());
		    number[0] = reduceTerm(newterm1);
		    number[1] = reduceTerm(newterm2);
		    tmpres = number[0]* number[1];
		}else if (term.charAt(i) == term.charAt(j) && term.charAt(i) == '/' && inBrackets(term, i) == false && cAO(term, '+') == false && cAO(term, '-') == false && cAO(term, '*') == false){//Division
		    double[] number = new double[2];
		    String newterm1 = term.substring(0, i);
		    String newterm2 = term.substring(i+1, term.length());
		    number[0] = reduceTerm(newterm1);
		    number[1] = reduceTerm(newterm2);
		    tmpres = number[0]/ number[1];
		}else if (noTerms(term) == true){//Wenn der Term nur noch aus einer Zahl besteht, wird dieser in ein Double konvertiert
		    tmpres = Double.parseDouble(term);
		}
	    }
	}
	return tmpres;
    }

    //Prüfen ob übergebender Operator in Klammern
    public static boolean cAO(String term, char operator){
	boolean contOper = false;
	for (int i = 0; i <= term.length()-1; i++){
	    if (term.charAt(i) == operator && inBrackets(term, i) == false){
		contOper = true;
	    }
	}
	return contOper;
    }

    //Hilfsfunktion zur überprüfung Term vollständig in Klammern gefasst ist
    public static boolean outerBrackets(String term){
	boolean outerBracket = true;
	for (int i = 0; i <= (term.length()-1); i++){
	    if (term.charAt(i) == '/' || term.charAt(i) == '*' ||term.charAt(i) == '+' ||term.charAt(i) == '-'){
		outerBracket = false;
	    }
	    if (term.charAt(i) == '('){
		break;
	    }
	}
	for(int j = (term.length() - 1); j > 0; j--){
	    if (term.charAt(j) == '/' || term.charAt(j) == '*' ||term.charAt(j) == '+' ||term.charAt(j) == '-'){
		outerBracket = false;
	    }
	    if (term.charAt(j) == ')'){
		break;
	    }
	}
	return outerBracket;
    }

    //Überprüfen ob noch Operatoren oder Klammern im Term sind
    public static boolean noTerms(String term){
	boolean noTerm = true;
	for (int i = 0; i < term.length(); i++){
	    if(term.charAt(i) == '+' || term.charAt(i) == '-' || term.charAt(i) == '*' || term.charAt(i) == '/' || term.charAt(i) == '(' || term.charAt(i) == ')'){
		noTerm = false;
	    }
	}
	return noTerm;
    }
    //Hilfsfunktion ob Element in Klammern
    public static boolean inBrackets(String term, int posElement){
	boolean inBracket = false;
	for (int i = 0; i <= term.length()-1; i++){
	    for (int j = (term.length() - 1); i < j; j--){
		if (term.charAt(i) == '(' && term.charAt(j) == ')'){
		    if (posElement > i && posElement < j){
			inBracket = true;
		    }
		}
	    }    
	}
	return inBracket;
    }

    //Hilfsfunktion zur überprüfung ob Klammern korrekt geöffnet und geschlossen wurden sind
    public static boolean correctBrackets(String term){
	boolean corBrac = true;
	int counter = 0;
	for (int i = 0; i < term.length(); i++){
	    if (term.charAt(i) == '('){
		counter++;
	    }
	    if (term.charAt(i) == ')'){
		counter--;
	    }
	}
	if (counter != 0){
	    corBrac = false;
	}
	return corBrac;
    }
    
    public static void help() {
    	System.out.println("Folgende Informationen gibt es zur Benutzung dieses Taschenrechners:");
	System.out.println("- Setzen sie zwischen jede Zahl und Operator und Klammer ein Leerzeichen");
	System.out.println("  z.B. ( 3 + 2 ) / 4 * ( 5 - 2 )");
	System.out.println("- Achten sie auf korrekte Klammersetzung");
	System.out.println("- schreiben sie ihren term als einen String (in Anführungszeichen) wenn sie den Taschenrechner in der Command Line nutzen");
	return;
    }
    
}
