import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	public static boolean[] keys;
	public static boolean up, down, right, left;
	
	public static void update() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_D];
		left = keys[KeyEvent.VK_A];
	}

	public KeyManager () {
		keys = new boolean[256];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
