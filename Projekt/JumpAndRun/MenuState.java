import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State{
	
	public MenuState(Handler handler) {
		super(handler);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10, 10);
	}
	
	@Override
	public void update() {
		//System.out.println(handler.getMouseManager().getMouseX() + "     " + handler.getMouseManager().getMouseY());
	}
}