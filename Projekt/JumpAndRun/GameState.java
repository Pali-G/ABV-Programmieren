import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameState extends State {
	
	private Player player;
	private World world;
	
	private UIManager uiManager;
	private BufferedImage[] tryAgain = new BufferedImage[2];
	private BufferedImage[] menu = new BufferedImage[2];
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/Worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 0, 191, Player.DEFAULT_WIDTH, Player.DEFAULT_HEIGHT);
		uiManager = new UIManager(handler);
		setButtons();
		uiManager.addObject(new UIImageButton(236, 302, 128, 64, menu, new ClickListener() {
			@Override
			public void onClick() {
				player.setFailed(false);
				State.setState(handler.getGame().menuState);
				handler.getMouseManager().setUIManager(null);
				handler.getGame().initMenuState();
				
				
			}
		}));
		uiManager.addObject(new UIImageButton(236, 234, 128, 64, tryAgain, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				player.setFailed(false);
				player.positionAt(0, 191);	
			}
		}));
	}
	
	
	
	private void setButtons() {
		tryAgain[0] = ImageLoader.loadImage("/textures/TryAgainb.png");
		tryAgain[1] = ImageLoader.loadImage("/textures/TryAgainw.png");
		
		menu[0] = ImageLoader.loadImage("/textures/Menub.png");
		menu[1] = ImageLoader.loadImage("/textures/Menuw.png");
	}
	
	@Override
	public void update() {
		world.update();
		player.update();
		uiManager.update();
	}
	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		if (player.failed) {
			handler.getMouseManager().setUIManager(uiManager);
			uiManager.render(g);
		}
		
	}
	
	@Override 
	public Player getPlayer() {
		return player;
	}
}	

