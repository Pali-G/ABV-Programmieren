//Klasse für das Rock-Tile

import java.awt.image.BufferedImage;

public class RockTile extends Tile{
	
	static BufferedImage rock = ImageLoader.loadImage("/textures/Rock.png");
	
	public RockTile(int id) { //setzt die id
		super(rock, id);
	}
	
	@Override
	public boolean isSolid() {     //legt fest, dass der Spieler nicht durch das Tile hindurchgehen kann
		return true;
	}
	
}