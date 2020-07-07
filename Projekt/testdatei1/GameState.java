import java.awt.Color;
import java.awt.Graphics;

public class GameState extends State {
	
	private Player player;
	private World world;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100,100);
		world = new World(game, "res/Worlds/world1.txt");
		
		
	}
	@Override
	public void update() {
		world.update();
		player.update();
		
	}
	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		//Tile.tiles[0].render(g, 0, 0);
		//Tile.tiles[1].render(g, 64, 0);
	}
}
