import java.awt.image.BufferedImage;

public class GroundTile extends Tile{
	
	static BufferedImage ground = ImageLoader.loadImage("/textures/Ground.png");
	
	public GroundTile(int id) {
		super(ground, id);
	}
	@Override
	public boolean isSolid() {
		return true;
	}
}