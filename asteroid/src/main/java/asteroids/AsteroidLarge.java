package asteroids;

import asteroids.pools.AsteroidPools;

public class AsteroidLarge extends Asteroid {

	public AsteroidLarge() {
		super();
	}

    @Override
    public void store() {
        AsteroidPools.getInstance().push(this);
    }

}
