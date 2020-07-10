import java.awt.Graphics;

public class GameState extends State {
	
	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/Worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 0, 191, Player.DEFAULT_WIDTH, Player.DEFAULT_HEIGHT);
	
		
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
	}
}	

