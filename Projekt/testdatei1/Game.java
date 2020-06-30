import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
	private Testklasse display;
	public int width, height;
	public String title;
	private BufferStrategy bs;
	private Graphics g;
	private boolean running = false;
	private Thread thread;
	
	//private BufferedImage testImage;
	int x = 0;
	int y = 0;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	private void init() {
		display = new Testklasse(title, width, height);
	//	testImage = ImageLoader.loadImage("/textures/testImage.png");
	}

	private void update () {
		x++;
	}
	
	private void render () {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//canvas putzen
		g.clearRect(0, 0, width, height);
		//malen
		g.setColor(Color.blue);
		g.fillRect(x, y, 23, 23);
		g.setColor(Color.green);
		g.fillRect(x+4, y+4, 15, 15);
	//	g.drawImage(testImage, 10, 10, null);
		
		
		//malen fertig
		bs.show();
		g.dispose();
	}
	public void run() {
		init();
		while(running) {
			update();
			render();
		}
	}

	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if(!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
