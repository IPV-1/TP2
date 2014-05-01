package asteroids;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidLarge extends Asteroid {

	@Override
	protected Sprite getSprite() {
		return this.getGame().getSprite("asteroidL");
	}

	@Override
	protected double getMaxSpeed() {
		return this.getGame().getValue("asteroidLMaxSpeed");
	}

}
