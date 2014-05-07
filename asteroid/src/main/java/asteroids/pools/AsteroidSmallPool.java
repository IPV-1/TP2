package asteroids.pools;


import asteroid.AsteroidGame;
import asteroids.Asteroid;
import asteroids.AsteroidSmall;
import asteroids.factories.AsteroidSmallFactory;


public class AsteroidSmallPool extends AsteroidPool<AsteroidSmall>{
    public AsteroidSmall get(AsteroidGame game) {
        if(empty()){
            return AsteroidSmallFactory.newAsteroid(game);
        }
        return AsteroidSmallFactory.clean(pop(), game);
    }

    public AsteroidSmall get(AsteroidGame game, double x, double y,
                                       double fromPi) {
        double newPi = Asteroid.getNewPiFrom(game, fromPi);
        AsteroidSmall asteroid;
        if (empty() ){
            asteroid = AsteroidSmallFactory.newAsteroid(game, newPi);
        }else {
            asteroid = AsteroidSmallFactory.clean(pop(),game, newPi);
        }
        asteroid.setX(x);
        asteroid.setY(y);
        return asteroid;
    }

}
