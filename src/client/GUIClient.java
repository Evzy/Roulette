package client;

import javax.swing.SwingUtilities;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import views.AppFrame;

public class GUIClient{

	public static void main(String[] args) {
		
		final GameEngine engine = new GameEngineImpl();

		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run()
			
			{
				
			new AppFrame(engine);
			
			}
		});
	}
}
