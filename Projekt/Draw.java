import java.awt.*;
import javax.swing.*;

/* TODO:
 * Hintergrund
 * Bild für Runner
 * 
 * */

public class Draw extends JPanel{
	Runner runner = new Runner();
	static MenuGUI frame;
	public static void main(String[] args) {
		
		frame = new MenuGUI();
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		
		/*TODO BACKGROUND*/
		//Runner
		g2.setColor(runner.color);
		g2.fillRect(runner.posX, runner.posY, runner.width, runner.height);
		/*TODO BILD RUNNER*/
		repaint();
	}
}
