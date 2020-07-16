import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {		//Objekt dieser Klasse ist ein UIObjekt
	
	private BufferedImage[] images;
	private ClickListener clicker;					//Interface: damit die methode, was im falle des klicks passieren sol, für alle UIImageButtons 
													//beim Initialisieren spezifisch definiert werden kann
			
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Graphics g) { //während die Maus über dem UIImageButton ist, soll ein anderes Bild gemalt werden als wenn nicht
		if (hovering) 
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
