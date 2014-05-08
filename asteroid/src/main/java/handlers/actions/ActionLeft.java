package handlers.actions;

import ship.Ship;

public class ActionLeft extends Action {
	@Override
	public void execute(Ship ship) {
		ship.rotate(-1);
	}
}