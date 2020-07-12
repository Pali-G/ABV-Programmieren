import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SkinState extends State{

	private UIManager uiManager;
	BufferedImage[] flower = new BufferedImage[2];
	BufferedImage[] tree = new BufferedImage[2];
	
	private String pathFlower = "/textures/Player1.png";
	private String pathTree = "/textures/Player2.png";
	
	public SkinState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		setButtons();
		uiManager.addObject(new UIImageButton(236, 302, 128, 64, flower, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().setPath(pathFlower);
				handler.getGame().initSettingsState();
				State.setState(handler.getGame().settingsState);
			}}));
		uiManager.addObject(new UIImageButton(236, 234, 128, 64, tree, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().setPath(pathTree);
				handler.getGame().initSettingsState();
				State.setState(handler.getGame().settingsState);
			}}));
		
	}
	
	private void setButtons()  {
		flower[0] = ImageLoader.loadImage("/textures/Flowerb.png");
		flower[1] = ImageLoader.loadImage("/textures/Flowerw.png");
		
		tree[0] = ImageLoader.loadImage("/textures/Treeb.png");
		tree[1] = ImageLoader.loadImage("/textures/Treew.png");
	}

	@Override
	public void update() {
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

	@Override
	public Player getPlayer() {
		return null;
	}

}
