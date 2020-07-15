//Kasse für den State, in dem die Skins fuer den Player ausgewaehlt werden koennen



import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SkinState extends State { // Subklasse von State

	private UIManager uiManager;
	BufferedImage[] flower = new BufferedImage[2];
	BufferedImage[] tree = new BufferedImage[2];
 
	private String pathFlower = "/textures/Player1.png";    // Abkuerzung des Dateipfads für die Player Skins
	private String pathTree = "/textures/Player2.png";

	public SkinState(Handler handler) {                     // Methode, die die Auswahl von Skins und den Wechsel zu anderen States moeglich macht
										
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		setButtons();
		uiManager.addObject(new UIImageButton(236, 302, 128, 64, flower, new ClickListener() {
			@Override
			public void onClick() {                                        //setzt den Skin auf Flower, wenn der passende Button geklickt wird 
				handler.getMouseManager().setUIManager(null);
				handler.getGame().setPath(pathFlower);
				handler.getGame().initSettingsState();
				State.setState(handler.getGame().settingsState);
			}
		}));
		uiManager.addObject(new UIImageButton(236, 234, 128, 64, tree, new ClickListener() {
			@Override
			public void onClick() {                                       //setzt den Skin auf Tree, wenn der passende Button geklickt wird 
				handler.getMouseManager().setUIManager(null);
				handler.getGame().setPath(pathTree);
				handler.getGame().initSettingsState();
				State.setState(handler.getGame().settingsState);
			}
		}));

	}

	private void setButtons() {                                           //laedt die Bilder fuer die Skin Buttons
		flower[0] = ImageLoader.loadImage("/textures/Flowerb.png");
		flower[1] = ImageLoader.loadImage("/textures/Flowerw.png");

		tree[0] = ImageLoader.loadImage("/textures/Treeb.png");
		tree[1] = ImageLoader.loadImage("/textures/Treew.png");
	}

	@Override                            //obligatorisch, da Subklasse von State
	public void update() {
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

	@Override
	public Player getPlayer() {          //setzt den player auf Null, da er in der Skinauswahl nicht benoetigt wird
		return null;
	}

}