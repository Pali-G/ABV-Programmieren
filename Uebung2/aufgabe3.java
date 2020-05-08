
public class aufgabe3 {

	public static void main(String[] args){
	
	//Attribute
	  double x = 1.0;
	  double y = 0.0;
	  int m = 3;
	  int n = 1;
	  int max = 2147483647;
	  int min = -2147483648;
	  double z = Double.POSITIVE_INFINITY;

	//Methoden, Ergebnisse ausgabe
	 System.out.println("x/y = " + ( x/y));
	
	 System.out.println("-y/x = " + ( -y/x));
	
	 System.out.println("x/y + x/y = " + (x/y + x/y));
	 
	 System.out.println("x/y – x/y = " + (x/y - x/y));
	 
	 System.out.println("y/y = " + y/y);
	 
	 System.out.println("z/z = " + z/z);
	 
	 System.out.println("n/m = " + n/m);
	 
	 System.out.println("Math.sqrt (-x) = " + Math.sqrt (-x));
	 
	 System.out.println("Math.log (-x) = " + Math.log (-x));
	 
	 System.out.println("max + 1 = " + max+1);
	 
	 System.out.println("min - 1 = " + (min-1));
	 
   	 System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
	 
	 System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
	 
	 System.out.println("Double.MAX_VALUE*2 = " + Double.MAX_VALUE*2);
	 
	 System.out.println("(max+1)== (min) = " + ((max+1)==(min)));
	
	}
	
}

/*
x/y = Infinity
-y/x = -0.0
x/y + x/y = Infinity
x/y – x/y = NaN
y/y = NaN
z/z = NaN
n/m = 0
Math.sqrt (-x) = NaN
Math.log (-x) = NaN
max + 1 = 21474836471
min - 1 = 2147483647
Long.MAX_VALUE = 9223372036854775807
Double.MAX_VALUE = 1.7976931348623157E308
Double.MAX_VALUE*2 = Infinity
(max+1)== (min) = true
*/
