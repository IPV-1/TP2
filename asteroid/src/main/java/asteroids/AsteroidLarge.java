package asteroids;

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

    public static AsteroidLargePool getPool() {
        return pool;
    }

}
