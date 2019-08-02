package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.AddPlayerDiag;

public class CloseAddPlayerListener implements ActionListener {
	
	private AddPlayerDiag diag;
	
	public CloseAddPlayerListener(AddPlayerDiag diag){
		
		this.diag = diag;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		diag.setVisible(false);
		
	}

}
