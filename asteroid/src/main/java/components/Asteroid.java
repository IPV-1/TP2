package components;

import utils.Utils;

import com.uqbar.vainilla.DeltaState;

public abstract class Asteroid extends BasicAsteroidMovingGameComponent {

	public Asteroid() {
		super();
	}

	@Override
	public void onSceneActivated() {
		this.getUVector().setPI(Utils.randDouble(360));

		this.setX(Utils.randDouble(this.getGame().getDisplayWidth()
				- this.getWidth() / 2));
		this.setY(Utils.randDouble(this.getGame().getDisplayHeight()
				- this.getHeight() / 2));
	}

	@Override
	public void update(DeltaState deltaState) {
		if(this.getX() >= this.getGame().getDisplayWidth()) {
			this.setX(1 - this.getWidth());
		} else if(this.getX() + this.getWidth() <= 0) {
			this.setX(this.getGame().getDisplayWidth());
		}
		if(this.getY() >= this.getGame().getDisplayHeight()) {
			this.setY(1 - this.getHeight());
		} else if(this.getY() + this.getHeight() <= 0) {
			this.setY(this.getGame().getDisplayHeight());
		}
		super.update(deltaState);
	}

}
