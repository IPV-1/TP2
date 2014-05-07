package asteroids.pools;

import asteroid.AsteroidGame;
import asteroids.AsteroidLarge;
import asteroids.AsteroidMedium;

public class AsteroidPools {
    private AsteroidLargePool asteroidLargePool = new AsteroidLargePool();
    private AsteroidMediumPool asteroidMediumPool = new AsteroidMediumPool();
    private AsteroidSmallPool asteroidSmallPool = new AsteroidSmallPool();
    private static AsteroidPools ourInstance = new AsteroidPools();

    //Large
    public AsteroidLarge getAsteroidLarge(AsteroidGame game){
        return getAsteroidLargePool().get(game);
    }

    //Medium
    public AsteroidMedium getAsteroidMedium(AsteroidGame game) {
        return getAsteroidMediumPool().get(game);
    }

    public AsteroidMedium getAsteroidMedium(AsteroidGame game, double x, double y, double fromPi) {
        return getAsteroidMediumPool().get(game,x,y,fromPi);
    }


    /**
     * Common singleton and getters method.
     */

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
