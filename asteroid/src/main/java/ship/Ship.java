package ship;

import utils.Vector2D;
import handlers.KeyboardHandler;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.UnitVector2D;
import com.uqbar.vainilla.appearances.Sprite;
import components.ShapeableMovingGameComponent;
import components.shapes.Circle;
import components.shapes.Shape;
import components.shapes.SimpleShape;

import config.Configuration;

public class Ship extends ShapeableMovingGameComponent {
	
	private double rotation = 0;
	private ShipState state = new ShipImmune();
	
	private double time = 0d;
	private boolean initialized = false;
		
	public Ship() {
		super();
		this.clean();
	}
	
	public Ship(boolean test) {
		super();
	}
	
	protected void explode() {}
	
	protected Ship clean() {
		KeyboardHandler.INSTANCE.reset();
		
		this.setState(new ShipImmune());
		time = 0d;
		initialized = false;
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
		
		this.getState().update(this, deltaState);
		
		if(time > 5 && !initialized ) {
			this.setState(new ShipWaiting());
			initialized = true;
		} else {
			time += deltaState.getDelta();
		}
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
		
		Vector2D velocity = new Vector2D(getUVector(), getSpeed());
		Vector2D aceleration = new Vector2D(new UnitVector2D(getDirection()), Configuration.getValue("shipAceleration") * delta);
		
		velocity.sum(aceleration);
		
		this.uVector = velocity.asUnitVector();
		this.setSpeed(velocity.getModule());
		
		if(this.getSpeed() > this.getMaxSpeed()) {
			this.setMaxSpeed();
		}
	}
	
	@Override
	public void destroy() {
		this.clean();
	}
	
	@Override
	public void collided() {
		this.getScene().lose();
	}

	public ShipState getState() {
		return state;
	}

	public void setState(ShipState state) {
		this.state = state;
		rotate();
	}
	
}
