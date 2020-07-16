import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	public static boolean[] keys;
	public static boolean up;
	
	public static void update() {
		up = keys[KeyEvent.VK_SPACE]; //Leertaste als KeyEvent = up
	}

	public KeyManager () {
		keys = new boolean[256];			
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {			//up = true wenn Leertaste gedrückt wird
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {			//up = false wenn Leertaste nicht gedrückt wird
		keys[e.getKeyCode()] = false;
	}

}
