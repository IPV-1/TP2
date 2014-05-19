package scenes;

import java.util.ArrayList;
import java.util.List;

import scenes.levels.Level1;
import scenes.statics.LoseScene;
import ship.Ship;
import asteroid.AsteroidGame;
import asteroids.Asteroid;
import boards.LivesBoard;
import boards.ScoreBoard;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import components.BasicAsteroidComponent;
import components.Bullet;
import components.PoolManager;
import components.ShapeableMovingGameComponent;

import config.Configuration;

public class AsteroidScene extends GameScene {

	protected List<ShapeableMovingGameComponent> enemyGroup = new ArrayList<ShapeableMovingGameComponent>();
	protected List<ShapeableMovingGameComponent> playerGroup = new ArrayList<ShapeableMovingGameComponent>();
	private List<Asteroid> ASTEROIDS = new ArrayList<Asteroid>();

	@Override
	public AsteroidGame getGame() {
		return (AsteroidGame) super.getGame();
	}

	public void updatePlayerComponent(ShapeableMovingGameComponent playerComp) {
		for (ShapeableMovingGameComponent enemyComp : this.getEnemyGroup()) {
			if (playerComp.isColliding(enemyComp)) {
				this.remove(enemyComp, this.getEnemyGroup());
				this.removeAsteroid(enemyComp);
				this.remove(playerComp, this.getPlayerGroup());
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
		this.addComponent(this.getGame().LIVES);
		super.onSetAsCurrent();
	}

	private void addShip() {
		Ship ship = new Ship();
		this.getPlayerGroup().add(ship);
		this.addComponent(ship);
	}

	protected void addBackground() {
		addComponent(new BasicAsteroidComponent(getGame().getSprite(
				"background"), 0, 0));
	}

	public void addBullet(double x, double y, double angle, Ship ship) {
		if(PoolManager.bulletAvailable()) {
			Bullet bullet = PoolManager.getBullet(x, y, angle, ship);
			bullet.setX(x - bullet.getWidth() / 2);
			bullet.setY(y - bullet.getHeight() / 2);
			
			this.getPlayerGroup().add(bullet);
			this.addComponent(bullet);
		}
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
		this.addAsteroid(PoolManager.getAsteroidL());
	}

	public void addAsteroidM() {
		this.addAsteroid(PoolManager.getAsteroidM());
	}

	public void addAsteroidS() {
		this.addAsteroid(PoolManager.getAsteroidS());
	}

	public void addAsteroid(Asteroid a) {
		this.getEnemyGroup().add(a);
		this.ASTEROIDS.add(a);
		this.addComponent(a);
	}
	
	public void removeAsteroid(ShapeableMovingGameComponent enemyComp) {
		ASTEROIDS.remove(enemyComp);
		if(ASTEROIDS.isEmpty()) {
			win();
		}
	}

	protected void remove(ShapeableMovingGameComponent comp, List<ShapeableMovingGameComponent> fromList) {
		fromList.remove(comp);
		comp.collided();
//		this.removeComponent(comp);
	}
	
	/*
	 * Por si el area de juego es mas chica que la pantalla
	 */
	public boolean isOutside(GameComponent<AsteroidScene> comp) {
		return (comp.getX() >= Configuration.getDisplayWidth()) || 
				(comp.getX() + comp.getWidth() <= 0) ||
				(comp.getY() >= Configuration.getDisplayHeight()) ||
				(comp.getY() + comp.getHeight() <= 0);
	}
	
	public void releaseComponents() {
		for(ShapeableMovingGameComponent comp : this.getEnemyGroup()) {
			comp.destroy();
		}
		for(ShapeableMovingGameComponent comp : this.getPlayerGroup()) {
			comp.destroy();
		}
	}
	
    public void win() {
    	this.releaseComponents();
        this.getGame().setCurrentScene(new Level1());
    }
    
    public void lose() {
    	this.getLivesBoard().die();

    	if (this.getLivesBoard().lose()) {
    		this.getScoreBoard().reset();
    		this.getLivesBoard().reset();
    		this.getGame().setCurrentScene(new LoseScene());
    	} else {
    		this.getGame().setCurrentScene(new Level1());
    	}
    }

	private ScoreBoard getScoreBoard() {
		return this.getGame().BOARD;
	}

	private LivesBoard getLivesBoard() {
		return this.getGame().LIVES;
	}

	public List<ShapeableMovingGameComponent> getEnemyGroup() {
		return enemyGroup;
	}

	public List<ShapeableMovingGameComponent> getPlayerGroup() {
		return playerGroup;
	}

}
