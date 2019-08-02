package views;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.*;

import model.interfaces.Player;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {
	
	private ArrayList<Player> players;
	private JList playerJList;
	
	SummaryPanel(ArrayList<Player> players){
		
		this.players = players;
		playerJList = new JList(players.toArray());
		
		CellRenderer cellRenderer = new CellRenderer();
		playerJList.setCellRenderer(cellRenderer);
			
		setBorder(new TitledBorder("Player Summary"));
		
		add(playerJList);
		
	}	
	
}
