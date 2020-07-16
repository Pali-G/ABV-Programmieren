package Uebung10;

import Uebung10.display.Display;

public class Launcher {

  public static void main(String[] args){
    // temporärer Display zur probe
    // new Display("Title!", 300, 300);
    // neues Spiel wird über Game class geöffnet
    new Game("Jump and Run", 300, 300);
  }

}
