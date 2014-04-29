package components;

import asteroid.AsteroidGame;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import scenes.AsteroidScene;


public class BasicAsteroidComponent extends GameComponent<AsteroidScene> {

    public BasicAsteroidComponent(Appearance appearance, int x, int y) {
        super(appearance, x, y);
    }

    @Override
    public AsteroidGame getGame() {
        return (AsteroidGame) super.getGame();
    }
}
