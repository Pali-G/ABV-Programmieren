import java.awt.Color;
import java.awt.Graphics;

public class Player extends Creature{
	
	private Game game;	

	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	@Override
	public void update() {
		if(game.getKeyManager().up) {
			y -= 3;
		}
		if(game.getKeyManager().down) {
			y += 3;
		}
		if(game.getKeyManager().left) {
			x -= 3;
		}
		
		if(game.getKeyManager().right) {
			x += 3;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int) x, (int) y, 23, 23);
		g.setColor(Color.green);
		g.fillRect((int) x+4, (int) y+4, 15, 15);
	//	g.drawImage(testImage, 10, 10, null);
	}
	
}
