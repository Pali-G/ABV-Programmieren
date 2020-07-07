import java.awt.Color;
import java.awt.Graphics;

public class Player extends Creature{

	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
	}

	@Override
	public void update() {
		getInput();
		move();
		game.getGameCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up) {
			yMove = -speed;
		}
		if(game.getKeyManager().down) {
			yMove = speed;
		}
		if(game.getKeyManager().left) {
			xMove = -speed;
		}
		if(game.getKeyManager().right) {
			xMove = speed;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(ImageLoader.loadImage("/textures/Player.png"), (int) (x - game.getGameCamera().getxOffset()), 
				(int) (y - game.getGameCamera().getyOffset()), null);
	//	g.drawImage(testImage, 10, 10, null);
	}
	
}
