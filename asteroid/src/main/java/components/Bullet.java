package components;

import java.util.Stack;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Sprite;
import components.shapes.Circle;
import components.shapes.SimpleShape;

public class Bullet extends ShapeableMovingGameComponent {

	public static final Stack<Bullet> BULLETS = new Stack<Bullet>();

	protected Bullet(AsteroidGame game, double x, double y, double angle) {
		this.reset(game, x, y, angle);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		if (this.getScene().isOutside(this)) {
			this.destroy();
			return;
		}
		
		super.update(deltaState);
		this.getScene().update(this);
	}

	@Override
	public void destroy() {
		BULLETS.push(this);
		super.destroy();
	}

	public static Bullet get(AsteroidGame game, double x, double y, double angle) {
		Bullet bullet = BULLETS.empty() ? new Bullet(game, x, y, angle) : BULLETS.pop();
		bullet.reset(game, x, y, angle);
		bullet.setDestroyPending(false);
		return bullet;
	}

	private void reset(AsteroidGame game, double x, double y, double angle) {
		Sprite sprite = game.getSprite("bullet");
		this.setAppearance(sprite);
		//this.setAppearance(new com.uqbar.vainilla.appearances.Circle(Color.GREEN, (int) sprite.getWidth()));
		SimpleShape shape = new Circle(sprite.getWidth());
		this.setShape(shape);
		shape.setShapeable(this);
		this.setX(x);
		this.setY(y);
		this.getUVector().setAngle(angle);
		this.setSpeed(game.getValue("bulletSpeed"));
	}

}
