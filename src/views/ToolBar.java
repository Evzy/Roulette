package views;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controllers.BetButtonListener;
import controllers.RemovePlayerActionListener;
import controllers.SpinButtonListener;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar {
	
	private GameEngine engine;
	private ArrayList<Player> players;
	private AppFrame frame;
	
	private JLabel tempLabel = new JLabel("   Select Player:   ");
	private JLabel betLabel = new JLabel("   Bet Amount:   ");
	private JTextField betInput = new JTextField();
	private JButton betButton = new JButton("Place Bet");
	private JButton removePlayer = new JButton("Remove Player");
	private JButton spinButton = new JButton("Spin Wheel");
	private StatusBar statusBar;	
	
	String[] betTypeArray = {"RED","BLACK","ZEROS"};
	
	JComboBox<String> dropdownBetType = new JComboBox<String>(betTypeArray);
	
	ToolBar(GameEngine engine, ArrayList<Player> players, StatusBar statusBar, AppFrame frame){
		
		this.players = players;
		this.engine = engine;
		this.statusBar = statusBar;
		this.frame = frame;
		
				
		Player[] playerArray = players.toArray(new Player[players.size()]);
		
		JComboBox<Player> dropdownPlayers = new JComboBox<Player>(playerArray);
 	
		setFloatable(false);
		add(tempLabel);
		add(dropdownPlayers);
		add(removePlayer);
		removePlayer.addActionListener(new RemovePlayerActionListener(engine,dropdownPlayers,frame,statusBar));
		add(betLabel);
		add(betInput);
		add(dropdownBetType);
		add(betButton);
		betButton.addActionListener(new BetButtonListener(dropdownPlayers,betInput,dropdownBetType,engine,statusBar,frame));
		add(spinButton);
		spinButton.addActionListener(new SpinButtonListener(engine,frame,statusBar));
	}	
}
