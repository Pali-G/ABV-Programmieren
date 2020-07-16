package Uebung10;

import Uebung10.display.Display;

public class Game implements Runnable {

  private Display display;
  public int width, height;
  public String title;

  // für while loop
  private boolean running;

  // thread allows to run the thread speparetly from the rest of the Game
  private Thread thread;

  public Game(String title, int width, int height) {
    this.width = width;
    this.height = height;
    this.title = title;
  }

  private void init(){
    display = new Display(title, width, height);
  }

  private void tick(){

  }

  private void render() {

  }

  // Thread laufen lassen
  public void run(){

    init();

    //loop für das spiel (aktualisiert Objekte und ihre Standorte)
    while(running){
      tick();
      render();
    }

    stop();
  }

  // startet Thread, synchronized bei thread funktion
  public synchronized void start() {
    // safety für Fehelermeldung, damit kein SPiel gestartet wird das schon läuft
    if(running)
      return;
    running = true;
    thread = new Thread(this); // startet this class mit thread
    threas.start();
  }

  // endet thread
  public synchronized void stop() {
    //safety für Fehlermeldeungen damit kein Spiel gestopt wird das schon gestopt wurde
    if(!running)
      return;
    try {
      tread.join();
    }catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
