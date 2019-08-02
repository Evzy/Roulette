package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import views.AppFrame;
import views.StatusBar;

public class SpinButtonListener implements ActionListener{
	
	private GameEngine engine;
	private AppFrame frame;
	private StatusBar statusBar;
	
	public SpinButtonListener(GameEngine engine, AppFrame frame, StatusBar statusBar){

		this.engine = engine;
		this.frame = frame;
		this.statusBar = statusBar;
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (frame.getReadyState()==true) {
		
			new Thread()
			{
			@Override
			public void run()
			{
				frame.setReadyState(false);
				statusBar.UpdateText("SPINNING.....");
				engine.spin(1,500,25);				
				frame.Update();
				frame.setReadyState(true);
			}
			}.start();
			
		}
		
		
	}
}
