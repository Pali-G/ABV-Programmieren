import java.util.Scanner; /* Benutzereingabe, scanner teilt die Benutzereingabe in Wörter 
 * mit einem Trennungsmuster
 */

public class calc3 {

    public static void main(String[] args) {
        
        /*Benutzereingabe starten
	*(stub, automatically generated method  
	*has left the body blank to be filled in) */
        Scanner scn = new Scanner(System.in);

        // Variabeln
        double fnum;
        double snum;
        // für Rechenoperatoren
        char operator;

	// Benutzereingabe
        System.out.println("Geben Sie die erste Zahl ein:");
        fnum = scn.nextDouble();

        System.out.println("Geben Sie die Zweite Zahl ein:");
        snum = scn.nextDouble();

        System.out.println("Geben Sie den Rechenoperator ein (+,-,*,/)");
        operator = scn.next().charAt(0);

	//Operator Eingabe Vorraussetzungen
        if (operator == '*') {
            System.out.println(fnum * snum);
        }else if (operator == '/'){
            System.out.println(fnum / snum);
        }else if (operator == '+'){
            System.out.println(fnum + snum);
        }else if (operator == '-'){
            System.out.println(fnum - snum);
        }else {
            System.out.println("Ungültiges Zeichen");
        }

	//Benutzereingabe beenden
        scn.close();
    }
}
