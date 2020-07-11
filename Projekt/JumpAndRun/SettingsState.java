import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SettingsState extends State{
	
	private UIManager uiManager;
	private BufferedImage[] choosePlayerSkin = new BufferedImage[2];
	private BufferedImage[] chooseWorld = new BufferedImage[2];
	private BufferedImage[] menuButton = new BufferedImage[2];
	
	public SettingsState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		setButtons();
		uiManager.addObject(new UIImageButton(236, 302, 128, 64, menuButton, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().initMenuState();
				State.setState(handler.getGame().menuState);
			}
		}));
		uiManager.addObject(new UIImageButton(236, 234, 128, 64, choosePlayerSkin, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().initSkinState();
				State.setState(handler.getGame().skinState);
			}}));
		
	}
	
	private void setButtons() {
		choosePlayerSkin[0] = ImageLoader.loadImage("/textures/Skinsb.png");
		choosePlayerSkin[1] = ImageLoader.loadImage("/textures/Skinsw.png ");
		
		menuButton[0] = ImageLoader.loadImage("/textures/Menub.png");
		menuButton[1] = ImageLoader.loadImage("/textures/Menuw.png");
	}
	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}
	
	@Override
	public void update() {
		uiManager.update();
	}

	@Override
	public Player getPlayer() {
		return null;
	}
}
