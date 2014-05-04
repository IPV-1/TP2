package ship;

import utils.Utils;
import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;
import components.ShapeableMovingGameComponent;
import components.shapes.Circle;
import components.shapes.Shape;
import components.shapes.SimpleShape;

public class Ship extends ShapeableMovingGameComponent {
	
	private static Ship SHIP;
	
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
		this.getUVector().setPI(Utils.randDouble(2));
		this.setSpeed(0);
		this.setDestroyPending(false);
		
		this.setAppearance(this.getSprite(game));
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

}
