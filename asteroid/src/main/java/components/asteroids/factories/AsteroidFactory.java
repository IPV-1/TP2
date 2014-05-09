package components.asteroids.factories;


import asteroid.AsteroidGame;
import components.asteroids.Asteroid;
import components.asteroids.estrategies.ExplodeStrategy;
import components.asteroids.estrategies.ExplodeToMediumAsteroids;
import components.asteroids.estrategies.ExplodeToSmallAsteroids;
import components.asteroids.estrategies.JustExplode;
import com.uqbar.vainilla.appearances.Appearance;
import components.shapes.Circle;
import utils.Utils;

import java.awt.*;

public class AsteroidFactory {

    public static Asteroid clean(Appearance appearance, Asteroid asteroidLarge, AsteroidGame game, Circle shape, double minSpeed, double masSpeed, int points, ExplodeStrategy explodeStrategy) {
        double pi = Utils.randDouble(2);
        double speed = Utils.randDouble(minSpeed, masSpeed);
        double x = Utils.randDouble(game.getDisplayWidth()
                - shape.getDiameter() / 2);
        double y = Utils.randDouble(game.getDisplayHeight()
                - shape.getDiameter() / 2);
        asteroidLarge.setAppearance(appearance);
        asteroidLarge.setShape(shape);
        shape.setShapeable(asteroidLarge);
        asteroidLarge.setX(x);
        asteroidLarge.setY(y);
        asteroidLarge.setPi(pi);
        asteroidLarge.getUVector().setPI(pi);
        asteroidLarge.setSpeed(speed);
        asteroidLarge.setPoints(points);
        asteroidLarge.setExplodeStrategy(explodeStrategy);
        return asteroidLarge;
    }

	//Large
	public static Asteroid newAsteroidLarge(AsteroidGame game) {
		return cleanLarge(new Asteroid(), game);
	}

    public static Asteroid cleanLarge(Asteroid asteroidLarge, AsteroidGame game) {
        Circle shape = new Circle(game.getSprite("asteroidL").getWidth());
        Appearance appearance = new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int) shape.getDiameter());
        clean(appearance, asteroidLarge, game, shape, game.getValue("asteroidMinSpeed"), game.getValue("asteroidLMaxSpeed"), 100, ExplodeToMediumAsteroids.getInstance());
        return asteroidLarge;
    }

    //Medium

    public static Asteroid newAsteroidMedium(AsteroidGame game, double newPi) {
        return cleanMedium(new Asteroid(), game, newPi);
    }

    public static Asteroid newAsteroidMedium(AsteroidGame game) {
        return cleanMedium(new Asteroid(), game);
    }

    public static Asteroid cleanMedium(Asteroid asteroidMedium, AsteroidGame game, double pi) {
        Circle shape = new Circle(game.getSprite("asteroidM").getWidth());
        Appearance appearance = new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int) shape.getDiameter());
        clean(appearance, asteroidMedium, game, shape, game.getValue("asteroidMinSpeed"), game.getValue("asteroidMMaxSpeed"), 50, ExplodeToSmallAsteroids.getInstance());
        asteroidMedium.setPi(pi);
        asteroidMedium.getUVector().setPI(pi);
        return asteroidMedium;
    }

    public static Asteroid cleanMedium(Asteroid asteroidMedium, AsteroidGame game) {
        double pi = Utils.randDouble(2);
        return cleanMedium(asteroidMedium, game, pi);
    }

    //Small
    public static Asteroid newAsteroidSmall(AsteroidGame game, double newPi) {
        return cleanSmall(new Asteroid(), game, newPi);
    }

    public static Asteroid newAsteroidSmall(AsteroidGame game) {
        return cleanSmall(new Asteroid(), game);
    }

    public static Asteroid cleanSmall(Asteroid asteroidSmall, AsteroidGame game) {
        double pi = Utils.randDouble(2);
        return cleanSmall(asteroidSmall, game, pi);
    }

    public static Asteroid cleanSmall(Asteroid asteroidSmall, AsteroidGame game, double pi) {
        Circle shape = new Circle(game.getSprite("asteroidS").getWidth());
        Appearance appearance = new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int) shape.getDiameter());
        clean(appearance, asteroidSmall, game, shape, game.getValue("asteroidMinSpeed"), game.getValue("asteroidSMaxSpeed"), 10, JustExplode.getInstance());
        asteroidSmall.setPi(pi);
        asteroidSmall.getUVector().setPI(pi);
        return asteroidSmall;
    }


}
