import java.awt.Graphics;

// Displays die Tiles als Welt
public class World {
	
	private Handler handler;
	private int width, height;	//größe der Welt, Anzahl der Teils x und y Richtung
	private int[][] tiles;	// Id der unterschiedlichen Tiles
	private int spawnX, spawnY;
	
	// Lädt unsere erstellte Welt von unserer Welt.txt über den Path in GameState
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}
	
	public void update() {
		
	}

	// Loops für die einzelnen Koordinaten und ordnet diesen die Tiles 
	// ruft Tile getTile auf um die Tile Id herauszufinden
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/ Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())/ Tile.TILEHEIGHT + 1);;
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {

				// Tiles werden zu Pixel konvertiert um die 64x64 px großen teils in der richtigen größe anzuzeigen
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}

	// ruft die Tiles auf und zeigt sie in den Koordinaten 
	public Tile getTile(int x, int y) {
		/*if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.airTile;	
		}*/

		// Vergleicht Tile id und Position
		Tile t = Tile.tiles[tiles[x][y]];

		// falls eine Tile Id aufgerufen wird, die es nicht gibt wird eine groundTile angezeigt
		if (t==null) {
			return Tile.groundTile;
		}
		return t;
	}

	//Lädt die unterschiedlichen Tiles an die Stellen aus der Text Datei
	private void loadWorld(String path) {
		String file	= Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");	// Teilt den World.txt String anhand von Leerzeichen
		
		// Ersten vier Zahlen der txt
		width  = Utils.parseInt(tokens[0]); // Länge der Welt
		height = Utils.parseInt(tokens[1]);	// Höhe
		spawnX = Utils.parseInt(tokens[2]);	// Startpunkt des Players auf X-Achse
		spawnY = Utils.parseInt(tokens[3]);	// Startpunkt des Players auf Y-Achse
		
		tiles = new int[width][height];
		
		// Id des Tiles Arrays werden gesetzt
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width +4)]); // x=0,y=0 -> tokens[4], x=1, y=0 -> t[5]; x=1, y=1, width = 20 -> t[25] usw.
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}

