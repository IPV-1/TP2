package scenes;


import asteroid.AsteroidGame;
import com.uqbar.vainilla.GameScene;
import components.BasicAsteroidComponent;

public class AsteroidScene extends GameScene {

    @Override
    public AsteroidGame getGame() {
        return (AsteroidGame) super.getGame();
    }

    @Override
    public void onSetAsCurrent() {
        addBackground();
        super.onSetAsCurrent();
    }

    public void addBackground() {
        addComponent(new BasicAsteroidComponent(getGame().getSprite("background"), 0, 0));
    }
}
