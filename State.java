//Oberklasse, für Methoden, die alle States haben und verwaltet den aktuellen State


import java.awt.Graphics;

public abstract class State {                    //abstract, da sie selbst nichts erzeugt und mehrere Subklassen hat
	
	public static State currentState = null;     //gibt an, in welchem State wir uns gerade befinden
	
	public static void setState(State state) {   //Methode zum Aendern des States
		currentState = state;
	}
	
	public static State getState() {             // Getter für den State
		return currentState;
	}
	
	//Klasse
	protected Handler handler;
	
	public State(Handler handler) {              //Methode, die die States wechseln kann
		this.handler = handler;
	}

	public abstract void update();
	public abstract void render(Graphics g); //das Objekt graphics wird benötigt, um auf den Bildschirm zeichnen zu können
	public abstract Player getPlayer();
	
}