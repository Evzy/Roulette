package model.enumeration;

import model.interfaces.Player;
import model.interfaces.Slot;

/**
 * Provided enum type for Further Programming representing a type of Bet<br>
 * See inline comments for where you need to provide additional code
 * 
 * @author Caspar Ryan
 * 
 */
public enum BetType {
	RED {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {
			
			player.setPoints(player.getPoints() - player.getBet());

			if (winSlot.getColor().equals(Color.RED)) {

				int returnings = player.getBet() * 2;

				player.setPoints(player.getPoints() + returnings);

			}

		}
	},

	BLACK {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {
			
			player.setPoints(player.getPoints() - player.getBet());

			if (winSlot.getColor().equals(Color.BLACK)) {

				int returnings = player.getBet() * 2;

				player.setPoints(player.getPoints() + returnings);

			}

		}
	},

	ZEROS {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {
			
			player.setPoints(player.getPoints() - player.getBet());

			if (winSlot.getColor().equals(Color.GREEN0) || winSlot.getColor().equals(Color.GREEN00)) {

				int returnings = player.getBet() * (Slot.WHEEL_SIZE / 2) - 1;

				player.setPoints(player.getPoints() + returnings);

			}
		}
	};

	/**
	 * This method is to be overridden for each bet type<br>
	 * see assignment specification for betting odds and how win/loss is applied
	 * 
	 * @param player  - the player to apply the win/loss points balance adjustment
	 * @param winSlot - the winning slot the ball landed on
	 */
	public abstract void applyWinLoss(Player player, Slot winSlot);
}