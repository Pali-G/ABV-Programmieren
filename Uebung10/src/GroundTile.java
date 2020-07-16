//Klasse für das Boden-Bildelement

import java.awt.image.BufferedImage;

public class GroundTile extends Tile{  //Unterklasse von Tile
	
	static BufferedImage ground = ImageLoader.loadImage("/textures/Ground.png");  //Bild, das verwendet wird
	
	public GroundTile(int id) {
		super(ground, id);
	}
	@Override                           //Hinweis, dass wir eine Methode aus der Oberklasse verändern
	public boolean isSolid() { 
		return true;                    //festlegen, dass der Spieler nicht durch Boden-Tiles hindurchgehen kann
	}
}