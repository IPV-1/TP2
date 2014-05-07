package asteroids;

import asteroids.pools.AsteroidPools;

public class AsteroidMedium extends Asteroid {

	public AsteroidMedium() {
		super();
	}

	@Override
	public void store() {
        AsteroidPools.getInstance().push(this);
	}

}
