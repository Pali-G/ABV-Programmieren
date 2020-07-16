package Uebung10;

import javax.swing.JFrame;
import java.awt.Canvas;

public class Display {

  // JFrame Object, das Fenster
  private JFrame frame;
  private Canvas canvas; //allows to draw on a canvas

  // Title und größe des Fenster variable erstellt
  private String title;
  private int width, height;

  // Variablen zugeordnet in Konstruktor
  public Display(String title, int width, int height){
    this.title = title;
    this.width = width;
    this.height = height;

    //createDisplay-Methode aufrufen
    createDisplay();
  }

  private void createDisplay(){
    frame = new JFrame(title); // Title eingestellt
    frame.setSize(width,height); // größe eingestellt
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Programm richtig beeneden
    frame.setResizable(false); // Größe des Fensters bleibt
    frame.setLocationRelativeTo(null); // mitig vom Bildschrim geöffnet
    frame.setVisible(true); // Fenster ist sichtbar

    canvas = new Canvas();// neue Leinwand mit gegebener Größe
    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setMaximumSize(new Dimension(width, height));
    canvas.setMinimumSize(new Dimension(width, height));

    frame.add(canvase);//Leinwand zu Fenster hinzufügen
    frame.pack(); //Die ganze Leinwand wird gezeigt bei veränderung der Fenster größe

  }

}
