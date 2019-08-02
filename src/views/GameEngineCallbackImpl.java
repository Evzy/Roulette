package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java
 * logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback {
	private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

	public GameEngineCallbackImpl() {
		// FINE shows wheel spinning output, INFO only shows result
		logger.setLevel(Level.FINE);
		// This changes the handlers default logging level to meet level fine for logging.
		Logger.getGlobal().getParent().getHandlers()[0].setLevel(Level.FINE);

	}

	@Override
	public void nextSlot(Slot slot, GameEngine engine) {
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, slot.toString());
	}

	@Override
	public void result(Slot winningSlot, GameEngine engine) {
		logger.log(Level.INFO, "Result = " + winningSlot.toString() + "\n");
		logger.log(Level.INFO, "FINAL PLAYER POINT BALANCES");
		logger.log(Level.INFO, "PUT THE RESULTS HERE! CURRENTLY THIS IS A TO STRING METHOD FROM SIMPLE TEST");
		
		// TODO:ALTHOUGH THERES AN CURRENTLY WITH THE BETTING, ITS BECAUSE THE LOGGER ISNT
		// THE PLAYERS TO THE CONSOLE, A LOOP TO STRING IS AFTER THE BETS ARE RESET, IF I PUT THEM IN THE LOGGER, THEN IT WILL WORK CORRECTLY.
	}
}
