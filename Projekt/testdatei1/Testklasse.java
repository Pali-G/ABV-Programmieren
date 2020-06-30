import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Testklasse {
	private JFrame Frame;
	private Canvas canvas;
	private String title;
	private int width, height;
	
	public Testklasse (String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		createDisplay();
	}
	
	public void createDisplay() {
		Frame = new JFrame(title);
		Frame.setSize(width, height);
		Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		Frame.setResizable(true);
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		Frame.add(canvas);
		Frame.pack();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
}