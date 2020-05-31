// Ein einfaches aber vollständiges Java-Programm
public class HelloWorld
{
  public static void main(String[] args) //Main Methode erstellen
  //muss public sein damit auf die main-Methode
  // und damit das Programm zugegriffen werden kann
  {
    System.out.println("Hello World!"); // Ausgabe einer Nachricht ""
    //"println" damit in eine neue Zeile geschrieben wird.
  }
}//end of class hello_world

/*
Wie kann man das Programm an Dritte weitergeben,
sodass diese es auf ihren Rechnern ausführen können?

In Eclipse:
Projekt -> File --> Export ->  Wähle "Runnable JAR file" im Ordner "Java"
als Export-Wizard-> Export-Ziel festlegen

Im Terminal:
Man muss die Quelltext Datei (die mit der .java Endung)kompilieren.
Die .class Datei lässt sich schon ausführen.
Um eine .jar Datei (Java Archive Datei) zu erstellen,
muss eine Manifest-Datei erstellt werden,
wo die Einstiegsklasse mit der main()-Methode referenziert wird.
Dann wird die .jar Datei mit dem Befehl "jar path/Manifest.MF *.class" erstellt.
Die .jar Datei ist ein Zip-Archiv und enthält viele Dateien.
In ihr werden zusätzlich auch Metadaten und andere Ressourcen
wie z.B. Bilder gespeichert.
Wenn man ein java-Programm an dritte weiter geben möchte,
wäre es viel sinnvoller, dies als .jar Datei zu tun,
als eine .class Datei zu verschicken, wenn das Programm mehrere Dateien enthält.
Die jar Datei kann dann vonn der dritten Person mit java -jar ausgeführt werden.
*/