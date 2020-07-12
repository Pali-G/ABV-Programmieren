import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
	
	// Key Listener
	public class KeyManager implements KeyListener{
		
		public static boolean[] keys;
		public static boolean up, down, right, left;
		
		public static void update() {
			up = keys[KeyEvent.VK_SPACE];
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

}
