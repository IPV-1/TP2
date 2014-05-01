package asteroids;

import utils.Utils;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Sprite;

import components.BasicAsteroidMovingGameComponent;

public abstract class Asteroid extends BasicAsteroidMovingGameComponent {

	protected abstract Sprite getSprite();

	protected abstract double getMaxSpeed();

	@Override
	public void onSceneActivated() {
		this.getUVector().setPI(Utils.randDouble(360));
		this.setAppearance(this.getSprite());
		this.setSpeed(Utils.randDouble(
				this.getGame().getValue("asteroidMinSpeed"), this.getMaxSpeed()));

		this.setX(Utils.randDouble(this.getGame().getDisplayWidth()
				- this.getWidth() / 2));
		this.setY(Utils.randDouble(this.getGame().getDisplayHeight()
				- this.getHeight() / 2));
	}

	@Override
	public void update(DeltaState deltaState) {
		if (this.getX() >= this.getGame().getDisplayWidth()) {
			this.setX(1 - this.getWidth());
		} else if (this.getX() + this.getWidth() <= 0) {
			this.setX(this.getGame().getDisplayWidth());
		}
		if (this.getY() >= this.getGame().getDisplayHeight()) {
			this.setY(1 - this.getHeight());
		} else if (this.getY() + this.getHeight() <= 0) {
			this.setY(this.getGame().getDisplayHeight());
		}
		super.update(deltaState);
	}

}
