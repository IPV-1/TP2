package asteroids.pools;


import asteroid.AsteroidGame;
import asteroids.Asteroid;
import asteroids.AsteroidMedium;
import asteroids.factories.AsteroidFactory;

public class AsteroidMediumPool extends AsteroidPool<AsteroidMedium>{

    public AsteroidMedium get(AsteroidGame game) {

        if (empty()) {
            return AsteroidFactory.newAsteroidMedium(game);
        }
        return AsteroidFactory.clean(pop(), game);

    }

	public AsteroidMedium get(AsteroidGame game, double pi) {
		AsteroidMedium asteroid;
		if (empty()) {
			asteroid = AsteroidFactory.newAsteroidMedium(game, pi);
		} else {
			asteroid = AsteroidFactory.clean(getAsteroids().pop(), game, pi);
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
