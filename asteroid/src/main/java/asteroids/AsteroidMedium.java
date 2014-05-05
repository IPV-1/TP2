package asteroids;

import java.util.Stack;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidMedium extends Asteroid {

	public static final Stack<AsteroidMedium> ASTEROIDS = new Stack<AsteroidMedium>();

	protected AsteroidMedium(AsteroidGame game) {
		super(game);
	}

	protected AsteroidMedium(AsteroidGame game, double pi) {
		super(game, pi);
	}

	@Override
	protected Sprite getSprite(AsteroidGame game) {
		return game.getSprite("asteroidM");
	}

	@Override
	protected double getMaxSpeed(AsteroidGame game) {
		return game.getValue("asteroidMMaxSpeed");
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
		return (AsteroidMedium) (ASTEROIDS.empty() ? new AsteroidMedium(game)
				: ASTEROIDS.pop().clean(game));
	}

	protected static AsteroidMedium get(AsteroidGame game, double x, double y,
			double fromPi) {
		double newPi = Asteroid.getNewPiFrom(game, fromPi);
		AsteroidMedium asteroid = (AsteroidMedium) (ASTEROIDS.empty() ? new AsteroidMedium(
				game, newPi) : ASTEROIDS.pop().cleanWithPi(game, newPi));
		asteroid.setX(x);
		asteroid.setY(y);
		return asteroid;
	}

}
