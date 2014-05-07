package asteroids;

import asteroid.AsteroidGame;

import asteroids.factories.AsteroidLargeFactory;
import asteroids.pools.AsteroidLargePool;

public class AsteroidLarge extends Asteroid {

    private static AsteroidLargePool pool = new AsteroidLargePool();

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
        getPool().push(this);
	}

	public static AsteroidLarge get(AsteroidGame game) {
		if (getPool().empty()) {
			return AsteroidLargeFactory.newAsteroid(game);
		}
		return AsteroidLargeFactory.clean(getPool().pop(), game);
	}

    public static AsteroidLargePool getPool() {
        return pool;
    }

}
