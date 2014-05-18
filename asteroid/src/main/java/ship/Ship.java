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
	private ShipState state = new ShipWaiting();
		
	public Ship() {
		super();
		this.clean();
	}
	
	protected void explode() {}
	
	protected Ship clean() {
		this.setRotation(0);
		this.setSpeed(0);
		this.setDestroyPending(false);
		
		this.rotate();
		
		this.setShape(this.shape());
		
		this.setX(Configuration.getDisplayWidth() / 2 - this.getWidth() / 2);
		this.setY(Configuration.getDisplayHeight() / 2 - this.getHeight() / 2);
		
		this.setZ(1);
		
		return this;
	}
	
	protected Sprite getSprite() {
		return this.getState().getSprite();
	}

	protected double getMaxSpeed() {
		return Configuration.getValue("shipMaxSpeed");
	}
	
	protected Shape shape() {
		SimpleShape shape = new Circle(this.getSprite().getWidth() - 15);
		shape.setComponent(this);
		return shape;
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		
		KeyboardHandler.INSTANCE.updateShip(this, deltaState);
		
		this.getScene().updatePlayerComponent(this);
	}

	public void setMaxSpeed() {
		this.setSpeed(this.getMaxSpeed());
		this.getUVector().setAngle(this.getDirection());
	}

	public void rotate(int direction, double delta) {
		this.setRotation(getRotation() + Configuration.getValue("shipRotation") * direction * delta);
        
		this.rotate();
	}
	
	public void rotate() {
		Sprite sprite = this.getSprite().rotate(getRotation());
		this.setAppearance(sprite);
	}

	public void shot() {
		this.getScene().addBullet(this.getCenterX(), this.getCenterY(), this.getDirection(), this);
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
		this.setSpeed(this.getSpeed() + getDeltaFriction(deltaState));
	}

	private double getDeltaFriction(DeltaState deltaState) {
		return this.getSpeed() * -deltaState.getDelta() * Configuration.getValue("shipFriction");
	}
	
	public void speedUp(double delta) {
		
		this.setSpeed(this.getSpeed() + Configuration.getValue("shipAceleration") * delta);
		
		if(this.getSpeed() > this.getMaxSpeed()) {
			this.setMaxSpeed();
		}

		this.getUVector().setAngle(this.getDirection());		
	}
	
	@Override
	public void destroy() {
		this.clean();
	}

	public ShipState getState() {
		return state;
	}

	public void setState(ShipState state) {
		this.state = state;
		rotate();
	}
	
}
