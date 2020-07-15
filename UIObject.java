import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
// bestimmt was mit den UIObjekten passiert, einziges davon abstammenders UI oBjekt ist UIImagebutton, UIObject ist aber praktisch um neue UIObjekte hinzuzufügen 
public abstract class UIObject {
	
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;
	protected boolean hovering = false;
	
	public UIObject (float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		bounds = new Rectangle ((int)x, (int) y, width, height);
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	public abstract void onClick();

	public void onMouseMove(MouseEvent e) {
		if (bounds.contains(e.getX(), e.getY())) {
			hovering = true;
		}else {
			hovering = false;
		}
	}
	
	public void onMouseReleased(MouseEvent e) {
		if (hovering)
			onClick();
	}
	
	//Getters & Setters
	
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
