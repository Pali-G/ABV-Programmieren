import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Klasse um Files zu �ffnen
public class Utils {
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();

		// unsere Files werden �ber einen While Loop geladen
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) {
				builder.append(line + "\n");
			}
		// f�r errors
		}catch(IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}

	// konvertiert Strings mit Zahlen zu einem Int wert
	// Txt Datei der World wird in einzelne int konvertiert
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number); // gibt Nummer aus 
		// f�r den Fall das es sich in dem String nicht um eine Nummer handelt wird 0 ausgegeben
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
}
