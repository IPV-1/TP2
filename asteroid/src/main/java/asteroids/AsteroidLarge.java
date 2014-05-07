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
	protected void explode() {
		double radius = this.getGame().getSprite("asteroidM").getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(
				PoolManager.getAsteroidM(this.getGame(), x, y,
						getNewPiFrom(this.getGame(), this.getPi())));
		this.getScene().addAsteroid(
				PoolManager.getAsteroidM(this.getGame(), x, y,
						getNewPiFrom(this.getGame(), this.getPi())));
	}

	@Override
	public void store() {
		PoolManager.ASTEROIDS_L.push(this);
	}

	@Override
	public int getPoints() {
		return 20;
	}

}
