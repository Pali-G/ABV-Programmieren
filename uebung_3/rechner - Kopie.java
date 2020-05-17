package uebung_3;

import java.util.Scanner; 
/* Benutzereingabe, scanner teilt die Benutzereingabe in Wörter 
 * mit einem Trennungsmuster
 */

public class rechner {
	
	public static void main(String[] args) {
		//stub, automatically generated method  
		///has left the body blank to be filled in
		Scanner benutzereingabe = new Scanner(System.in);
		
		double ersteZahl;
		double zweiteZahl;
		
		char operator;
		
		System.out.println("Geben Sie die erste Zahl ein:");
		ersteZahl = benutzereingabe.nextDouble();
		
		System.out.println("Geben Sie die Zweite Zahl ein:");
		zweiteZahl = benutzereingabe.nextDouble();
		
		System.out.println("Geben Sie den Rechenoperator ein (*,/,+,-:)");
		operator = benutzereingabe.next().charAt(0);
		
		if (operator == '*') {
			System.out.println(ersteZahl * zweiteZahl);
		}else if (operator == '/'){
			System.out.println(ersteZahl / zweiteZahl);
		}else if (operator == '+'){
			System.out.println(ersteZahl + zweiteZahl);
		}else if (operator == '-'){
			System.out.println(ersteZahl - zweiteZahl);
		}else {
			System.out.println("Ungültiges Zeichen");
		}
		
		benutzereingabe.close();
	}
	

}
