package components;

import ship.Ship;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Sprite;
import components.shapes.Circle;
import components.shapes.SimpleShape;

import config.Configuration;

public class Bullet extends ShapeableMovingGameComponent {

	public Bullet() {
		Sprite sprite = Configuration.getSprite("bullet");
		this.setAppearance(sprite);
		SimpleShape shape = new Circle(sprite.getWidth());
		this.setShape(shape);
		shape.setComponent(this);
	}
	
	public Bullet(boolean test) {
		super();
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
		double difPi = this.applyAngleModifier(ship);
		this.applySpeedModifier(ship.getSpeed(), difPi);
	}
	
	protected double applyAngleModifier(Ship ship) {
		double shipPi = ship.getUVector().getPi() % 2;
		double bulletPi = this.getUVector().getPi() % 2;
		double minPi = Math.min(shipPi, bulletPi);
		double maxPi = Math.max(shipPi, bulletPi);
		double difPi = (maxPi - minPi) / 2;
		boolean bulletFaster = this.getSpeed() > ship.getSpeed();
		if(difPi == 0.5 || difPi == 0) {
			if(!bulletFaster) {
				this.getUVector().setPI(shipPi);
			}
			return difPi * 2;
		}
		boolean piAdds = difPi < 1;
		double newPi = piAdds ? difPi + minPi : difPi + maxPi;
		
		double maxSpeed = bulletFaster ? this.getSpeed() : ship.getSpeed();
		double minSpeed = bulletFaster ? ship.getSpeed() : this.getSpeed();
		double timesFaster = maxSpeed / minSpeed;
		double piOffset = 1 / timesFaster;
		double fasterPi = bulletFaster ? bulletPi : shipPi;
		
		piOffset = (newPi - fasterPi) * piOffset;
		newPi = fasterPi + piOffset;
		
		this.getUVector().setPI(newPi);
		return difPi * 2;
	}
	
	protected void applySpeedModifier(double shipSpeed, double difPi) {
		this.setSpeed(this.getSpeed() + (shipSpeed * (1 - difPi * 2)));
	}

}
