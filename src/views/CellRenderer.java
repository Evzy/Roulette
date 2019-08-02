package views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;

import model.enumeration.BetType;
import model.interfaces.Player;

class CellRenderer extends JTextArea implements ListCellRenderer {
	  private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	  public CellRenderer() {
		  
		  
	  }

	  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		  
		String bet;
	    Player player = (Player) value;
	    if (player.getBetType() == BetType.BLACK) {
	    	
	    	bet = "black";
	    	
	    }
	    
	    else if (player.getBetType() == BetType.RED) {
	    	
	    	bet = "red";
	    	
	    }
	    
	    else {
	    	
	    	bet = "zero";
	    	
	    }
	    
	    //THIS SETS UP WHAT COMES UP IN MY SUMMARY PANEL, ANOTHER WAY TO FORMAT AVOIDING toString method
	    
		setText("\n Player: " + player.getPlayerName() + "\n Points: "+player.getPoints()+ "\n Bet Amount: " + player.getBet()+"\n Bet Type: "+ bet +"\n");
	    //setIcon(player.getImage());
	    return this;
	  }
}
