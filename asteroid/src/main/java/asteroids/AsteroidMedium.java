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
	public void store() {
        getPool().push(this);
	}

}
