package asteroids.pools;

import asteroid.AsteroidGame;
import asteroids.Asteroid;
import asteroids.AsteroidLarge;
import asteroids.AsteroidMedium;
import asteroids.AsteroidSmall;

public class AsteroidPools {
    private AsteroidLargePool asteroidLargePool = new AsteroidLargePool();
    private AsteroidMediumPool asteroidMediumPool = new AsteroidMediumPool();
    private AsteroidSmallPool asteroidSmallPool = new AsteroidSmallPool();
    private static AsteroidPools ourInstance = new AsteroidPools();

    //Large
    public void push(AsteroidLarge asteroidLarge) {
        getAsteroidLargePool().push(asteroidLarge);
    }

    public AsteroidLarge getAsteroidLarge(AsteroidGame game) {
        return getAsteroidLargePool().get(game);
    }

    //Medium
    public void push(AsteroidMedium asteroidMedium) {
        getAsteroidMediumPool().push(asteroidMedium);
    }

    public AsteroidMedium getAsteroidMedium(AsteroidGame game) {
        return getAsteroidMediumPool().get(game);
    }

    public AsteroidMedium getAsteroidMedium(AsteroidGame game, double x, double y, double fromPi) {
        return getAsteroidMediumPool().get(game, x, y, fromPi);
    }

    //Small

    public void push(AsteroidSmall asteroidSmall) {
        getAsteroidSmallPool().push(asteroidSmall);
    }

    public AsteroidSmall getAsteroidSmall(AsteroidGame game) {
        return getAsteroidSmallPool().get(game);
    }

    public AsteroidSmall getAsteroidSmall(AsteroidGame game, double x, double y, double fromPi) {
        return getAsteroidSmallPool().get(game, x, y, fromPi);
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
