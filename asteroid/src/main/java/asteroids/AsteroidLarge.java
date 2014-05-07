package asteroids;

import java.util.Stack;

import asteroid.AsteroidGame;

import asteroids.factories.AsteroidLargeFactory;

public class AsteroidLarge extends Asteroid {

	public static final Stack<AsteroidLarge> ASTEROIDS = new Stack<AsteroidLarge>();

	public AsteroidLarge() {
		super();
	}

	@Override
	protected void explode() {
		double radius = this.getGame().getSprite("asteroidM").getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(
				AsteroidMedium.getPool().get(this.getGame(), x, y, this.getPi()));
		this.getScene().addAsteroid(
				AsteroidMedium.getPool().get(this.getGame(), x, y, this.getPi()));
	}

	@Override
	public void store() {
		ASTEROIDS.push(this);
	}

	public static AsteroidLarge get(AsteroidGame game) {
		if (ASTEROIDS.empty()) {
			return AsteroidLargeFactory.newAsteroid(game);
		}
		return AsteroidLargeFactory.clean(ASTEROIDS.pop(), game);
	}

}
