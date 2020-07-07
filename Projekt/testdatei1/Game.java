import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
	private Testklasse display;
	private int width, height;
	public String title;
	private BufferStrategy bs;
	private Graphics g;
	private boolean running = false;
	private Thread thread;
	
	//States
	private State gameState;
	private State menuState;
	private State settingsState;
	
	//Input
	private KeyManager keyManager;
	
	//CAMERA
	private GameCamera gameCamera;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}

	private void init() {
		display = new Testklasse(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		
		gameCamera = new GameCamera(this, 0, 0);
	//	testImage = ImageLoader.loadImage("/textures/testImage.png");
		gameState = new GameState(this);
		menuState = new MenuState(this);
		settingsState = new SettingsState(this);
		
		State.setState(gameState);
	}

	private void update () {
		KeyManager.update();
		if(gameState != null) {
			State.getState().update();
		}
		
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
		
		if(gameState != null) {
			State.getState().render(g);
		}
		//malen
		/*g.setColor(Color.blue);
		g.fillRect(x, y, 23, 23);
		g.setColor(Color.green);
		g.fillRect(x+4, y+4, 15, 15);*/
	//	g.drawImage(testImage, 10, 10, null);
		
		
		//malen fertig
		bs.show();
		g.dispose();
	}
	public void run() {
		init();
		
		int fps = 60;
		double timePerUpdate = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int updates = 0;
		
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate; //Wie viel Zeit bis zum nächsten Update
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1) { 				//wenn die verstrichene Zeit gleich der timePerUpdate ist 
				update();
				render();
				delta--;
				updates++;
			}
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: "+updates);
				updates = 0;
				timer = 0;
			}
		}
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public GameCamera getGameCamera() {
		return this.gameCamera;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
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
