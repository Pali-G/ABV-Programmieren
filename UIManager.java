import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
// UIManager verwaltet UIObjekte 
public class UIManager {
	
	private Handler handler;
	private ArrayList<UIObject> objects;  //Arraylist mit Objekten des aktuellen States wird durchgegangen und die Methoden werden durchgegangen
	
	public UIManager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<UIObject>();
	}
	
	public void update() {
		for (UIObject o : objects) {
			o.update();	
		}
	}
	
	public void render(Graphics g) {
		for (UIObject o : objects) {
			o.render(g);
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		for (UIObject o : objects) {
			o.onMouseMove(e);
		}
	}
	
	public void onMouseReleased(MouseEvent e) {
		for (UIObject o : objects) {
			o.onMouseReleased(e);
		}
	}
	
	public void addObject(UIObject o) {
		objects.add(o);
	}
	public void removeObject(UIObject o) {
		objects.remove(o);
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

	
}
