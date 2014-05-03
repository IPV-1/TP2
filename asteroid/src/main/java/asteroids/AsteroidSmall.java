package asteroids;

import java.util.Stack;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidSmall extends Asteroid {

	public static final Stack<AsteroidSmall> ASTEROIDS = new Stack<AsteroidSmall>();

	public AsteroidSmall(AsteroidGame game) {
		super(game);
	}

	public AsteroidSmall(AsteroidGame game, double x, double y) {
		super(game, x, y);
	}

	@Override
	protected Sprite getSprite(AsteroidGame game) {
		return game.getSprite("asteroidS");
	}

	@Override
	protected double getMaxSpeed(AsteroidGame game) {
		return game.getValue("asteroidSMaxSpeed");
	}

	@Override
	protected void explode() {
	}

	@Override
	public void store() {
		ASTEROIDS.push(this);
	}

	public static AsteroidSmall get(AsteroidGame game) {
		return (AsteroidSmall) (ASTEROIDS.empty() ? new AsteroidSmall(game)
				: ASTEROIDS.pop().clean(game));
	}
	
	public static AsteroidSmall get(AsteroidGame game, double x, double y) {
		AsteroidSmall asteroid = AsteroidSmall.get(game);
		asteroid.setX(x);
		asteroid.setY(y);
		return asteroid;
	}

}
