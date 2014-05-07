package asteroids.pools;

import asteroid.AsteroidGame;
import asteroids.AsteroidLarge;
import asteroids.factories.AsteroidFactory;

public class AsteroidLargePool extends AsteroidPool<AsteroidLarge>{
    public AsteroidLarge get(AsteroidGame game) {
        if (empty()) {
            return AsteroidFactory.newAsteroidLarge(game);
        }
        return AsteroidFactory.clean(pop(), game);
    }

}
