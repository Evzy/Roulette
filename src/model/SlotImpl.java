package model;

import model.enumeration.Color;
import model.interfaces.Slot;

public class SlotImpl implements Slot{
	
	private int position = 0;
	private Color color;	
	private int number = 00;

	public SlotImpl(int position, Color color, int number) {
		
		this.position = position;
		this.color = color;
		this.number = number;
	}
		
	@Override
	public int getPosition() {
		return position;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public Color getColor() {
		return  color;
	}

	@Override
	public boolean equals(Slot slot) {
		if ( getNumber()==slot.getNumber() && getColor().equals(slot.getColor()))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		
		return("Position: " + getPosition() + ", Color: " + getColor() + " , Number: " + getNumber());		
		
	}

}
