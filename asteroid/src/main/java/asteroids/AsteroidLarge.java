package asteroids;

import asteroids.pools.AsteroidLargePool;

public class AsteroidLarge extends Asteroid {

    private static AsteroidLargePool pool = new AsteroidLargePool();

	public AsteroidLarge() {
		super();
	}

	@Override
	public void store() {
        getPool().push(this);
	}

    public static AsteroidLargePool getPool() {
        return pool;
    }

}
