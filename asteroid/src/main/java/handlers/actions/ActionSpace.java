package handlers.actions;

import ship.Ship;

public class ActionSpace extends Action {
	@Override
	public void execute(Ship ship, double delta) {
		ship.shot();
	}
}