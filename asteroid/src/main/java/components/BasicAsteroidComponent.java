package components;

import asteroid.AsteroidGame;
import com.uqbar.vainilla.GameComponent;
import scenes.AsteroidScene;


public class BasicAsteroidComponent extends GameComponent<AsteroidScene> {

    @Override
    public AsteroidGame getGame() {
        return (AsteroidGame) super.getGame();
    }
}
