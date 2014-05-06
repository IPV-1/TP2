package asteroids.pools;


import asteroid.AsteroidGame;
import asteroids.Asteroid;
import asteroids.AsteroidMedium;
import asteroids.factories.AsteroidMediumFactory;

public class AsteroidMediumPool extends AsteroidPool<AsteroidMedium>{

	@Override
	public AsteroidMedium get(AsteroidGame game, double pi) {
		AsteroidMedium asteroid;
		if (getAsteroids().empty()) {
			asteroid = AsteroidMediumFactory.newAsteroid(game, pi);
		} else {
			asteroid = AsteroidMediumFactory.clean(getAsteroids().pop(), game, pi);
		}
		return asteroid;
	}

	@Override
	public AsteroidMedium get(AsteroidGame game, double x, double y, double fromPi) {
		double newPi = Asteroid.getNewPiFrom(game, fromPi);
		AsteroidMedium asteroid = get(game, newPi);
		asteroid.setX(x);
		asteroid.setY(y);
		return asteroid;
	}
}
