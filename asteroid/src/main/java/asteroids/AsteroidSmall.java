package asteroids;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;
import components.PoolManager;

public class AsteroidSmall extends Asteroid {

	public AsteroidSmall(AsteroidGame game) {
		super(game);
	}

	public AsteroidSmall(AsteroidGame game, double pi) {
		super(game, pi);
	}

	@Override
	protected Sprite getSprite(AsteroidGame game) {
		return game.getSprite("asteroidS");
	}

	@Override
	protected double getMaxSpeed(AsteroidGame game) {
		return game.getValue("asteroidSMaxSpeed");
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

}
