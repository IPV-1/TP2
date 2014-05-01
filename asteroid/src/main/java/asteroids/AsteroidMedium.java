package asteroids;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidMedium extends Asteroid {

	@Override
	protected Sprite getSprite() {
		return this.getGame().getSprite("asteroidM");
	}

	@Override
	protected double getMaxSpeed() {
		return this.getGame().getValue("asteroidMMaxSpeed");
	}

}
