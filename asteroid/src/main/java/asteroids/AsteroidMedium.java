package asteroids;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;
import components.PoolManager;

public class AsteroidMedium extends Asteroid {

	public AsteroidMedium(AsteroidGame game) {
		super(game);
	}

	public AsteroidMedium(AsteroidGame game, double pi) {
		super(game, pi);
	}

	@Override
	protected Sprite getSprite(AsteroidGame game) {
		return game.getSprite("asteroidM");
	}

	@Override
	protected double getMaxSpeed(AsteroidGame game) {
		return game.getValue("asteroidMMaxSpeed");
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
		return PoolManager.getAsteroidS(this.getGame(), x, y, pi);
	}

}
