package asteroids.factories;


import asteroid.AsteroidGame;
import asteroids.AsteroidLarge;
import asteroids.AsteroidMedium;
import asteroids.AsteroidSmall;
import asteroids.estrategies.ExplodeToMediumAsteroids;
import asteroids.estrategies.ExplodeToSmallAsteroids;
import com.uqbar.vainilla.appearances.Appearance;
import components.shapes.Circle;
import utils.Utils;

import java.awt.*;

public class AsteroidFactory {

    //Large
    public static AsteroidLarge newAsteroidLarge(AsteroidGame game) {
        return clean(new AsteroidLarge(), game);
    }

    public static AsteroidLarge clean(AsteroidLarge asteroidLarge, AsteroidGame game) {
        Circle shape = new Circle(game.getSprite("asteroidL").getWidth());
        double pi = Utils.randDouble(2);
        double speed = Utils.randDouble(
                game.getValue("asteroidMinSpeed"), game.getValue("asteroidLMaxSpeed"));
        double x = Utils.randDouble(game.getDisplayWidth()
                - shape.getDiameter() / 2);
        double y = Utils.randDouble(game.getDisplayHeight()
                - shape.getDiameter() / 2);
        Appearance appearance = new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int) shape.getDiameter());

        asteroidLarge.setAppearance(appearance);
        asteroidLarge.setShape(shape);
        shape.setShapeable(asteroidLarge);
        asteroidLarge.setX(x);
        asteroidLarge.setY(y);
        asteroidLarge.setPi(pi);
        asteroidLarge.getUVector().setPI(pi);
        asteroidLarge.setSpeed(speed);
        asteroidLarge.setPoints(20);
        asteroidLarge.setExplodeStrategy(new ExplodeToMediumAsteroids());
        return asteroidLarge;
    }

    //Medium

    public static AsteroidMedium newAsteroidMedium(AsteroidGame game, double newPi) {
        return clean(new AsteroidMedium(), game, newPi);
    }

    public static AsteroidMedium newAsteroidMedium(AsteroidGame game) {
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
        asteroidMedium.setPoints(50);
        asteroidMedium.setExplodeStrategy(new ExplodeToSmallAsteroids());
        return asteroidMedium;
    }

    public static AsteroidMedium clean(AsteroidMedium asteroidMedium, AsteroidGame game) {
        double pi = Utils.randDouble(2);
        return clean(asteroidMedium, game, pi);
    }

    //Small
    public static AsteroidSmall newAsteroidSmall(AsteroidGame game, double newPi) {
        return clean(new AsteroidSmall(), game, newPi);
    }

    public static AsteroidSmall newAsteroidSmall(AsteroidGame game) {
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
        asteroidSmall.setPoints(100);
        return asteroidSmall;
    }

    public static AsteroidSmall clean(AsteroidSmall asteroidSmall, AsteroidGame game) {
        double pi = Utils.randDouble(2);
        return clean(asteroidSmall, game, pi);
    }



}
