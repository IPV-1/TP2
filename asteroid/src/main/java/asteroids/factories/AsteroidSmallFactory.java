package asteroids.factories;


import asteroid.AsteroidGame;
import asteroids.AsteroidSmall;
import com.uqbar.vainilla.appearances.Appearance;
import components.shapes.Circle;
import utils.Utils;

import java.awt.*;


public class AsteroidSmallFactory {

	public static AsteroidSmall newAsteroid(AsteroidGame game, double newPi) {
		return clean(new AsteroidSmall(), game, newPi);
	}

	public static AsteroidSmall newAsteroid(AsteroidGame game) {
		return clean(new AsteroidSmall(), game);
	}

	public static AsteroidSmall clean(AsteroidSmall asteroidSmall, AsteroidGame game, double pi) {
		Circle shape = new Circle(game.getSprite("asteroidS").getWidth());
		double speed = Utils.randDouble(
				game.getValue("asteroidMinSpeed"), game.getValue("asteroidSMaxSpeed"));
		double x = Utils.randDouble(game.getDisplayWidth()
				- shape.getDiameter() / 2);
		double y = Utils.randDouble(game.getDisplayHeight()
				- shape.getDiameter() / 2);
		Appearance appearance = new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int) shape.getDiameter());

		asteroidSmall.setAppearance(appearance);
		asteroidSmall.setShape(shape);
		shape.setShapeable(asteroidSmall);
		asteroidSmall.setX(x);
		asteroidSmall.setY(y);
		asteroidSmall.setPi(pi);
		asteroidSmall.getUVector().setPI(pi);
		asteroidSmall.setSpeed(speed);
		return asteroidSmall;
	}

	public static AsteroidSmall clean(AsteroidSmall asteroidSmall, AsteroidGame game) {
		double pi = Utils.randDouble(2);
		return clean(asteroidSmall, game, pi);
	}
}
