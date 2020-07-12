import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
	private Display display;
	private int width, height;
	public String title;
	private BufferStrategy bs;
	private Graphics g;
	private boolean running = false;
	private Thread thread;
	
	//States
	public State gameState;
	public State menuState;
	public State settingsState;
	public State skinState;
	
	public String path;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//CAMERA
	private GameCamera gameCamera;
	
	//HANDLER
	private Handler handler;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		gameCamera = new GameCamera(this, 0, 0);
		
		handler = new Handler(this);
		
		path = "/textures/Player1.png";
		
		settingsState = new SettingsState(handler);
		gameState = new GameState(handler);
		skinState = new SkinState(handler);
		
		menuState = new MenuState(handler);
		State.setState(menuState);
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void initMenuState() {
		menuState = new MenuState(handler);
	}
	
	public void initSettingsState() {
		settingsState = new SettingsState(handler);
	}
	
	public void initGameState() {
		gameState = new GameState(handler);
	}
	
	public void initSkinState() {
		skinState = new SkinState(handler); 
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
				System.out.println("Ticks and Frames: "+ updates);
				updates = 0;
				timer = 0;
			}
		}
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
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

