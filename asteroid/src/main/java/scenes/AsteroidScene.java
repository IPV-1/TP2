package scenes;

import java.util.ArrayList;
import java.util.List;

import ship.Ship;

import asteroid.AsteroidGame;
import asteroids.Asteroid;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;

import components.BasicAsteroidComponent;
import components.Bullet;
import components.PoolManager;
import components.ShapeableMovingGameComponent;

public class AsteroidScene extends GameScene {

	protected List<ShapeableMovingGameComponent> enemyGroup = new ArrayList<ShapeableMovingGameComponent>();
	protected List<ShapeableMovingGameComponent> playerGroup = new ArrayList<ShapeableMovingGameComponent>();

	@Override
	public AsteroidGame getGame() {
		return (AsteroidGame) super.getGame();
	}

	public void updatePlayerComponent(ShapeableMovingGameComponent playerComp) {
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
		addShip();
		this.addComponent(this.getGame().BOARD);
		super.onSetAsCurrent();
	}

	private void addShip() {
		Ship ship = Ship.SHIP(getGame());
		this.getPlayerGroup().add(ship);
		this.addComponent(ship);
	}

	protected void addBackground() {
		addComponent(new BasicAsteroidComponent(getGame().getSprite(
				"background"), 0, 0));
	}

	public void addBullet(double x, double y, double angle) {
		Bullet bullet = PoolManager.getBullet(this.getGame(), x, y, angle);
		bullet.setX(x - bullet.getWidth() / 2);
		bullet.setY(y - bullet.getHeight() / 2);
		
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
		this.addAsteroid(PoolManager.getAsteroidL(this.getGame()));
	}

	public void addAsteroidM() {
		this.addAsteroid(PoolManager.getAsteroidM(this.getGame()));
	}

	public void addAsteroidS() {
		this.addAsteroid(PoolManager.getAsteroidS(this.getGame()));
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
	
	/*
	 * Por si el area de juego es mas chica que la pantalla
	 */
	public boolean isOutside(GameComponent<AsteroidScene> comp) {
		return (comp.getX() >= comp.getGame().getDisplayWidth()) || 
				(comp.getX() + comp.getWidth() <= 0) ||
				(comp.getY() >= comp.getGame().getDisplayHeight()) ||
				(comp.getY() + comp.getHeight() <= 0);
	}

	public List<ShapeableMovingGameComponent> getEnemyGroup() {
		return enemyGroup;
	}

	public List<ShapeableMovingGameComponent> getPlayerGroup() {
		return playerGroup;
	}

}
