import java.awt.image.BufferedImage;

public class AirTile extends Tile{
	
	static BufferedImage air = ImageLoader.loadImage("/textures/Air.png");
	
	public AirTile(int id) {
		super(air, id);
	}
}
