package components;

import scenes.AsteroidScene;
import asteroid.AsteroidGame;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.MovingGameComponent;
import com.uqbar.vainilla.appearances.Appearance;

import config.Configuration;


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
    
    @Override
    public void update(DeltaState deltaState) {
    	if (this.getX() >= Configuration.getDisplayWidth()) {
			this.setX(1 - this.getWidth());
		} else if (this.getX() + this.getWidth() <= 0) {
			this.setX(Configuration.getDisplayWidth());
		}
		if (this.getY() >= Configuration.getDisplayHeight()) {
			this.setY(1 - this.getHeight());
		} else if (this.getY() + this.getHeight() <= 0) {
			this.setY(Configuration.getDisplayHeight());
		}
    	super.update(deltaState);
    }
    
}
