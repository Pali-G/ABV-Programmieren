import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


// enter durch GameState() über Player = new Player
// Darstellung des Charakters und Bewegung des Characters

public class Player {

	protected Handler handler;
	protected float x, y;	 								// smoothe game
	protected int width, height;
	protected  Rectangle bounds;							//hitbox des Players ist kleiner als 1 Tile
	protected BufferedImage playerImage;

	public static final int DEFAULT_WIDTH = 64;
	public static final int DEFAULT_HEIGHT = 64;

	protected float xMove, yMove;
	private boolean falling;
	public boolean failed;

	//jump stuff
	private int jumpTimestep;								//Zeit pro tick
	private long lastTime, timer;
	private float jumpSpeed;
	private float fallAcc = 0.5f;							//Falleschleunigung
	public static final float DEFAULT_JUMPSPEED = -10.0f;
	private boolean jumping;

	//Konstruktor
	public Player(Handler handler, float x, float y, int width, int height) {

		// Konstruktor Abschnitt für die Darstellung des Charakters (Player)
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(0, 0, width, height);
		xMove = 4.0f;									//xGeschwindigkeit standard auf 4.0 Pixel pro update
		yMove = 1;										//yGeschwindigkeit standard auf 1.0 Pixel pro update 	(fallen beginnt etwas schneller
		bounds.x = 20;									//														als wenn = 0 ) 
		bounds.y = 39;
		bounds.width = 25;
		bounds.height = 25;

		// Konstruktor Abschnitt für den Sprung des Players
		jumpTimestep = 1;								
		timer = 0;										
		lastTime = System.currentTimeMillis();
		jumpSpeed = DEFAULT_JUMPSPEED;
		jumping = false;

		// Lädt Bild des Players aus dem Bilder Ordner
		playerImage = ImageLoader.loadImage(handler.getGame().pathPlayer); //in Game gespeichert, damit nach Stateitialisierung nicht wieder default
	}

	public void positionAt(float x, float y) {			//für TryAgain, bringt player auf beliebeige Position x, y
		this.x = x;
		this.y = y;
	}

	public void setFailed(boolean failed) {
		this.failed = failed;
		if(failed) {
			xMove = 0;
		}else {
			xMove = 4.0f;
		}
	}

	private void setFalling(boolean falling) {
		this.falling = falling;
	}

	private void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	private boolean getOnGround() { //wenn rechte untere Ecke||linke untere Ecke des Players gleich einem solid tile sind, dann onGround = true
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
		if (handler.getKeyManager().up && getOnGround()) { //wenn leertaste gedrückt und onGround wird gesprungen
			setJumping(true);
		}
		if (!getOnGround() && !jumping) {					//wenn nicht auf dem Boden und nicht am springen wird gefallen
			setFalling(true);
		}
		if(jumping) {
			timer += System.currentTimeMillis() - lastTime;		//Zeit seit der letzten Geschwindigkeitsveränderung/dem ersten call der method
			lastTime = timer;
			yMove = jumpSpeed;				//yMove erhält den wert des JumpSpeeds
			if (timer > jumpTimestep) {		//jeden jumpTimestep in ms wird der betrag des jump speeds kleiner
				jumpSpeed += fallAcc;		//um den Wert der Fallbeschleunigung
				timer = 0;					//timer reset
			}
			if (jumpSpeed >= 0) {			// sobald jumpSpeed bis auf null oder höher incrementiert ist, 
				jumpSpeed = DEFAULT_JUMPSPEED;		//reset des jumpSpeeds
				setJumping(false);					//jump endet
				setFalling(true);					//fallen beginnt
			}
		}else if (falling) {				//Im Falle des Fallens:
			timer += System.currentTimeMillis() - lastTime;			//timer genau wie beim sprung
			lastTime = timer;
			if (timer > jumpTimestep) {								//nach einer ms:
				yMove += fallAcc;									//yMove selbst wird incrementiert.
				timer = 0;											//timer reset
			}
			if (getOnGround()) {									//nach erreichen des bodens
				setFalling(false);									//fall vorbei
				yMove = 1;											//yMove reset
			}
		}
		move();														//veränderung der Koordinaten des Players um yMove und xMove
		handler.getGameCamera().centerOnPlayer(this);				//Camera wird auf Player gesetzt
	}

	// Draws Player on the Screen
	public void render(Graphics g) {								
		g.drawImage(playerImage, (int) (x - handler.getGameCamera().getxOffset()),		
				(int) (y - handler.getGameCamera().getyOffset()), null);
	}

	public void move() {
		moveX();
		moveY();
	}

	// gleichbleibende Bewegung in x-Richtung die nur von Festen Tiles unterbrochen werden kann
	public void moveX() {
		if(xMove > 0) {					//moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) /Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) /Tile.TILEHEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILEWIDTH -bounds.x - bounds.width - 1;
				setFailed(true);
			}
		}
	}

	// Bewegung in y-Richtung  (Springen)
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

	//Tiles die Fest sind werden als solche erkannt
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