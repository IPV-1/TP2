package asteroids;

import java.util.Stack;

import asteroid.AsteroidGame;

import asteroids.factories.AsteroidLargeFactory;
import asteroids.factories.AsteroidMediumFactory;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.appearances.Sprite;
import components.shapes.Shape;

public class AsteroidMedium extends Asteroid {

	public static final Stack<AsteroidMedium> ASTEROIDS = new Stack<AsteroidMedium>();

	public AsteroidMedium() {
		super();
	}

	@Override
	protected void explode() {
		double radius = this.getGame().getSprite("asteroidS").getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(
				AsteroidSmall.get(this.getGame(), x, y, this.getPi()));
		this.getScene().addAsteroid(
				AsteroidSmall.get(this.getGame(), x, y, this.getPi()));
	}

	@Override
	public void store() {
		ASTEROIDS.push(this);
	}

	@Override
	public int getPoints() {
		return 50;
	}

	public static AsteroidMedium get(AsteroidGame game) {

		if (ASTEROIDS.empty()) {
			return AsteroidMediumFactory.newAsteroid(game);
		}
		return AsteroidMediumFactory.clean(ASTEROIDS.pop(), game);

	}

	protected static AsteroidMedium get(AsteroidGame game, double x, double y,
	                                    double fromPi) {
		double newPi = Asteroid.getNewPiFrom(game, fromPi);
		AsteroidMedium asteroid;
		if (ASTEROIDS.empty()) {
			asteroid = AsteroidMediumFactory.newAsteroid(game, newPi);
		} else {
			asteroid = AsteroidMediumFactory.clean(ASTEROIDS.pop(), game, newPi);
		}
		asteroid.setX(x);
		asteroid.setY(y);
		return asteroid;
	}

}
