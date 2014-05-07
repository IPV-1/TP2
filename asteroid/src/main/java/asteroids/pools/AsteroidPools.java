package asteroids.pools;

import asteroid.AsteroidGame;
import asteroids.AsteroidLarge;

public class AsteroidPools {
    private AsteroidLargePool asteroidLargePool = new AsteroidLargePool();
    private AsteroidMediumPool asteroidMediumPool = new AsteroidMediumPool();
    private AsteroidSmallPool asteroidSmallPool = new AsteroidSmallPool();
    private static AsteroidPools ourInstance = new AsteroidPools();

    public AsteroidLarge getAsteroidLarge(AsteroidGame game){
        return getAsteroidLargePool().get(game);
    }

    public static AsteroidPools getInstance() {
        return ourInstance;
    }

    private AsteroidPools() {
    }

    protected AsteroidLargePool getAsteroidLargePool() {
        return asteroidLargePool;
    }

    protected AsteroidMediumPool getAsteroidMediumPool() {
        return asteroidMediumPool;
    }

    protected AsteroidSmallPool getAsteroidSmallPool() {
        return asteroidSmallPool;
    }
}
