//Klasse für das Wolken Hintergrundtile
import java.awt.image.BufferedImage;

public class AirTile extends Tile{
	
	static BufferedImage air = ImageLoader.loadImage("/textures/Air.png"); //festlegen, welches Bild für das Tile verwendet wird
	
	public AirTile(int id) {     //setzt die id 
		super(air, id);
	}
}