package handlers.actions;

import ship.Ship;
import ship.ShipSpeedUp;
import ship.ShipWaiting;

public class ActionUp extends Action {
	@Override
	public void execute(Ship ship, double delta) {
		ship.speedUp(delta);
	}
	
	@Override
	public void setSelected(Ship ship, boolean selected) {
		super.setSelected(ship, selected);
		
		if(selected) {
			ship.setState(new ShipSpeedUp());
		} else {
			ship.setState(new ShipWaiting());
		}
	}
}