package handlers.actions;

import ship.Ship;

public class ActionRight extends Action {
	@Override
	public void execute(Ship ship) {
		ship.rotate(1);
	}
}