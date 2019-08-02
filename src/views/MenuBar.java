package views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.MenuAddListener;
import controllers.MenuExitListener;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	
	private AppFrame frame;
	private AddPlayerDiag AddPlayerDiag;
	private GameEngine engine;
	private StatusBar statusBar;
	
	MenuBar(AppFrame frame, GameEngine engine, StatusBar statusBar){
		
		this.frame = frame;
		this.engine = engine;
		this.statusBar = statusBar;
		
		AddPlayerDiag AddPlayerDiag = new AddPlayerDiag(frame, "Add Player", engine,statusBar);
		AddPlayerDiag.setLocationRelativeTo(this);
		
		JMenu optionsMenu = new JMenu("Option Menu");
		
		JMenuItem item1 = new JMenuItem("Add Player");
		item1.addActionListener(new MenuAddListener(AddPlayerDiag,frame));
		JMenuItem item3 = new JMenuItem("Exit");
		item3.addActionListener(new MenuExitListener(frame));
		
		add(optionsMenu);
		
		optionsMenu.add(item1);
		optionsMenu.add(item3);
			
	}
}
