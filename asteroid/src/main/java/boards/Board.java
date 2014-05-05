package boards;

import java.awt.Color;
import java.awt.Font;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Label;

import components.BasicAsteroidComponent;

public class Board extends BasicAsteroidComponent {

	protected int value;
	protected boolean changed = false;

	public Board(double x, double y, Color color) {
		super(new Label(new Font("verdana", Font.BOLD, 34), color, "0"), x, y);
	}

	public void updateText() {
		if(this.isChanged()) {
			this.getAppearance().setText(Integer.toString(this.getValue()));
		}
		this.setChanged(false);
	}

	public void add(int value) {
		this.setValue(this.getValue() + value);
	}

	public void reset() {
		this.setValue(0);
	}

	@Override
	public void update(DeltaState deltaState) {
		this.updateText();
		super.update(deltaState);
	}

	@Override
	public Label getAppearance() {
		return (Label) super.getAppearance();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.setChanged(true);
		this.value = value;
	}

	protected boolean isChanged() {
		return changed;
	}

	protected void setChanged(boolean changed) {
		this.changed = changed;
	}

}
