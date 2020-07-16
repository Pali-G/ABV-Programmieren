import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {							//Verwaltet UIObjects
	
	private Handler handler;
	private ArrayList<UIObject> objects;			//hat eine ArrayList aus UIObjects
	
	public UIManager(Handler handler) {
		this.handler = handler;
		objects = new ArrayList<UIObject>();
	}
	
	public void update() {
		for (UIObject o : objects) {				//for Schleife geht alle Objekte in der Liste durch
			o.update();								//für jedes Objekt wird update() ausgeführt
		}
	}
	
	public void render(Graphics g) {				
		for (UIObject o : objects) {				//for Schleife geht alle Objekte in der Liste durch
			o.render(g);							//für jedes Objekt wird render() ausgeführt
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		for (UIObject o : objects) {				//for Schleife geht alle Objekte in der Liste durch
			o.onMouseMove(e);						//für jedes Objekt wird onMouseMove() ausgeführt
		}
	}
		
	public void onMouseReleased(MouseEvent e) {
		for (UIObject o : objects) {				//for Schleife geht alle Objekte in der Liste durch
			o.onMouseReleased(e);					//für jedes Objekt wird onMouseReleased() ausgeführt
		}
	}
	
	public void addObject(UIObject o) {				//hinzufügen eines UIObjektes zur ArrayList
		objects.add(o);
	}
	public void removeObject(UIObject o) {			//löschen eines UIObjektes aus der ArrayList
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
