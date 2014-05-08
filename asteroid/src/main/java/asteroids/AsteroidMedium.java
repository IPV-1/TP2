package asteroids;

import com.uqbar.vainilla.appearances.Sprite;
import components.PoolManager;
import config.Configuration;

public class AsteroidMedium extends Asteroid {

	public AsteroidMedium() {
		super();
	}

	public AsteroidMedium(double pi) {
		super(pi);
	}

	@Override
	protected Sprite getSprite() {
		return Configuration.getSprite("asteroidM");
	}

	@Override
	protected double getMaxSpeed() {
		return Configuration.getValue("asteroidMMaxSpeed");
	}

	@Override
	public void store() {
		PoolManager.ASTEROIDS_M.push(this);
	}

	@Override
	public int getPoints() {
		return 50;
	}
	
	@Override
	protected Asteroid getInnerAsteroid(double x, double y, double pi) {
		return PoolManager.getAsteroidS(x, y, pi);
	}

}
