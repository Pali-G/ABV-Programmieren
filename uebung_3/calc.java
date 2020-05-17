package uebung_3;

import java.util.Scanner; /* Benutzereingabe, scanner teilt die Benutzereingabe in W�rter
 * mit einem Trennungsmuster
 */

public class calc {

    public static void main(String[] args) {

    /*Benutzereingabe starten
	*(stub, automatically generated method
	*has left the body blank to be filled in) */
        Scanner scn = new Scanner(System.in);

        // Variabeln
        double fnum;
        double snum;
        double tnum;
        // f�r Rechenoperatoren
        char op1;
        char op2;
        char yesno;

	// Benutzereingabe
        System.out.println("Geben Sie die erste Zahl ein:");
        fnum = scn.nextDouble();

        System.out.println("Geben Sie den Rechenoperator ein (+,-,*,/)");
        op1 = scn.next().charAt(0);

        System.out.println("Geben Sie die Zweite Zahl ein:");
        snum = scn.nextDouble();

        System.out.println("Third number needed? y/n ");
        yesno = scn.next().charAt(0);

        if (yesno == 'y') {
            System.out.println("Geben Sie die dritte Zahl ein:");
            tnum = scn.nextDouble();

            System.out.println("Geben Sie den zweiten Rechenoperator ein (+,-,*,/)");
            op2 = scn.next().charAt(0);



	        /*if (op1 == '*') {
		        System.out.println(fnum * snum);
		    }else if (op1 == '/'){
		        System.out.println(fnum / snum);
		    }else if (op1 == '+'){
	         System.out.println(fnum + snum);
		    }else if (op1 == '-'){
		        System.out.println(fnum - snum);
		    }else {
		        System.out.println("Ung�ltiges Zeichen");
		        System.out.println(fnum op1 snum op2 tnum);
		    }*/


        }
        else if (yesno == 'n') {

	        if (op1 == '*') {
	            System.out.println(fnum * snum);
	        }else if (op1 == '/'){
	            System.out.println(fnum / snum);
	        }else if (op1 == '+'){
	            System.out.println(fnum + snum);
	        }else if (op1 == '-'){
	            System.out.println(fnum - snum);
	        }else {
	            System.out.println("Ung�ltiges Zeichen");
	        }
        }

	//Benutzereingabe beenden
        scn.close();
    }
}
