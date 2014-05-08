package handlers.actions;

import ship.Ship;

public class ActionLeft extends Action {
	@Override
	public void execute(Ship ship, double delta) {
		ship.rotate(-1, delta);
	}
}