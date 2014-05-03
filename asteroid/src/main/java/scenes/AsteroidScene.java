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

	protected List<Asteroid> asteroids = new ArrayList<Asteroid>();
	
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

	protected void addBackground() {
		addComponent(new BasicAsteroidComponent(getGame().getSprite(
				"background"), 0, 0));
	}

	protected void addAsteroids() {
		for (int i = 0; i < this.getGame().getValue("asteroidLQty"); i++) {
			this.addAsteroidL();
		}
		for (int i = 0; i < this.getGame().getValue("asteroidMQty"); i++) {
			this.addAsteroidM();
		}
		for (int i = 0; i < this.getGame().getValue("asteroidSQty"); i++) {
			this.addAsteroidS();
		}
	}
	
	public void addAsteroidL() {
		this.addAsteroid(AsteroidLarge.get(this.getGame()));
	}
	
	public void addAsteroidM() {
		this.addAsteroid(AsteroidMedium.get(this.getGame()));
	}

	public void addAsteroidS() {
		this.addAsteroid(AsteroidSmall.get(this.getGame()));
	}
	
	public void addAsteroid(Asteroid a) {
		this.getAsteroids().add(a);
		this.addComponent(a);
	}
	
	public void removeAsteroid(Asteroid a) {
		this.getAsteroids().remove(a);
		a.destroy();
		this.removeComponent(a);
	}
	
	public List<Asteroid> getAsteroids() {
		return asteroids;
	}

}
