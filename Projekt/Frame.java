import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

/* TODO:
 * 1. Locations der buttons
 * 2. komplette Klasse & Konstruktor frame to Startframe oder Menuframe umbenennen (wegen der uebersicht)
 * 3. Designs hinzufügen
 * 4. Setting actionlistener verlinken + Konstruktor erstellen (optional)
 * 5. End action listener hinzufügen
 * 6. Info actionlistener erstellen + Konstruktor hinzufügen
 * */

public class Frame extends JFrame implements ActionListener {

	private static JButton start;
	private static JButton settings;
	private static JButton info;
	private static JButton end;

	public static void main(String[] args) {

		Frame frame = new Frame();
		
	}

	public Frame() {
		// Basic Layout
		this.getContentPane().setLayout(new FlowLayout());
		setBackground(Color.cyan);
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		start = new JButton("Start");
		start.setPreferredSize(new Dimension(150, 75));
		start.setLocation(150, 150); //Funktioniert (bei mir) nicht wie es sollte
		start.addActionListener(this);
		this.getContentPane().add(start); //macht bisjetzt nichts
		add(start);

		settings = new JButton("Settings");
		start.setPreferredSize(new Dimension(75, 75));
		start.setLocation(500,500);//Funktioniert bei mir nicht
		add(settings);

		info = new JButton("Info");
		start.setPreferredSize(new Dimension(75, 75));
		start.setLocation(0,500);//Funktioniert bei mir nicht
		add(info);

		end = new JButton("End Game");
		start.setPreferredSize(new Dimension(100, 50));
		start.setLocation(500, 0);//Funktioniert bei mir nicht
		add(end);

		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			dispose(); //schliesst Fenster
			startGame();
		}
	
	}
	public static void startGame() {
		GamePanel panel = new GamePanel();
		
		JFrame gameFrame = new JFrame();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		gameFrame.add(new GamePanel());
		gameFrame.setSize(screensize);
		gameFrame.getContentPane().add(panel);
		gameFrame.pack();
		gameFrame.setLocationByPlatform(true);
		gameFrame.setVisible(true);
	}

}
