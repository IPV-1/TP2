package components;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.DeltaState;
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
    
    @Override
    public void update(DeltaState deltaState) {
    	if (this.getX() >= this.getGame().getDisplayWidth()) {
			this.setX(1 - this.getWidth());
		} else if (this.getX() + this.getWidth() <= 0) {
			this.setX(this.getGame().getDisplayWidth());
		}
		if (this.getY() >= this.getGame().getDisplayHeight()) {
			this.setY(1 - this.getHeight());
		} else if (this.getY() + this.getHeight() <= 0) {
			this.setY(this.getGame().getDisplayHeight());
		}
    	super.update(deltaState);
    }
    
}
