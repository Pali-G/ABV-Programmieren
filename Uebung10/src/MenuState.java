//Klasse, für den Menu State, von dem aus man zu den Settings und ins Spiel kommt

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuState extends State{											//subclass von State
	
	private UIManager uiManager;
	private BufferedImage[] startButtons = new BufferedImage[2];
	private BufferedImage[] settingsButtons = new BufferedImage[2];
	
	public MenuState(Handler handler) {
		super(handler);														//Implementierung des Handlers
		
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		setButtons();
		uiManager.addObject(new UIImageButton(236, 234, 128, 64, startButtons, new ClickListener() {
			@Override
			public void onClick() {											//wenn Button geklickt, dann beginnt der GameState
				handler.getMouseManager().setUIManager(null);
				handler.getGame().initGameState();
				State.setState(handler.getGame().gameState);	
			}} ));
		uiManager.addObject(new UIImageButton(236, 302, 128, 64, settingsButtons, new ClickListener() {
			@Override
			public void onClick() {											//wenn Button geklickt, dann beginnt der SettingsState
				handler.getMouseManager().setUIManager(null);
				handler.getGame().initSettingsState();
				State.setState(handler.getGame().settingsState);
			}} ));
	}
	private void setButtons() {														//speichert die Bilder für die jeweiligen buttons
		startButtons[0] = ImageLoader.loadImage("/textures/Startb.png");			
		startButtons[1] = ImageLoader.loadImage("/textures/Startw.png");
		
		settingsButtons[0] = ImageLoader.loadImage("/textures/Settingsb.png");
		settingsButtons[1] = ImageLoader.loadImage("/textures/Settingsw.png");
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