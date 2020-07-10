import java.awt.image.BufferedImage;

public class RockTile extends Tile{
	
	static BufferedImage rock = ImageLoader.loadImage("/textures/Rock.png");
	
	public RockTile(int id) {
		super(rock, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}