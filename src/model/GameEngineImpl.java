package model;

import java.util.ArrayList;
import java.util.Collection;

import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {

	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Slot> slots = new ArrayList<Slot>();
	private ArrayList<GameEngineCallback> calls = new ArrayList<GameEngineCallback>();
	
	
	public GameEngineImpl(){
		
		slots.add(new SlotImpl(0, Color.GREEN00, 00));
		slots.add(new SlotImpl(1, Color.RED, 27));
		slots.add(new SlotImpl(2, Color.BLACK, 10));
		slots.add(new SlotImpl(3, Color.RED, 25));
		slots.add(new SlotImpl(4, Color.BLACK, 29));
		slots.add(new SlotImpl(5, Color.RED, 12));
		slots.add(new SlotImpl(6, Color.BLACK, 8));
		slots.add(new SlotImpl(7, Color.RED, 19));
		slots.add(new SlotImpl(8, Color.BLACK, 31));
		slots.add(new SlotImpl(9, Color.RED, 18));
		slots.add(new SlotImpl(10, Color.BLACK, 6));
		slots.add(new SlotImpl(11, Color.RED, 21));
		slots.add(new SlotImpl(12, Color.BLACK, 33));
		slots.add(new SlotImpl(13, Color.RED, 16));
		slots.add(new SlotImpl(14, Color.BLACK, 4));
		slots.add(new SlotImpl(15, Color.RED, 23));
		slots.add(new SlotImpl(16, Color.BLACK, 35));
		slots.add(new SlotImpl(17, Color.RED, 14));
		slots.add(new SlotImpl(18, Color.BLACK, 2));
		slots.add(new SlotImpl(19, Color.GREEN0, 0));
		slots.add(new SlotImpl(20, Color.BLACK, 28));
		slots.add(new SlotImpl(21, Color.RED, 9));
		slots.add(new SlotImpl(22, Color.BLACK, 26));
		slots.add(new SlotImpl(23, Color.RED, 30));
		slots.add(new SlotImpl(24, Color.BLACK, 11));
		slots.add(new SlotImpl(25, Color.RED, 7));
		slots.add(new SlotImpl(26, Color.BLACK, 20));
		slots.add(new SlotImpl(27, Color.RED, 32));
		slots.add(new SlotImpl(28, Color.BLACK, 17));
		slots.add(new SlotImpl(29, Color.RED, 5));
		slots.add(new SlotImpl(30, Color.BLACK, 22));
		slots.add(new SlotImpl(31, Color.RED, 34));
		slots.add(new SlotImpl(32, Color.BLACK, 15));
		slots.add(new SlotImpl(33, Color.RED, 3));
		slots.add(new SlotImpl(34, Color.BLACK, 24));
		slots.add(new SlotImpl(35, Color.RED, 36));
		slots.add(new SlotImpl(36, Color.BLACK, 13));
		slots.add(new SlotImpl(37, Color.RED, 1));
		
	}

	public void spin(int initialDelay, int finalDelay, int delayIncrement) {

		int position = (int) (Math.random() * 37);
		int delay = initialDelay;
		Slot currentSlot = null;

		while (delay <= finalDelay) {
			// grab a slot according to position, toString this slot
			
			

			currentSlot = slots.get(position);
			// System.out.println(currentSlot.toString());
			for (GameEngineCallback called : calls) {

				called.nextSlot(currentSlot, this);

			}

			// increment delay. using addition from the initial delay, by the delayincrement
			// until reaching final delay
			delay += delayIncrement;

			if (position == 37) { // this function after running above, checks what the position value is
				position = 0; // if it is = 37. it sets it back to 0, otherwise it goes up by 1.
			} else {
				position++;
			}
			
			
			try {
				Thread.sleep(delay );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// below is the winning slot, ready for whatever i need. probably passing on to
			// the callback
		}

		currentSlot = slots.get(position);
		Slot winningSlot = currentSlot;

		// this sends the winning slot to calculateResult() below which calls the final
		// result methods.
		calculateResult(winningSlot);
	}

	@Override
	public void calculateResult(Slot winningSlot) {
		
		/*this method runs 3 loops, the first one applies the win loss to each player in players,
		 * the second one runs the callbacks within calls
		 * the third resets the bets for all players afterwards.*/

		for (Player finishingPlayer : players) {
			
			if(finishingPlayer.getBetType() != null) {

			finishingPlayer.getBetType().applyWinLoss(finishingPlayer, winningSlot);
			
			}
			
		}

		for (GameEngineCallback called : calls) {

			called.result(winningSlot, this);

		}
		
		for (Player finishingPlayer : players) {
			
			finishingPlayer.resetBet();
		}

	}

	public void addPlayer(Player player) {

		players.add(player);

	}

	@Override
	public Player getPlayer(String id) {

		// for loop cycles through Player objects in players, if it finds one with same
		// String Id as the one parsed through as the argument, it will return it, if not
		// it will return with null

		for (Player p : players) {
			if (p.getPlayerId().equals(id)) {

				return p;
			}
		}
		return null;

	}

	@Override
	public boolean removePlayer(Player player) {

		// for loop cycles through Player objects in players, if it finds the same
		// object as the one parsed through as the argument, it will remove it and
		// return as true
		for (Player p : players) {

			if (players.contains(player)) {

				players.remove(p);
				return true;
			}
		}
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		calls.add(gameEngineCallback);

	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// refer to removePlayer
		for (GameEngineCallback c : calls) {

			if (calls.contains(c)) {

				calls.remove(c);
			}

		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		
		return players;
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {

		if (player.setBet(bet)) {

			player.setBetType(betType);
			return true;

		} else {
			return false;
		}
	}

	@Override
	public Collection<Slot> getWheelSlots() {
		
		
		return slots;
	}

}
