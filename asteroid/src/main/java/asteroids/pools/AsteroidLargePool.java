package asteroids.pools;

import asteroid.AsteroidGame;
import asteroids.AsteroidLarge;
import asteroids.factories.AsteroidLargeFactory;

public class AsteroidLargePool extends AsteroidPool<AsteroidLarge>{
    public AsteroidLarge get(AsteroidGame game) {
        if (empty()) {
            return AsteroidLargeFactory.newAsteroid(game);
        }
        return AsteroidLargeFactory.clean(pop(), game);
    }

}
