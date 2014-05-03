package asteroids;

import java.awt.Color;

import utils.Utils;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;

import components.ShapeableMovingGameComponent;
import components.shapes.Circle;
import components.shapes.Shape;
import components.shapes.SimpleShape;

public abstract class Asteroid extends ShapeableMovingGameComponent {

	public Asteroid(AsteroidGame game) {
		this.clean(game);
		this.setAppearance(new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int)this.getSprite(game).getWidth()));//this.getSprite(game));
		this.setShape(this.shape(game));
		
		this.setX(Utils.randDouble(game.getDisplayWidth()
				- this.getWidth() / 2));
		this.setY(Utils.randDouble(game.getDisplayHeight()
				- this.getHeight() / 2));
	}
	
	public Asteroid(AsteroidGame game, double x, double y) {
		this(game);
		this.setX(x);
		this.setY(y);
	}
	
	protected abstract Sprite getSprite(AsteroidGame game);

	protected abstract double getMaxSpeed(AsteroidGame game);
	
	protected abstract void explode();
	
	public abstract void store();
	
	protected Asteroid clean(AsteroidGame game) {
		this.getUVector().setPI(Utils.randDouble(2));
		this.setSpeed(Utils.randDouble(
				game.getValue("asteroidMinSpeed"), this.getMaxSpeed(game)));
		this.setDestroyPending(false);
		return this;
	}
	
	@Override
	public void destroy() {
		this.store();
		this.explode();
		super.destroy();
	}
	
	protected Shape shape(AsteroidGame game) {
		SimpleShape shape = new Circle(this.getSprite(game).getWidth());
		shape.setComponent(this);
		return shape;
	}

}
