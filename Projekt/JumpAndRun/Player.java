	import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player {
	
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected  Rectangle bounds;
	
	public static final float DEFAULT_YSPEED = 8.0f;	
	public static final int DEFAULT_WIDTH = 64;
	public static final int DEFAULT_HEIGHT = 64;
	
	protected float ySpeed;
	protected float xMove, yMove;
	
	//jump stuff
	private int jumpTimestep;								//Zeit pro tick
	private long lastTime, timer;							
	private float jumpSpeed;								//Beschleunigung
	private float jumpIncr = 0.4f;
	public static final float DEFAULT_JUMPSPEED = -8.0f;	//standard Beschleunigung
	private boolean jumping;								
	private int ticks;
	
	//fail
	public boolean failed;
	
	protected BufferedImage playerImage;
	
	public Player(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(0, 0, width, height);
		ySpeed = DEFAULT_YSPEED;	
		xMove = 4.0f;
		yMove = DEFAULT_YSPEED;
		bounds.x = 20;
		bounds.y = 39;
		bounds.width = 25;
		bounds.height = 25;
		
		jumpTimestep = 1;
		timer = 0;
		lastTime = System.currentTimeMillis();
		jumpSpeed = DEFAULT_JUMPSPEED;
		jumping = false;
		ticks = 0;
		
		failed = false;
		
		playerImage = ImageLoader.loadImage(handler.getGame().path);
	}
	
	public void positionAt(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setFailed(boolean failed) {
		this.failed = failed;
	}
	
	private void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	private void resetYspeed() {
		ySpeed = DEFAULT_YSPEED;
	}
	
	private boolean getOnGround() {
		boolean onGround;
		if(handler.getWorld().getTile((int) x/Tile.TILEWIDTH, (int)(y + bounds.y + bounds.height + 1)/Tile.TILEHEIGHT).isSolid() 
				|| handler.getWorld().getTile((int) (x+ bounds.x)/Tile.TILEWIDTH , (int)(y + bounds.y + bounds.height + 1)/Tile.TILEHEIGHT).isSolid()) {
			onGround = true; 
		}else {
			onGround = false;
		}	
		return onGround;
	}
	
	public void update() {
		if (handler.getKeyManager().up && getOnGround()) { //
			setJumping(true);
		}
		if(jumping) {
			timer += System.currentTimeMillis() - lastTime;
			lastTime = timer;
			yMove = jumpSpeed; 
			if (timer > jumpTimestep) {		//jeden jumpTimestep in ms wird der jump speed kleiner
				jumpSpeed += jumpIncr;
				ticks++;
				timer = 0;
			}
			if (ticks == (-2 * DEFAULT_JUMPSPEED / jumpIncr)) {  //ticks == Zeit für einen kompletten Sprung
				setJumping(false);
				ticks = 0;
				jumpSpeed = DEFAULT_JUMPSPEED;
				ySpeed = -1 * DEFAULT_JUMPSPEED; 	//damit der Fall bei Sprung von Block nicht nach Ende des Sprungs gebremst wird auf DEFAULT_YSPEED  
			}else if(getOnGround() && ticks >= (-1* DEFAULT_JUMPSPEED / jumpIncr)) {
				setJumping(false);
				ticks = 0;
				jumpSpeed = DEFAULT_JUMPSPEED;
				ySpeed = -1 * DEFAULT_JUMPSPEED;
			}
		}
		getInput(jumping);
		move();
		handler.getGameCamera().centerOnPlayer(this);
	}
	
	private void getInput(boolean jumping) {
		if (getOnGround()) {
			resetYspeed();
		}
		if (!jumping) {
			yMove = ySpeed;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(playerImage, (int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), null);
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {					//moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) /Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) /Tile.TILEHEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILEWIDTH -bounds.x - bounds.width - 1;
				failed = true;
			}
		}
	}
	
	public void moveY() {
		if(yMove < 0) {//up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) /Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) /Tile.TILEWIDTH, ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}
		if(yMove > 0) {//down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) /Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) /Tile.TILEWIDTH, ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILEHEIGHT -bounds.y -bounds.width - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
		}
	
	//GETTERS AND SETTERS	
	/*public float getxMove() {
		return xMove;
	}*/

	/*public void setxMove(float xMove) {
		this.xMove = xMove;
	}*/

	/*public float getyMove() {
		return yMove;
	}*/

	/*public void setyMove(float yMove) {
		this.yMove = yMove;
	}*/
	
	/*public float getySpeed() {
		return ySpeed;
	}*/


	/*public void setySpeed(float speed) {
		this.ySpeed = speed;
	}*/

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	/*public void setHeight(int height) {
		this.height = height;
	}*/

	public int getWidth () {
		return width;
	}
	
	/*public void setWidth(int width) {
		this.width = width;
	}*/
}

