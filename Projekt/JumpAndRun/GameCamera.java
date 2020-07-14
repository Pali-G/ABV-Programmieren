public class GameCamera {
	
	private Game game;
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.handler = handler;
		this.game = handler.getGame();
	}
	
	public void checkBlankSpace(){
		if (xOffset < 0) {
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth()*Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth()*Tile.TILEWIDTH - handler.getWidth();
		}
		if (yOffset < 0) {
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight()*Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight()*Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
	public void centerOnPlayer(Player p) {
		xOffset = p.getX() - game.getWidth() / 2 + p.getWidth() / 2;
		yOffset = p.getY() - game.getHeight() / 2 +  p.getHeight() / 2	;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
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