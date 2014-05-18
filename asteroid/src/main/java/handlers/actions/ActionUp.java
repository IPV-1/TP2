package handlers.actions;

import ship.Ship;

public class ActionUp extends Action {
	@Override
	public void execute(Ship ship, double delta) {
		ship.speedUp(delta);
	}
}