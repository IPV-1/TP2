package asteroids;

import asteroid.AsteroidGame;

import asteroids.factories.AsteroidMediumFactory;
import asteroids.pools.AsteroidMediumPool;

public class AsteroidMedium extends Asteroid {
    private static AsteroidMediumPool pool = new AsteroidMediumPool();

	public AsteroidMedium() {
		super();
	}

    public static AsteroidMediumPool getPool() {
        return pool;
    }

    @Override
	protected void explode() {
		double radius = this.getGame().getSprite("asteroidS").getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(
				AsteroidSmall.get(this.getGame(), x, y, this.getPi()));
		this.getScene().addAsteroid(
				AsteroidSmall.get(this.getGame(), x, y, this.getPi()));
	}

	@Override
	public void store() {
        getPool().push(this);
	}

	public static AsteroidMedium get(AsteroidGame game) {

		if (getPool().empty()) {
			return AsteroidMediumFactory.newAsteroid(game);
		}
		return AsteroidMediumFactory.clean(getPool().pop(), game);

	}

	protected static AsteroidMedium get(AsteroidGame game, double x, double y,
	                                    double fromPi) {
		double newPi = Asteroid.getNewPiFrom(game, fromPi);
		AsteroidMedium asteroid;
		if (getPool().empty()) {
			asteroid = AsteroidMediumFactory.newAsteroid(game, newPi);
		} else {
			asteroid = AsteroidMediumFactory.clean(getPool().pop(), game, newPi);
		}
		asteroid.setX(x);
		asteroid.setY(y);
		return asteroid;
	}

}
