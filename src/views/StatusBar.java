package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StatusBar extends JPanel {
	
	private JLabel Label = new JLabel("statusBar", JLabel.CENTER);
	
	StatusBar(String string){

				setLayout(new GridLayout(1, 3));

				Label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

				add(Label);
				UpdateText(string);
	}
	
	public void UpdateText(String text){
		
		Label.setText(text);
	}

}
