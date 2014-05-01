package scenes;


import asteroid.AsteroidGame;
import asteroids.AsteroidLarge;
import asteroids.AsteroidMedium;
import asteroids.AsteroidSmall;

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
        addAsteroids();
        super.onSetAsCurrent();
    }

    public void addBackground() {
        addComponent(new BasicAsteroidComponent(getGame().getSprite("background"), 0, 0));
    }
    
    public void addAsteroids() {
    	for (int i = 0; i < 2; i++) {
    		this.addComponent(new AsteroidLarge());
		}
    	for (int i = 0; i < 3; i++) {
    		this.addComponent(new AsteroidMedium());
    	}
    	for (int i = 0; i < 4; i++) {
    		this.addComponent(new AsteroidSmall());
		}
    }
    
}
