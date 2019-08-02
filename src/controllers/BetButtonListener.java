package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import views.AppFrame;
import views.StatusBar;

public class BetButtonListener implements ActionListener{
	
	private GameEngine engine;
	private JComboBox<Player> dropdownPlayers;
	private JTextField betInput;
	private JComboBox<String> dropdownBetType;
	private BetType selectedBetType;
	private StatusBar statusBar;
	private AppFrame frame;
	
	public BetButtonListener(JComboBox<Player> dropdownPlayers, JTextField betInput, JComboBox<String> dropdownBetType, GameEngine engine, StatusBar statusBar, AppFrame frame){
		
		this.betInput = betInput;
		this.dropdownPlayers = dropdownPlayers;
		this.engine = engine;
		this.dropdownBetType = dropdownBetType;
		this.statusBar = statusBar;
		this.frame = frame;
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (frame.getReadyState()) {
			
		
			String valueStr = betInput.getText();
			int value = Integer.parseInt(valueStr);
			SimplePlayer selectedPlayer;
			selectedPlayer = (SimplePlayer) dropdownPlayers.getSelectedItem();
			
			//THIS SHOULD GIVE ME THE PLAYER OBJECTS PUT INTO THE COMBOBOX ONCE ITS SETUP
			//THIS SHOULD USE THE INDEX OF THE COMBO BOX AND CREATE THE BETTYPE USING THAT SIMILAR INDEX AS BOTH ARE THE SAME
			 selectedBetType = BetType.values()[dropdownBetType.getSelectedIndex()];
					
			// THIS SHOULD PLACE THE BET IF WE CREATE A CORRECT PLAYER INPUT
			
			engine.placeBet(selectedPlayer, value, selectedBetType);
			statusBar.UpdateText(selectedPlayer.getPlayerName()+" placed their bet of "+selectedPlayer.getBet()+" on " + selectedBetType.name());
			frame.Update();
		
		}
		
	}

}
