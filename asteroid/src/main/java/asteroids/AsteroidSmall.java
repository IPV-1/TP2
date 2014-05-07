package asteroids;

import java.util.Stack;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidSmall extends Asteroid {

	public static final Stack<AsteroidSmall> ASTEROIDS = new Stack<AsteroidSmall>();

	public AsteroidSmall(AsteroidGame game) {
		super(game);
	}

	public AsteroidSmall(AsteroidGame game, double pi) {
		super(game, pi);
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
	
	@Override
	public int getPoints() {
		return 100;
	}

}
