//Oberklasse für Tiles, also Bildelemente mit unterschiedlichen Eigenschaften


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[300];        //Array, in dem die Tiles gespeichert werden
	public static Tile airTile = new AirTile(0);       //erschafft eine Instanz des Tiles
	public static Tile groundTile = new GroundTile(1);
	public static Tile rockTile = new RockTile(2);
	
	
	
	//Class
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture; //protected damit die Unterklassen darauf zugreifen können
	protected final int ID;          // final, da wir die ID nie verändern wollen
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture; //Bild, das für das Tile verwendet wird
		this.ID = id;
		
		tiles[id] = this; //setzt den id-ten Eintrag des Arrays gleich dem passenden Tile
	}
	
	public boolean isSolid() { //Interaktion mit Tiles
		return false;
	}
	//alles braucht tick und render, um zu funktionieren
	public void tick() {
		
	}
	
	public void render (Graphics g, int x, int y) {              //Methode zum Zeichnen eines Tiles auf den Bildschirm
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	//getter
	public int getID () {
		return ID;
	}
}