import java.util.Scanner; /* Benutzereingabe, scanner teilt die Benutzereingabe in Wörter 
 * mit einem Trennungsmuster
 */

public class calc3 {

    public static void main(String[] args) {
     
        Scanner scn = new Scanner(System.in);

        double fnum;
        double snum;

        char operator;

        System.out.println("Geben Sie die erste Zahl ein:");
        fnum = scn.nextDouble();

        System.out.println("Geben Sie die Zweite Zahl ein:");
        snum = scn.nextDouble();

        System.out.println("Geben Sie den Rechenoperator ein (+,-,*,/)");
        operator = scn.next().charAt(0);

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

        scn.close();
    }
}
