import java.awt.Dimension;
import java.awt.Toolkit;

public class Runner {
	static Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	static int r_width = 100;
	static int r_height = r_width;
	static int posX = r_height;
	static int posY = screensize.height - 2*r_height;
	
	public Runner() {
	}
	
	public void jump() {
		for (int i = posX; i < (3*r_height + posX); i = i+5) {
			posX = i;
		}
		for (int i = posX; i < (3*r_height + posX); i = i-10) {
			posX = i;
		}
	}
}
