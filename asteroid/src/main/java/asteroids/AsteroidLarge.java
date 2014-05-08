package asteroids;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;
import components.PoolManager;

public class AsteroidLarge extends Asteroid {

	public AsteroidLarge(AsteroidGame game) {
		super(game);
	}

	@Override
	protected Sprite getSprite(AsteroidGame game) {
		return game.getSprite("asteroidL");
	}

	@Override
	protected double getMaxSpeed(AsteroidGame game) {
		return game.getValue("asteroidLMaxSpeed");
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
		return PoolManager.getAsteroidM(this.getGame(), x, y, pi);
	}

}
