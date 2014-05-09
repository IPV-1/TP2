package asteroids.pools;


import asteroid.AsteroidGame;
import com.uqbar.vainilla.appearances.Sprite;
import components.Bullet;
import components.shapes.Circle;
import components.shapes.SimpleShape;

import java.util.Stack;

public class BulletPool {

    private static Stack<Bullet> pool = new Stack<Bullet>();

    public void push(Bullet bullet) {
        getPool().push(bullet);
    }

    public boolean empty() {
        return getPool().empty();
    }

    public Bullet pop() {
        return getPool().pop();
    }

    public Bullet get(AsteroidGame game, double x, double y, double angle) {
        Bullet bullet;
        if (empty())
            bullet = new Bullet();
        else
            bullet = pop();
        reset(bullet, game, x, y, angle);
        bullet.setDestroyPending(false);
        return bullet;
    }

    public void reset(Bullet bullet, AsteroidGame game, double x, double y, double angle) {
        Sprite sprite = game.getSprite("bullet");
        bullet.setAppearance(sprite);
        //this.setAppearance(new com.uqbar.vainilla.appearances.Circle(Color.GREEN, (int) sprite.getWidth()));
        SimpleShape shape = new Circle(sprite.getWidth());
        bullet.setShape(shape);
        shape.setShapeable(bullet);
        bullet.setX(x);
        bullet.setY(y);
        bullet.getUVector().setAngle(angle);
        bullet.setSpeed(game.getValue("bulletSpeed"));
    }

    public static Stack<Bullet> getPool() {
        return pool;
    }

    private static BulletPool ourInstance = new BulletPool();

    public static BulletPool getInstance() {
        return ourInstance;
    }

    private BulletPool() {
    }
}
