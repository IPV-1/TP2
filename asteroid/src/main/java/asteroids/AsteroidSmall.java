package asteroids;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidSmall extends Asteroid {

	@Override
	protected Sprite getSprite() {
		return this.getGame().getSprite("asteroidS");
	}

	@Override
	protected double getMaxSpeed() {
		return this.getGame().getValue("asteroidSMaxSpeed");
	}

}
