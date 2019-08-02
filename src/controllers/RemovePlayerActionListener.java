package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import views.AppFrame;
import views.StatusBar;

public class RemovePlayerActionListener implements ActionListener{
	
	private GameEngine engine;
	private JComboBox<Player> dropdownPlayers;
	private AppFrame frame;
	private StatusBar statusBar;
	
	public RemovePlayerActionListener(GameEngine engine, JComboBox<Player> dropdownPlayers, AppFrame frame, StatusBar statusBar){
		
		this.engine = engine;
		this.dropdownPlayers = dropdownPlayers;
		this.frame = frame;
		this.statusBar = statusBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (frame.getReadyState()) {
		
			
			Player removingPlayer = (Player)dropdownPlayers.getSelectedItem();
			statusBar.UpdateText("Removed Player: "+ removingPlayer.getPlayerName());
			engine.removePlayer(removingPlayer);
			frame.Update();
			
		}
		
	}

}