package asteroids;

import java.util.Stack;

import asteroid.AsteroidGame;

import asteroids.factories.AsteroidSmallFactory;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.appearances.Sprite;
import components.shapes.Shape;

public class AsteroidSmall extends Asteroid {

	public static final Stack<AsteroidSmall> ASTEROIDS = new Stack<AsteroidSmall>();

	public AsteroidSmall() {
		super();
	}

	@Override
	protected void explode() {
	}

	@Override
	public void store() {
		ASTEROIDS.push(this);
	}

	public static AsteroidSmall get(AsteroidGame game) {
		if(ASTEROIDS.empty()){
			return AsteroidSmallFactory.newAsteroid(game);
		}
		return AsteroidSmallFactory.clean(ASTEROIDS.pop(), game);
	}

	protected static AsteroidSmall get(AsteroidGame game, double x, double y,
			double fromPi) {
		double newPi = Asteroid.getNewPiFrom(game, fromPi);
		AsteroidSmall asteroid;
		if (ASTEROIDS.empty() ){
			asteroid = AsteroidSmallFactory.newAsteroid(game, newPi);
		}else {
			asteroid = AsteroidSmallFactory.clean(ASTEROIDS.pop(),game, newPi);
		}
		asteroid.setX(x);
		asteroid.setY(y);
		return asteroid;
	}

}
