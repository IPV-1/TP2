package components;

import java.awt.Color;
import java.util.Stack;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Sprite;
import components.shapes.Circle;
import components.shapes.SimpleShape;

import asteroid.AsteroidGame;

public class Bullet extends ShapeableMovingGameComponent {

	public static final Stack<Bullet> BULLETS = new Stack<Bullet>();

	protected Bullet(AsteroidGame game, double x, double y, double pi) {
		Sprite sprite = game.getSprite("bullet");
		this.setAppearance(new com.uqbar.vainilla.appearances.Circle(
				Color.GREEN, (int) sprite.getWidth()));// sprite);
		SimpleShape shape = new Circle(sprite.getWidth());
		this.setShape(shape);
		shape.setComponent(this);
		this.setX(x);
		this.setY(y);
		this.getUVector().setPI(pi);
		this.setSpeed(game.getValue("bulletSpeed"));
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.getScene().update(this);
	}

	@Override
	public void destroy() {
		BULLETS.push(this);
		super.destroy();
	}

	public static Bullet get(AsteroidGame game, double x, double y, double pi) {
		Bullet bullet = BULLETS.empty() ? new Bullet(game, x, y, pi) : BULLETS
				.pop();
		bullet.setDestroyPending(false);
		return bullet;
	}

}
