import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[300];
	public static Tile grassTile = new GrassTile(0);
	public static Tile rockTile = new RockTile(1);
	
	
	
	//Class
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int ID;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.ID = id;
		
		tiles[id] = this;
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public void tick() {
		
	}
	
	public void render (Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public int getID () {
		return ID;
	}
}
