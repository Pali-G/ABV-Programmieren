//Game state Klasse, setzt alles um, das während des eigentlichen Spiels geschieht


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameState extends State { //Subklasse von State
	
	private Player player;
	private World world;
	
	private UIManager uiManager;
	private BufferedImage[] tryAgain = new BufferedImage[2];
	private BufferedImage[] menu = new BufferedImage[2];
	
	public GameState(Handler handler) {                                                        //Einbindung von handler
		super(handler);
		world = new World(handler, "res/Worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 0, 191, Player.DEFAULT_WIDTH, Player.DEFAULT_HEIGHT);     //erstellt eine player Instanz
		uiManager = new UIManager(handler);
		setButtons();
		uiManager.addObject(new UIImageButton(236, 302, 128, 64, menu, new ClickListener() {
			@Override
			public void onClick() {                                                            //erlaubt mit dem passenden Button aus dem Game zum Menu zu gelangen
				player.setFailed(false);
				State.setState(handler.getGame().menuState);
				handler.getMouseManager().setUIManager(null);
				handler.getGame().initMenuState();
				
				
			}
		}));
		uiManager.addObject(new UIImageButton(236, 234, 128, 64, tryAgain, new ClickListener() {   //implementiert einen "neuer Versuch" Button
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				player.setFailed(false);                                                           //setzt die Startposition des Players und, dass er noch nicht gescheitert ist
				player.positionAt(0, 191);
			}
		}));
	}
	
	
	
	private void setButtons() {                                             //implementiert die Buttons für den Fall, dass man in einem Level scheitert
		tryAgain[0] = ImageLoader.loadImage("/textures/TryAgainb.png");
		tryAgain[1] = ImageLoader.loadImage("/textures/TryAgainw.png");
		
		menu[0] = ImageLoader.loadImage("/textures/Menub.png");
		menu[1] = ImageLoader.loadImage("/textures/Menuw.png");
	}
	
	@Override                           //überschreibt Methode aus der Oberklasse
	public void update() {                //update und render, damit GameState sich zeichnen und seine Variablen ändern kann
		world.update();
		player.update();
		uiManager.update();
	}
	@Override
	public void render(Graphics g) {    //zeichnet das Spiel auf den Bildschirm, und zeigt die passenden Buttons an, wenn man einen Fehler macht
		world.render(g);
		player.render(g);
		if (player.failed) {
			handler.getMouseManager().setUIManager(uiManager);
			uiManager.render(g);
		}
		
	}
	
	@Override                           //Getter für den Player
	public Player getPlayer() {
		return player;
	}
}	