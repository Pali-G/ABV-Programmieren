import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {		//public void run wird gestartet durch thread = new Thread(this); thread.start();
	
	//Attribute
	private int width, height;
	public String title;
	private boolean running = false;
	private Thread thread;
	public String pathPlayer;							//Speicherung des Imagepfades für den Player
	
	//States
	public State gameState;
	public State menuState;
	public State settingsState;
	public State skinState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Output
	private Display display;
	private BufferStrategy bs;
	private Graphics g;
	
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
		display.getFrame().addMouseListener(mouseManager);				//um glitches zu vermeiden, wird der MouseManager sowohl zum JFrame, als
		display.getFrame().addMouseMotionListener(mouseManager);		//auch zur Canvas hinzugefügt
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		pathPlayer = "/textures/Player1.png";
		
		menuState = new MenuState(handler);				//die anderen States werden initialisiert durch späteres anklicken 
		State.setState(menuState);
	}
	
	public void setPath(String path) {
		this.pathPlayer = path;
	}
	
	public void initMenuState() {									//die initState() methoden werden immer kurz bevor 
		menuState = new MenuState(handler);							//ein State gewechselt wird gecallt, um den UIManager
	}																//vollständig zu resetten
	
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
		if(gameState != null || menuState != null || settingsState != null || skinState != null) {	//schutz vor crash
			State.getState().update();						//der currentState wird aktualisiert
		}
		
	}
	
	private void render () {
		bs = display.getCanvas().getBufferStrategy();    			//BufferStrategy wird bs zugeordnet
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();									//Graphikobjekt wird bs zugeordnet
		//canvas putzen
		g.clearRect(0, 0, width, height);							//ein leeres Rechteck der Größe des Frames wird gemalt => putzen
		
		if(gameState != null || menuState != null || settingsState != null || skinState != null) {
			State.getState().render(g);								//der current State wird gerendert 
		}
		//malen fertig
		bs.show();													
		g.dispose();												//graphicobject wird geleert
	}
	public void run() {												//startet durch thread.start(); in public void start()
		init();
		
		int fps = 60;												//wie oft pro Sekunde werden update und render gecallt
		double timePerUpdate = 1000000000 / fps;					//Zeit pro update in Nanosekunden
		double delta = 0;											
		long now;
		long lastTime = System.nanoTime();							//
		
		long timer = 0;
		int updates = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerUpdate; //Wie viel Zeit bis zum nächsten Update
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1) { 				//wenn die verstrichene Zeit gleich der timePerUpdate ist 
				update();					//wird update()
				render();					//und render() gecallt und die  
				delta--;					
				updates++;
			}
			if(timer >= 1000000000) {		//jede Sekunde werden die fps ausgegeben, um rechenleistung zu prüfen(wenn <60 dan  ist was falsch)
				System.out.println(updates + "fps");
				updates = 0;				//reset der Zähler
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
	
	public synchronized void start() {				//startet die run() method
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {				//beendet die run() method
		if(!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

