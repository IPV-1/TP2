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
	protected void explode() {
		double radius = this.getGame().getSprite("asteroidS").getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(
				PoolManager.getAsteroidS(this.getGame(), x, y,
						getNewPiFrom(this.getGame(), this.getPi())));
		this.getScene().addAsteroid(
				PoolManager.getAsteroidS(this.getGame(), x, y,
						getNewPiFrom(this.getGame(), this.getPi())));
	}

	@Override
	public void store() {
		PoolManager.ASTEROIDS_M.push(this);
	}

	@Override
	public int getPoints() {
		return 50;
	}

}
