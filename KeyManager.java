import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 // 
public class KeyManager implements KeyListener{
	
	public static boolean[] keys;
	public static boolean up;
	
	public static void update() {
		up = keys[KeyEvent.VK_SPACE];   // Leertaste als keyevent 
	}

	public KeyManager () {
		keys = new boolean[256];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;   // Abfrage ob Taste gedrückt wird, wenn true = taste gedrückt
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;   // Abfrage ob Taste gedrückt wird, false = taste nicht gedrückt 
	}

}
