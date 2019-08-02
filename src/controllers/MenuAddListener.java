package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.AddPlayerDiag;
import views.AppFrame;

public class MenuAddListener implements ActionListener{
	
	private AddPlayerDiag addDiag;
	private AppFrame frame;
	
	public MenuAddListener(AddPlayerDiag addDiagPassed, AppFrame frame){
		
		this.addDiag = addDiagPassed;
		this.frame = frame;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		addDiag.setLocationRelativeTo(frame);
		addDiag.setVisible(true);
	}
}
