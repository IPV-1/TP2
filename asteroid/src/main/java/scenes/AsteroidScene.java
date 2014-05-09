package scenes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import asteroids.pools.AsteroidPools;
import asteroids.pools.BulletPool;
import com.uqbar.vainilla.appearances.Sprite;
import components.CollidableMovingGameComponent;
import components.shapes.Circle;
import ship.Ship;

import asteroid.AsteroidGame;
import asteroids.Asteroid;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;

import components.BasicAsteroidComponent;
import components.Bullet;

public class AsteroidScene extends GameScene {

    protected List<CollidableMovingGameComponent> enemyGroup = new ArrayList<CollidableMovingGameComponent>();
    protected List<CollidableMovingGameComponent> playerGroup = new ArrayList<CollidableMovingGameComponent>();

    @Override
    public AsteroidGame getGame() {
        return (AsteroidGame) super.getGame();
    }

    @Override
    public void takeStep(Graphics2D graphics2D) {
        super.takeStep(graphics2D);
        for (CollidableMovingGameComponent c : new ArrayList<CollidableMovingGameComponent>(getPlayerGroup()))
            update(c);

    }

    public void update(CollidableMovingGameComponent playerComp) {
        for (CollidableMovingGameComponent enemyComp : new ArrayList<CollidableMovingGameComponent>(getEnemyGroup())) {
            if (playerComp.isColliding(enemyComp)) {
                playerComp.collide(enemyComp);
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
        Sprite sprite = getGame().getSprite("ship");
        Circle shape = new Circle(sprite.getWidth());
        double x = getGame().getDisplayWidth() / 2 - shape.getDiameter() / 2;
        double y = getGame().getDisplayHeight() / 2 - shape.getDiameter() / 2;
        Ship ship = new Ship(sprite, shape, x, y, 1, 0, 0, getGame().getValue("shipRotation"), getGame().getValue("shipMaxSpeed"));
        ship.setZ(1);
        this.getPlayerGroup().add(ship);
        this.addComponent(ship);
    }

    protected void addBackground() {
        addComponent(new BasicAsteroidComponent(getGame().getSprite(
                "background"), 0, 0));
    }

    public void addBullet(double x, double y, double angle) {
        Bullet bullet = BulletPool.getInstance().get(getGame(), x, y, angle);
        bullet.setX(x - bullet.getWidth() / 2);
        bullet.setY(y - bullet.getHeight() / 2);
        getPlayerGroup().add(bullet);
        addComponent(bullet);
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
        this.addAsteroid(AsteroidPools.getInstance().getAsteroidLarge(this.getGame()));
    }

    public void addAsteroidM() {
        this.addAsteroid(AsteroidPools.getInstance().getAsteroidMedium(this.getGame()));
    }

    public void addAsteroidS() {
        this.addAsteroid(AsteroidPools.getInstance().getAsteroidSmall(this.getGame()));
    }

    public void addAsteroid(Asteroid a) {
        this.getEnemyGroup().add(a);
        a.setDestroyPending(false);
        this.addComponent(a);
    }

    public List<CollidableMovingGameComponent> getEnemyGroup() {
        return enemyGroup;
    }

    public List<CollidableMovingGameComponent> getPlayerGroup() {
        return playerGroup;
    }

    /*
     * Por si el area de juego es mas chica que la pantalla
     */
    public boolean isOutside(GameComponent<AsteroidScene> comp) {
        return (comp.getX() >= comp.getGame().getDisplayWidth()) ||
                (comp.getX() <= 0) ||
                (comp.getY() >= comp.getGame().getDisplayHeight()) ||
                (comp.getY() <= 0);
    }

}
