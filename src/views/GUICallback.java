package views;

import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;
import views.StatusBar;

public class GUICallback implements GameEngineCallback {
	
	private StatusBar statusBar;
	private int currentSlotPosition = 0;	

	public GUICallback(StatusBar statusBar) {
		this.statusBar = statusBar;
	}

	@Override
	public void nextSlot(Slot slot, GameEngine engine) {
		
		currentSlotPosition = slot.getPosition();

	}

	@Override	
	public void result(Slot winningSlot, GameEngine engine) {
		
		statusBar.UpdateText("Spin Complete! The Winning Slot is: " + winningSlot.getColor() + " "+ Integer.toString(winningSlot.getNumber()));
				
		
	}
	
	public int getCurrentSlotPosition(){
		
		return currentSlotPosition;		
		
	}
	
}
