package model;

import model.enumeration.BetType;
import model.interfaces.Player;

public class SimplePlayer implements Player{
	
	private String playerName;
	private int initialPoints;
	private String playerId;
	private int bet;
	private BetType betType;
	
	public SimplePlayer(String playerId, String playerName, int initialPoints){
		
		this.playerId = playerId;
		this.playerName = playerName;
		this.initialPoints = initialPoints;		
		
	}
	
	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
				
	}

	@Override
	public int getPoints() {
		return initialPoints;
	}

	@Override
	public void setPoints(int initialPoints) {
		this.initialPoints = initialPoints;
		
	}

	@Override
	public String getPlayerId() {
		
		return playerId;
	}

	@Override
	public boolean setBet(int bet) {
		resetBet();
		//checks if the player has sufficient points to bet with, if he does returns true and sets the bet amount
		if (getPoints() < bet)
			return false;
		else
			
			this.bet = bet;
			return true;
	}

	@Override
	public int getBet() {
		return bet;
	}

	@Override
	public void setBetType(BetType betType) {
		this.betType = betType;
		
	}

	@Override
	public BetType getBetType() {
		return betType;
	}

	@Override
	public void resetBet() {
		this.bet = 0;
		
	}
	
	@Override
	public String toString() {
		
		return(getPlayerName());
		
		//return("Player: "+getPlayerId()+", name=" +getPlayerName()+", bet="+getBet()+", betType="+getBetType().toString()+", points="+getPoints());
	}

}
