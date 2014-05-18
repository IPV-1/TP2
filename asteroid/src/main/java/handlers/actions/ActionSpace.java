package handlers.actions;

import ship.Ship;

public class ActionSpace extends Action {

	@Override
	public void setSelected(Ship ship, boolean selected) {
		if(!selected) {
			ship.shot();
		}
	}

	@Override
	public void execute(Ship ship, double delta) {}
	
}