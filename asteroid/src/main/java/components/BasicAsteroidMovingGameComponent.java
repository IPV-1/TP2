package components;

import asteroid.AsteroidGame;
import com.uqbar.vainilla.MovingGameComponent;
import com.uqbar.vainilla.appearances.Appearance;

import scenes.AsteroidScene;


public class BasicAsteroidMovingGameComponent extends MovingGameComponent<AsteroidScene> {

    public BasicAsteroidMovingGameComponent() {
        super();
    }

    public BasicAsteroidMovingGameComponent(Appearance appearance, double xPos,
                                            double yPos, double xVec, double yVec, double speed) {
        super(appearance, xPos, yPos, xVec, yVec, speed);
    }

    public BasicAsteroidMovingGameComponent(double xPos, double yPos,
                                            double xVec, double yVec, double speed) {
        super(xPos, yPos, xVec, yVec, speed);
    }

    public BasicAsteroidMovingGameComponent(double x, double y) {
        super(x, y);
    }

    @Override
    public AsteroidGame getGame() {
        return (AsteroidGame) super.getGame();
    }
}
