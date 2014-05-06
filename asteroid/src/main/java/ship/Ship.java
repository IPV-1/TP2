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

	public Ship(AsteroidGame game) {
		this.clean(game);
	}
	
	protected void explode() {
	}
	
	protected Ship clean(AsteroidGame game) {
		this.setSpeed(0);
		this.setDestroyPending(false);
		
		this.rotate(game, 0);
		
		this.setShape(this.shape(game));
		
		this.setX(game.getDisplayWidth() / 2 - this.getWidth() / 2);
		this.setY(game.getDisplayHeight() / 2 - this.getHeight() / 2);
		
		this.setZ(1);
		
		return this;
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

	public void rotate(AsteroidGame game, int direction) {
		this.setRotation(getRotation() + game.getValue("shipRotation") * direction);
		
        this.getUVector().setAngle(this.getDirection());
        
		Sprite sprite = this.getSprite(game).rotate(getRotation());
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
