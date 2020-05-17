//import java.io.IOException;
import java.util.Scanner; 

public class rechner {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        double fnum;
        double snum;
        double tnum;

        char operator;
        char yesno;

        System.out.println("Insert first number:");
        fnum = scn.nextDouble();

        System.out.println("Insert second number:");
        snum = scn.nextDouble();

        System.out.println("Third number needed? y/n ");
        yesno = scn.next().charAt(0);

            if (yesno == 'y') {
                System.out.println("Insert third number:");
                tnum = scn.nextDouble();
            }
            else if (yesno == 'n') {
                System.out.println("Proceeding...");
                tnum = 
            }

        System.out.println("Geben Sie den Rechenoperator ein (+,-,,/)");
        operator = scn.next().charAt(0);

            if (operator == '*') {
                System.out.println(fnum * snum);
            }
            else if (operator == '/'){
                System.out.println(fnum / snum);
            }
            else if (operator == '+'){
                System.out.println(fnum + snum);
            }
            else if (operator == '-'){
                System.out.println(fnum - snum);
            }
            else {
                System.out.println("Ungültiges Zeichen");
            }

        scn.close();
    }
}