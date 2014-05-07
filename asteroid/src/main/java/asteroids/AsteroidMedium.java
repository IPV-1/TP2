package asteroids;

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
				AsteroidSmall.getPool().get(this.getGame(), x, y, this.getPi()));
		this.getScene().addAsteroid(
				AsteroidSmall.getPool().get(this.getGame(), x, y, this.getPi()));
	}

	@Override
	public void store() {
        getPool().push(this);
	}

}
