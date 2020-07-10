public class GameCamera {
	
	private Game game;
	private float xOffset, yOffset;
	
	public GameCamera(Game game, float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.game = game;
	}
	
	public void centerOnPlayer(Player p) {
		xOffset = p.getX() - game.getWidth() / 2 + p.getWidth() / 2;
		yOffset = p.getY() - game.getHeight() / 2 +  p.getHeight() / 2	;
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}