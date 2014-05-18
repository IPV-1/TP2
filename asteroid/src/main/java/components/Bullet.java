package components;

import ship.Ship;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.UnitVector2D;
import com.uqbar.vainilla.appearances.Sprite;
import components.shapes.Circle;
import components.shapes.SimpleShape;

import config.Configuration;

public class Bullet extends ShapeableMovingGameComponent {

	public Bullet() {
		Sprite sprite = Configuration.getSprite("bullet");
		this.setAppearance(sprite);
		//this.setAppearance(new com.uqbar.vainilla.appearances.Circle(Color.GREEN, (int) sprite.getWidth()));
		SimpleShape shape = new Circle(sprite.getWidth());
		this.setShape(shape);
		shape.setComponent(this);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		if (this.getScene().isOutside(this)) {
			this.destroy();
			return;
		}
		
		super.update(deltaState);
		this.getScene().updatePlayerComponent(this);
	}

	@Override
	public void destroy() {
		PoolManager.BULLETS.push(this);
		super.destroy();
	}

	public void reset(double x, double y, double angle) {
		this.setX(x);
		this.setY(y);
		this.getUVector().setAngle(angle);
		this.setSpeed(Configuration.getValue("bulletSpeed"));
		this.setDestroyPending(false);
	}

	public void applyShipModifier(Ship ship) {
		//Doing
		
//		double shipRelativeSpeed = ship.getSpeed() / this.getSpeed();
//		UnitVector2D uv = ship.getUVector();
//		this.getUVector().sum()
	}

}
