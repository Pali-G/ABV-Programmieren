import java.awt.Color;
import java.awt.Graphics;

public class GameState extends State {
	
	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 100,100);
	}
	@Override
	public void render(Graphics g) {
		player.render(g);
	}
	@Override
	public void update() {
		player.update();
	}
}
