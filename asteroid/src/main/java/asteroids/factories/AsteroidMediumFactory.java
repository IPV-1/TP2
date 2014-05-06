package asteroids.factories;


import asteroid.AsteroidGame;
import asteroids.AsteroidMedium;
import com.uqbar.vainilla.appearances.Appearance;
import components.shapes.Circle;
import utils.Utils;

import java.awt.*;


public class AsteroidMediumFactory {

	public static AsteroidMedium newAsteroid(AsteroidGame game, double newPi) {
		return clean(new AsteroidMedium(), game, newPi);
	}

	public static AsteroidMedium newAsteroid(AsteroidGame game) {
		return clean(new AsteroidMedium(), game);
	}

	public static AsteroidMedium clean(AsteroidMedium asteroidMedium, AsteroidGame game, double pi) {
		Circle shape = new Circle(game.getSprite("asteroidM").getWidth());
		double speed = Utils.randDouble(
				game.getValue("asteroidMinSpeed"), game.getValue("asteroidMMaxSpeed"));
		double x = Utils.randDouble(game.getDisplayWidth()
				- shape.getDiameter() / 2);
		double y = Utils.randDouble(game.getDisplayHeight()
				- shape.getDiameter() / 2);
		Appearance appearance = new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int) shape.getDiameter());

		asteroidMedium.setAppearance(appearance);
		asteroidMedium.setShape(shape);
		shape.setShapeable(asteroidMedium);
		asteroidMedium.setX(x);
		asteroidMedium.setY(y);
		asteroidMedium.setPi(pi);
		asteroidMedium.getUVector().setPI(pi);
		asteroidMedium.setSpeed(speed);
		return asteroidMedium;
	}

	public static AsteroidMedium clean(AsteroidMedium asteroidMedium, AsteroidGame game) {
		double pi = Utils.randDouble(2);
		return clean(asteroidMedium, game, pi);
	}
}
