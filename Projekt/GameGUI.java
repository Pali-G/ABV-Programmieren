import java.awt.*;
import javax.swing.*;


import java.awt.event.*;

public class GameGUI extends Draw{
	static int width;
	static int height;
	Draw draw;
	
	public static void main(String[] args) {
		GameGUI frame = new GameGUI("JumpAndRun");
	}
	
	public GameGUI(String title) {
		JPanel panel = new JPanel();//Vllt Notwendig da JPanel weniger Grob und bilder zeichnen leichter
		JFrame frame = new JFrame();
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		height = screensize.height;//wird nur in der draw klasse verwendet
		width = screensize.width;
		frame.setSize(screensize);
		frame.setLocationByPlatform(true);
		//Zeichnen
		draw = new Draw();
		draw.setVisible(true);
		frame.add(draw);
		frame.addKeyListener(new Keys());
		
		frame.pack();
		frame.requestFocus();
		frame.setVisible(true);
		
	}
	private class Keys extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
            case KeyEvent.VK_SPACE:
                /* TODO
                 * Jump
                 * */
            case KeyEvent.VK_RIGHT:
            	/* TODO
            	 * RUN
            	 * */
        }
		}
	}
}


