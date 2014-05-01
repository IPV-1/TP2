package asteroids;

import java.awt.Color;

import utils.Utils;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Sprite;

import components.ShapeableMovingGameComponent;
import components.shapes.Circle;
import components.shapes.Shape;
import components.shapes.SimpleShape;

public abstract class Asteroid extends ShapeableMovingGameComponent {

	public Asteroid() {
		this.getUVector().setPI(Utils.randDouble(2));
		this.setAppearance(new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int)this.getSprite().getWidth()));//this.getSprite());
		this.setSpeed(Utils.randDouble(
				this.getGame().getValue("asteroidMinSpeed"), this.getMaxSpeed()));
		this.setShape(this.shape());
		
		this.setX(Utils.randDouble(this.getGame().getDisplayWidth()
				- this.getWidth() / 2));
		this.setY(Utils.randDouble(this.getGame().getDisplayHeight()
				- this.getHeight() / 2));
	}
	
	public Asteroid(double x, double y) {
		this();
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public AsteroidGame getGame() {
		return AsteroidGame.INSTANCE;
	}
	
	protected abstract Sprite getSprite();

	protected abstract double getMaxSpeed();
	
	protected abstract void destroyed();

	@Override
	public void update(DeltaState deltaState) {
		if (this.getX() >= this.getGame().getDisplayWidth()) {
			this.setX(1 - this.getWidth());
		} else if (this.getX() + this.getWidth() <= 0) {
			this.setX(this.getGame().getDisplayWidth());
		}
		if (this.getY() >= this.getGame().getDisplayHeight()) {
			this.setY(1 - this.getHeight());
		} else if (this.getY() + this.getHeight() <= 0) {
			this.setY(this.getGame().getDisplayHeight());
		}
		super.update(deltaState);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		this.destroyed();
	}
	
	public Shape shape() {
		SimpleShape shape = new Circle(this.getSprite().getWidth());
		shape.setComponent(this);
		return shape;
	}

}
