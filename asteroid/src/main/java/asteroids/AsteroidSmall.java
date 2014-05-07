package asteroids;

import asteroids.pools.AsteroidPools;

public class AsteroidSmall extends Asteroid {

	public AsteroidSmall() {
		super();
	}

    @Override
    public void store() {
        AsteroidPools.getInstance().push(this);
    }
}
