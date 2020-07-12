import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.TextArea;


public class Menu {
	
	private Window window;
	private int width, height;
	public String title;
	
	// Konstruktor Menu
	public Menu(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		catchMenu();
		showMenu();
		
	}
	
	// get Informationen für den Frame von class: Window
	public void catchMenu() {
	 window = new Window(title, width, height);
	 window.getFrame();
	 window.getCanvas();
	 
	}
	
	// Aufbau des Menüs (Buttons für Welten und Spielstart)
	// noch Probleme mit der Wiedergabe der Buttons 
	public void showMenu() {

	     Component text = new TextArea("Menu");
	     Button button1 = new Button("Play");
	     Component button2 = new Button("choose World");
	     Component button3 = new Button("info");
	     
	     window.add(button2);
	     
	     //Frame.add(text, BorderLayout.NORTH);
	     //Frame.add(button1, BorderLayout.SOUTH);
	    
	    // frame.setSize(width, height);
	    // frame.setVisible(true);
	}
	
	// Width und Height wird ausgegeben
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
