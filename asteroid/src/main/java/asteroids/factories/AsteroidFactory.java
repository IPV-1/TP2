package asteroids.factories;


import asteroid.AsteroidGame;
import asteroids.AsteroidLarge;
import asteroids.estrategies.ExplodeToMediumAsteroids;
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


}
