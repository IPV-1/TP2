package ship;

import handlers.KeyboardHandler;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Sprite;
import components.ShapeableMovingGameComponent;
import components.shapes.Circle;
import components.shapes.Shape;
import components.shapes.SimpleShape;

import config.Configuration;

public class Ship extends ShapeableMovingGameComponent {
	
	private double rotation = 0;
		
	public Ship() {
		super();
		this.clean();
	}
	
	protected void explode() {}
	
	protected Ship clean() {
		this.setSpeed(0);
		this.setDestroyPending(false);
		
		this.rotate(0);
		
		this.setShape(this.shape());
		
		this.setX(Configuration.getDisplayWidth() / 2 - this.getWidth() / 2);
		this.setY(Configuration.getDisplayHeight() / 2 - this.getHeight() / 2);
		
		this.setZ(1);
		
		return this;
	}
	
	protected Sprite getSprite() {
		return Configuration.getSprite("ship");
	}

	protected double getMaxSpeed() {
		return Configuration.getValue("shipMaxSpeed");
	}
	
	protected Shape shape() {
		SimpleShape shape = new Circle(this.getSprite().getWidth());
		shape.setComponent(this);
		return shape;
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		
		KeyboardHandler.INSTANCE.updateShip(this, deltaState);
		
		//this.getScene().update(this);
	}

	public void setMaxSpeed() {
		this.setSpeed(this.getMaxSpeed());
		this.getUVector().setAngle(this.getDirection());
	}

	public void rotate(int direction) {
		this.setRotation(getRotation() + Configuration.getValue("shipRotation") * direction);
        
		Sprite sprite = this.getSprite().rotate(getRotation());
		this.setAppearance(sprite);
	}

	public void shot() {
		this.getScene().addBullet(this.getCenterX(), this.getCenterY(), this.getDirection());
	}
	
	private double getCenterX() {
		return this.getX() + this.getWidth() / 2;
	}
	
	private double getCenterY() {
		return this.getY() + this.getHeight() / 2;
	}
	
	private double getDirection() {
		return Math.toDegrees(this.getRotation()) + 90;
	}
	
	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public void breakingSpeed(DeltaState deltaState) {
		this.setSpeed(this.getSpeed() - deltaState.getDelta() * 10);
	}

}
