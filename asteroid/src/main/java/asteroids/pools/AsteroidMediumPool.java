package asteroids.pools;


import asteroid.AsteroidGame;
import asteroids.Asteroid;
import asteroids.AsteroidMedium;
import asteroids.factories.AsteroidMediumFactory;

public class AsteroidMediumPool extends AsteroidPool<AsteroidMedium>{

    public AsteroidMedium get(AsteroidGame game) {

        if (empty()) {
            return AsteroidMediumFactory.newAsteroid(game);
        }
        return AsteroidMediumFactory.clean(pop(), game);

    }

	public AsteroidMedium get(AsteroidGame game, double pi) {
		AsteroidMedium asteroid;
		if (empty()) {
			asteroid = AsteroidMediumFactory.newAsteroid(game, pi);
		} else {
			asteroid = AsteroidMediumFactory.clean(getAsteroids().pop(), game, pi);
		}
		return asteroid;
	}


	public AsteroidMedium get(AsteroidGame game, double x, double y, double fromPi) {
		double newPi = Asteroid.getNewPiFrom(game, fromPi);
		AsteroidMedium asteroid = get(game, newPi);
		asteroid.setX(x);
		asteroid.setY(y);
		return asteroid;
	}
}
