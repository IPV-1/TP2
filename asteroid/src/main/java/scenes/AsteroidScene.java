package scenes;

import java.util.ArrayList;
import java.util.List;

import asteroid.AsteroidGame;
import asteroids.Asteroid;
import asteroids.AsteroidLarge;
import asteroids.AsteroidMedium;
import asteroids.AsteroidSmall;

import com.uqbar.vainilla.GameScene;

import components.BasicAsteroidComponent;

public class AsteroidScene extends GameScene {

	public List<Asteroid> asteroids = new ArrayList<Asteroid>();

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
		addComponent(new BasicAsteroidComponent(getGame().getSprite(
				"background"), 0, 0));
	}

	public void addAsteroids() {
		for (int i = 0; i < this.getGame().getValue("asteroidLQty"); i++) {
			Asteroid a = new AsteroidLarge();
			asteroids.add(a);
			this.addComponent(a);
		}
		for (int i = 0; i < this.getGame().getValue("asteroidMQty"); i++) {
			Asteroid a = new AsteroidMedium();
			asteroids.add(a);
			this.addComponent(a);
		}
		for (int i = 0; i < this.getGame().getValue("asteroidSQty"); i++) {
			Asteroid a = new AsteroidSmall();
			asteroids.add(a);
			this.addComponent(a);
		}
	}

}
