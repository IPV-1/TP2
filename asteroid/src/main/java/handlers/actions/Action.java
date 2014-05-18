package handlers.actions;

import ship.Ship;

public abstract class Action {
	
	private boolean selected = false;
	
	public abstract void execute(Ship ship, double delta);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(Ship ship, boolean selected) {
		this.selected = selected;
	}
}
