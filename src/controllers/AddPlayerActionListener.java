package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import views.AppFrame;
import views.StatusBar;

public class AddPlayerActionListener implements ActionListener{
	
	private GameEngine engine;
	private JTextField name;
	private JTextField points;
	private AppFrame frame;
	private StatusBar statusBar;
	private int PlayerId;
	
	public AddPlayerActionListener(GameEngine engine, JTextField name, JTextField points, AppFrame frame, StatusBar statusBar){
		
		this.engine = engine;
		this.name = name;
		this.points = points;
		this.frame = frame;
		this.statusBar = statusBar;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (frame.getReadyState()) {
		
		String pointsStr = points.getText();
		int pointsInt = Integer.parseInt(pointsStr);	
		///THIS GIVES THE FIRST ADDED PLAYER PLAYER ID #0 then adds on from there.
		PlayerId = 0;
		
		SimplePlayer player = new SimplePlayer(Integer.toString(PlayerId), name.getText(), pointsInt);
		engine.addPlayer(player);
		PlayerId++;
		frame.Update();
		statusBar.UpdateText("Added New Player: "+ player.getPlayerName());
		
		}
		
	}

}
