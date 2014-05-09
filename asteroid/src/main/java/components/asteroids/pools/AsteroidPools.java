package components.asteroids.pools;

import asteroid.AsteroidGame;
import components.asteroids.Asteroid;
import components.asteroids.factories.AsteroidFactory;

import java.util.Stack;

public class AsteroidPools {
    private Stack<Asteroid> asteroidPool = new Stack<Asteroid>();
    private static AsteroidPools ourInstance = new AsteroidPools();

    //Asteroid
    public void push(Asteroid asteroid) {
        getAsteroidPool().push(asteroid);
    }

    //Large

    public Asteroid getAsteroidLarge(AsteroidGame game) {
        if (getAsteroidPool().empty()) {
            return AsteroidFactory.newAsteroidLarge(game);
        }
        return AsteroidFactory.cleanLarge(getAsteroidPool().pop(), game);
    }

    //Medium

    public Asteroid getAsteroidMedium(AsteroidGame game) {
        if (getAsteroidPool().empty()) {
            return AsteroidFactory.newAsteroidMedium(game);
        }
        return AsteroidFactory.cleanMedium(getAsteroidPool().pop(), game);
    }

    public Asteroid getAsteroidMedium(AsteroidGame game, double x, double y, double fromPi) {
        double newPi = Asteroid.getNewPiFrom(game, fromPi);
        Asteroid asteroid = getAsteroidMedium(game, newPi);
        asteroid.setX(x);
        asteroid.setY(y);
        return asteroid;
    }

    public Asteroid getAsteroidMedium(AsteroidGame game, double pi) {
        Asteroid asteroid;
        if (getAsteroidPool().empty()) {
            asteroid = AsteroidFactory.newAsteroidMedium(game, pi);
        } else {
            asteroid = AsteroidFactory.cleanMedium(getAsteroidPool().pop(), game, pi);
        }
        return asteroid;
    }

    //Small

    public Asteroid getAsteroidSmall(AsteroidGame game) {
        if(getAsteroidPool().empty()){
            return AsteroidFactory.newAsteroidSmall(game);
        }
        return AsteroidFactory.clean(getAsteroidPool().pop(), game);
    }

    public Asteroid getAsteroidSmall(AsteroidGame game, double x, double y, double fromPi) {
        double newPi = Asteroid.getNewPiFrom(game, fromPi);
        Asteroid asteroid;
        if (getAsteroidPool().empty() ){
            asteroid = AsteroidFactory.newAsteroidSmall(game, newPi);
        }else {
            asteroid = AsteroidFactory.cleanSmall(getAsteroidPool().pop(),game, newPi);
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

    public Stack<Asteroid> getAsteroidPool() {
        return asteroidPool;
    }
}
