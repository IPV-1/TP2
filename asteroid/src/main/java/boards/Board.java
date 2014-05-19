package boards;

import java.awt.Color;
import java.awt.Font;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Label;
import components.BasicAsteroidComponent;

public abstract class Board extends BasicAsteroidComponent {
	
	private int value;
	private boolean changed = false;
	
	public Board(double x, double y, Color color) {
		super(new Label(new Font("verdana",  Font.BOLD, 34), color, "0"), x, y);
		this.setZ(100);
	}
	
	public void add(int value) {
		this.setValue(this.getValue() + value);
	}

	public void reset() {
		this.setValue(0);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		if(this.isChanged()) {
			this.getAppearance().setText(this.getLabel());
			this.setChanged(false);
		}
		super.update(deltaState);
	}
	
    protected String getLabel() {
		return String.valueOf(this.getValue());
	}

	@Override
    public Label getAppearance(){
        return (Label) super.getAppearance();
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.setChanged(true);
		this.value = value;
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
}
