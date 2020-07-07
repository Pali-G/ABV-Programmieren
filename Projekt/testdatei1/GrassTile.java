import java.awt.image.BufferedImage;

public class GrassTile extends Tile{
	
	static BufferedImage grass = ImageLoader.loadImage("/textures/Grass.png");
	
	public GrassTile(int id) {
		super(grass, id);
	}
}
