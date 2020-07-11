import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/* TODO:
 * Bild für Runner
 * 
 * optionale TODOs:
 * verschiedene Levels
 * */

public class GamePanel extends JPanel{
	Runner runner = new Runner();
	//int key;
	
	
	public GamePanel() {
		//key = 0;//Sicherheitshalber key bei Start auf 0 setzen
		addKeyListener(new MyKey());
		setFocusable(true);
		requestFocusInWindow();
	}
	public Dimension getPreferredSize() {
	      // so that our GUI is big enough
	      return new Dimension(runner.r_width + 2 * runner.posX, runner.r_height + 2 * runner.posY);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Graphics2D g2 = (Graphics2D)g;
		g.drawRect(runner.posX, runner.posY, runner.r_width, runner.r_height);
	}
	
	private class MyKey extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_SPACE) {
				runner.posX += 100;
			}
			if(key == KeyEvent.VK_1) {
				runner.posX += 100;
			}
			repaint();
		}
		
	}

}

