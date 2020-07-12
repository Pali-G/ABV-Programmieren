import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/* TODO
 * Main METHOD Auslagern
 * Buttons erstellen
 * - Spiel Starten
 *    Wenn mit Button das spiel gestartet einfach GameGUI kostruktor starten und vorher mit dispose() altes jframe schließen
 * - evtl. Info
 * - evtl einstellungen (so basis sachen wie hintergrundbild wechseln)
 * - evtl. Spiel schließen
 */

public class MenuGUI extends JFrame implements ActionListener {

		private static JButton start;
		private static JButton settings;
		private static JButton info;
		private static JButton end;

		public MenuGUI() {
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

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == start) {
				dispose(); //schliesst Fenster
				startGame();
			}
			
		}
		
		public void startGame() {
			GameGUI gamegui = new GameGUI("Jump And Run");
		}
}
