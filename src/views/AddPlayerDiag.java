package views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.AddPlayerActionListener;
import controllers.CloseAddPlayerListener;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class AddPlayerDiag extends JDialog{
	
	private GameEngine engine;
	private StatusBar statusBar;
	
	AddPlayerDiag(AppFrame frame, String title, GameEngine engine,StatusBar statusBar){
		
		super(frame, title, false);
		this.engine = engine;
		this.statusBar = statusBar;
		setVisible(false);
		setResizable(false);
		setSize(250,100);
		GridLayout layout = new GridLayout(3,2);
		setLayout(layout);
		
		
		JLabel playerLabel = new JLabel("  Player Name:");
		JTextField playerInput = new JTextField();
		JLabel pointsLabel = new JLabel("  Player Points:");
		JTextField pointsInput = new JTextField();
		JButton addPlayer = new JButton("Add Player");
		JButton close = new JButton("Close");
		
		add(playerLabel);
		add(playerInput);
		add(pointsLabel);
		add(pointsInput);
		add(addPlayer);
		add(close);
		
		close.addActionListener(new CloseAddPlayerListener(this));
		addPlayer.addActionListener(new AddPlayerActionListener(engine,playerInput,pointsInput,frame,statusBar));
	}

}
