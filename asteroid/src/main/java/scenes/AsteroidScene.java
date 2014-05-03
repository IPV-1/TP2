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
import components.Bullet;
import components.ShapeableMovingGameComponent;

public class AsteroidScene extends GameScene {

	protected List<ShapeableMovingGameComponent> enemyGroup = new ArrayList<ShapeableMovingGameComponent>();
	protected List<ShapeableMovingGameComponent> playerGroup = new ArrayList<ShapeableMovingGameComponent>();

	@Override
	public AsteroidGame getGame() {
		return (AsteroidGame) super.getGame();
	}

	public void update(ShapeableMovingGameComponent playerComp) {
		for (ShapeableMovingGameComponent enemyComp : this.getEnemyGroup()) {
			if (playerComp.isColliding(enemyComp)) {
				this.remove(playerComp, this.getPlayerGroup());
				this.remove(enemyComp, this.getEnemyGroup());
				break;
			}
		}
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

	public void addBullet(double x, double y, double pi) {
		Bullet bullet = Bullet.get(this.getGame(), x, y, pi);
		this.getPlayerGroup().add(bullet);
		this.addComponent(bullet);
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
		this.getEnemyGroup().add(a);
		this.addComponent(a);
	}

	protected void remove(ShapeableMovingGameComponent comp,
			List<ShapeableMovingGameComponent> fromList) {
		fromList.remove(comp);
		comp.destroy();
		this.removeComponent(comp);
	}

	public List<ShapeableMovingGameComponent> getEnemyGroup() {
		return enemyGroup;
	}

	public List<ShapeableMovingGameComponent> getPlayerGroup() {
		return playerGroup;
	}

}
