package asteroids;

import asteroids.pools.AsteroidSmallPool;

public class AsteroidSmall extends Asteroid {

    public static AsteroidSmallPool pool = new AsteroidSmallPool();

	public AsteroidSmall() {
		super();
	}

	@Override
	protected void explode() {
	}

	@Override
	public void store() {
        getPool().push(this);
	}

    public static AsteroidSmallPool getPool() {
        return pool;
    }
}
