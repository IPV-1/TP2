package ship;

import handlers.KeyboardHandler;
import asteroid.AsteroidGame;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Sprite;
import components.ShapeableMovingGameComponent;
import components.shapes.Circle;
import components.shapes.Shape;
import components.shapes.SimpleShape;

public class Ship extends ShapeableMovingGameComponent {

	private double rotation = 0;
	private double rotationSpeed;


	public Ship(Sprite appearance, Shape shape, double x, double y, int xV, int yV, int speed, double rotationSpeed){
		super(appearance, shape, x, y, xV, yV, speed);
		setRotationSpeed(rotationSpeed);
		initRotation();
	}

	public void initRotation(){
		getUVector().setAngle(getDirection());
		Sprite sprite = getAppearance().rotate(getRotation());
		setAppearance(sprite);
	}
	
	protected void explode() {
	}

	public Sprite getAppearance(){
		return (Sprite) super.getAppearance();
	}

	
	protected Sprite getSprite(AsteroidGame game) {
		return game.getSprite("ship");
	}

	protected double getMaxSpeed(AsteroidGame game) {
		return game.getValue("shipMaxSpeed");
	}
	
	protected Shape shape(AsteroidGame game) {
		SimpleShape shape = new Circle(this.getSprite(game).getWidth());
		shape.setShapeable(this);
		return shape;
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		
		KeyboardHandler.INSTANCE.updateShip(this, deltaState);
		
		//this.getScene().update(this);
	}

	public void setMaxSpeed() {
		this.setSpeed(this.getMaxSpeed(getGame()));
	}

	public void rotate(int direction) {
		this.setRotation(getRotation() + getRotationSpeed() * direction);
		
        this.getUVector().setAngle(this.getDirection());
        
		Sprite sprite = this.getSprite(getGame()).rotate(getRotation());
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

	public double getRotationSpeed() {
		return rotationSpeed;
	}

	public void setRotationSpeed(double rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}
}
