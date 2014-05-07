package asteroids.pools;


import asteroid.AsteroidGame;
import asteroids.Asteroid;
import asteroids.AsteroidSmall;
import asteroids.factories.AsteroidFactory;


public class AsteroidSmallPool extends AsteroidPool<AsteroidSmall>{
    public AsteroidSmall get(AsteroidGame game) {
        if(empty()){
            return AsteroidFactory.newAsteroidSmall(game);
        }
        return AsteroidFactory.clean(pop(), game);
    }

    public AsteroidSmall get(AsteroidGame game, double x, double y,
                                       double fromPi) {
        double newPi = Asteroid.getNewPiFrom(game, fromPi);
        AsteroidSmall asteroid;
        if (empty() ){
            asteroid = AsteroidFactory.newAsteroidSmall(game, newPi);
        }else {
            asteroid = AsteroidFactory.clean(pop(),game, newPi);
        }
        asteroid.setX(x);
        asteroid.setY(y);
        return asteroid;
    }

}
