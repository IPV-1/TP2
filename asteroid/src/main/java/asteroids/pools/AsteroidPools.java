package asteroids.pools;

import asteroid.AsteroidGame;
import asteroids.Asteroid;
import asteroids.AsteroidLarge;
import asteroids.AsteroidMedium;
import asteroids.AsteroidSmall;
import asteroids.factories.AsteroidFactory;

import java.util.Stack;

public class AsteroidPools {
    private Stack<AsteroidLarge> asteroidLargePool = new Stack<AsteroidLarge>();
    private Stack<AsteroidMedium> asteroidMediumPool = new Stack<AsteroidMedium>();
    private Stack<AsteroidSmall> asteroidSmallPool = new Stack<AsteroidSmall>();
    private static AsteroidPools ourInstance = new AsteroidPools();

    //Large
    public void push(AsteroidLarge asteroidLarge) {
        getAsteroidLargePool().push(asteroidLarge);
    }

    public AsteroidLarge getAsteroidLarge(AsteroidGame game) {
        if (getAsteroidLargePool().empty()) {
            return AsteroidFactory.newAsteroidLarge(game);
        }
        return AsteroidFactory.clean(getAsteroidLargePool().pop(), game);
    }

    //Medium
    public void push(AsteroidMedium asteroidMedium) {
        getAsteroidMediumPool().push(asteroidMedium);
    }

    public AsteroidMedium getAsteroidMedium(AsteroidGame game) {
        if (getAsteroidMediumPool().empty()) {
            return AsteroidFactory.newAsteroidMedium(game);
        }
        return AsteroidFactory.clean(getAsteroidMediumPool().pop(), game);
    }

    public AsteroidMedium getAsteroidMedium(AsteroidGame game, double x, double y, double fromPi) {
        double newPi = Asteroid.getNewPiFrom(game, fromPi);
        AsteroidMedium asteroid = getAsteroidMedium(game, newPi);
        asteroid.setX(x);
        asteroid.setY(y);
        return asteroid;
    }

    public AsteroidMedium getAsteroidMedium(AsteroidGame game, double pi) {
        AsteroidMedium asteroid;
        if (getAsteroidMediumPool().empty()) {
            asteroid = AsteroidFactory.newAsteroidMedium(game, pi);
        } else {
            asteroid = AsteroidFactory.clean(getAsteroidMediumPool().pop(), game, pi);
        }
        return asteroid;
    }

    //Small

    public void push(AsteroidSmall asteroidSmall) {
        getAsteroidSmallPool().push(asteroidSmall);
    }

    public AsteroidSmall getAsteroidSmall(AsteroidGame game) {
        if(getAsteroidSmallPool().empty()){
            return AsteroidFactory.newAsteroidSmall(game);
        }
        return AsteroidFactory.clean(getAsteroidSmallPool().pop(), game);
    }

    public AsteroidSmall getAsteroidSmall(AsteroidGame game, double x, double y, double fromPi) {
        double newPi = Asteroid.getNewPiFrom(game, fromPi);
        AsteroidSmall asteroid;
        if (getAsteroidSmallPool().empty() ){
            asteroid = AsteroidFactory.newAsteroidSmall(game, newPi);
        }else {
            asteroid = AsteroidFactory.clean(getAsteroidSmallPool().pop(),game, newPi);
        }
        asteroid.setX(x);
        asteroid.setY(y);
        return asteroid;
    }


    /**
     * Common singleton and getters method.
     */

    public static AsteroidPools getInstance() {
        return ourInstance;
    }

    private AsteroidPools() {
    }

    protected Stack<AsteroidMedium> getAsteroidMediumPool() {
        return asteroidMediumPool;
    }

    protected Stack<AsteroidSmall> getAsteroidSmallPool() {
        return asteroidSmallPool;
    }

    public Stack<AsteroidLarge> getAsteroidLargePool() {
        return asteroidLargePool;
    }
}
