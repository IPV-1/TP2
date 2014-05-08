package asteroids;

import com.uqbar.vainilla.appearances.Sprite;
import components.PoolManager;
import config.Configuration;

public class AsteroidLarge extends Asteroid {

	@Override
	protected Sprite getSprite() {
		return Configuration.getSprite("asteroidL");
	}

	@Override
	protected double getMaxSpeed() {
		return Configuration.getValue("asteroidLMaxSpeed");
	}

	@Override
	public void store() {
		PoolManager.ASTEROIDS_L.push(this);
	}

	@Override
	public int getPoints() {
		return 20;
	}

	@Override
	protected Asteroid getInnerAsteroid(double x, double y, double pi) {
		return PoolManager.getAsteroidM(x, y, pi);
	}

}
