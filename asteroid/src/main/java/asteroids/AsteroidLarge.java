package asteroids;

import java.util.Stack;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidLarge extends Asteroid {

	public static final Stack<AsteroidLarge> ASTEROIDS = new Stack<AsteroidLarge>();

	protected AsteroidLarge(AsteroidGame game) {
		super(game);
	}

	@Override
	protected Sprite getSprite(AsteroidGame game) {
		return game.getSprite("asteroidL");
	}

	@Override
	protected double getMaxSpeed(AsteroidGame game) {
		return game.getValue("asteroidLMaxSpeed");
	}

	@Override
	protected void explode() {
		double radius = this.getGame().getSprite("asteroidM").getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(
				AsteroidMedium.get(this.getGame(), x, y, this.getPi()));
		this.getScene().addAsteroid(
				AsteroidMedium.get(this.getGame(), x, y, this.getPi()));
	}

	@Override
	public void store() {
		ASTEROIDS.push(this);
	}

	@Override
	public int getPoints() {
		return 20;
	}

	public static AsteroidLarge get(AsteroidGame game) {
		return (AsteroidLarge) (ASTEROIDS.empty() ? new AsteroidLarge(game)
				: ASTEROIDS.pop().clean(game));
	}

	public static AsteroidLarge get(AsteroidGame game, double x, double y) {
		AsteroidLarge asteroid = AsteroidLarge.get(game);
		asteroid.setX(x);
		asteroid.setY(y);
		return asteroid;
	}

}
