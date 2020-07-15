import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener{  // mouselistener = taste gedrückt, mousemotionlistener = zeiger bewegt 

	private UIManager uiManager;
	
	public MouseManager() {
		
	}
	
	public void setUIManager(UIManager uiManager) {  //initialisierung des UIManagers
		this.uiManager = uiManager;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {		//wenn mouse released wird, dann soll der UIManager die zugehörige Methode ausführen
		if (uiManager != null) {
			uiManager.onMouseReleased(e); 
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {			//wenn mouse bewegt wird, dann soll der UIManager die zugehörige Methode ausführen
		if (uiManager != null) {
			uiManager.onMouseMove(e); 
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {		//Implementierungen der Methoden der Überklassen
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}