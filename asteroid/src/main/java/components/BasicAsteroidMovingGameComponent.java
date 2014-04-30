package components;

import asteroid.AsteroidGame;
import com.uqbar.vainilla.MovingGameComponent;
import scenes.AsteroidScene;


public class BasicAsteroidMovingGameComponent extends MovingGameComponent<AsteroidScene> {

    public BasicAsteroidMovingGameComponent(int x, int y) {
        super(x, y);
    }

    @Override
    public AsteroidGame getGame() {
        return (AsteroidGame) super.getGame();
    }
}
