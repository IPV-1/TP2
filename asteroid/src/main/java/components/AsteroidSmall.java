package components;

import utils.Utils;

public class AsteroidSmall extends Asteroid {

	public AsteroidSmall() {
		super();
	}

	@Override
	public void onSceneActivated() {
		super.onSceneActivated();
		this.setAppearance(this.getGame().getSprite("asteroidS"));

		double minSpeed = this.getGame().getValue("asteroidMinSpeed");
		double maxSpeed = this.getGame().getValue("asteroidSMaxSpeed");
		this.setSpeed(Utils.randDouble(minSpeed, maxSpeed));
	}

}
