import java.awt.Graphics;
import java.awt.image.BufferedImage;
// UI Image Button ist der Effekt wenn man im Menü mit dem Zeiger über einem Button schwebt oder ihn drückt 
public class UIImageButton extends UIObject {
	
	private BufferedImage[] images;
	private ClickListener clicker;

	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		if (hovering)   //Effekt wenn die Maus über etwas schwebt 
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
