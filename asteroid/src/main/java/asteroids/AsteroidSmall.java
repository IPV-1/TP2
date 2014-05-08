package asteroids;

import com.uqbar.vainilla.appearances.Sprite;
import components.PoolManager;
import config.Configuration;

public class AsteroidSmall extends Asteroid {

	public AsteroidSmall() {
		super();
	}

	public AsteroidSmall(double pi) {
		super(pi);
	}

	@Override
	protected Sprite getSprite() {
		return Configuration.getSprite("asteroidS");
	}

	@Override
	protected double getMaxSpeed() {
		return Configuration.getValue("asteroidSMaxSpeed");
	}

	@Override
	protected void explode() {
	}

	@Override
	public void store() {
		PoolManager.ASTEROIDS_S.push(this);
	}
	
	@Override
	public int getPoints() {
		return 100;
	}
	
	@Override
	protected Asteroid getInnerAsteroid(double x, double y, double pi) {
		return null;
	}

}
