import java.awt.*;
import javax.swing.*;

public class GameGUI extends JFrame{
	static int width;
	static int height;
	Draw draw;
	
	public static void main(String[] args) {
		GameGUI frame = new GameGUI("JumpAndRun");
	}
	
	public GameGUI(String title) {
		JPanel panel = new JPanel();
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		height = screensize.height;//wird nur in der draw klasse verwendet
		width = screensize.width;
		setSize(screensize);
		setLocationByPlatform(true);
		//Zeichnen
		draw = new Draw();
		draw.setVisible(true);
		add(draw);
		
		
		pack();
		requestFocus();
		setVisible(true);
		
	}
}
