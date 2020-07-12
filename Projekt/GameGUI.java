import java.awt.*;
import javax.swing.*;


import java.awt.event.*;

public class GameGUI extends Draw{
	static int width;
	static int height;
	Draw draw;
	
	public GameGUI(String title) {
		JFrame frame = new JFrame();
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		height = screensize.height;//wird nur in der draw klasse verwendet
		width = screensize.width;
		frame.setPreferredSize(screensize);
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
            	System.out.println("bla");
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


