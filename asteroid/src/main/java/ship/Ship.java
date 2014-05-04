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
	
	private static Ship SHIP;
	private double rotation = 0;
	
	public static Ship SHIP(AsteroidGame game) {
		if(SHIP == null) {
			SHIP = new Ship(game);
		}
		
		return SHIP;
	}
	
	private Ship(AsteroidGame game) {
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
		
		this.setZ(2);
		
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
		shape.setComponent(this);
		return shape;
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		
		KeyboardHandler.INSTANCE.updateShip(this, deltaState);
	}

	public void setMaxSpeed() {
		this.setSpeed(this.getMaxSpeed(getGame()));
	}

	public void rotate(AsteroidGame game, int direction) {
		this.setRotation(getRotation() + game.getValue("shipRotation") * direction);
		
        this.getUVector().setAngle(Math.toDegrees(this.getRotation()) + 90);
        
		Sprite sprite = this.getSprite(game).rotate(getRotation());
		this.setAppearance(sprite);
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

}
