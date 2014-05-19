package asteroids;

import utils.Utils;

import com.uqbar.vainilla.appearances.Sprite;
import components.ShapeableMovingGameComponent;
import components.shapes.Circle;
import components.shapes.Shape;
import components.shapes.SimpleShape;

import config.Configuration;

public abstract class Asteroid extends ShapeableMovingGameComponent {
	
	protected double pi;
	
	protected Asteroid(double pi) {
		this.reset();
//		this.setAppearance(new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int)this.getSprite().getWidth()));
		this.setAppearance(this.getSprite());
		this.setShape(this.shape());
		this.setPi(pi);
	}

	protected Asteroid() {
		this(Utils.randDouble(2));
	}
	
	protected abstract Sprite getSprite();

	protected abstract double getMaxSpeed();
	
	protected abstract Asteroid getInnerAsteroid(double x, double y, double pi);
	
	protected void explode() {
		double radius = this.getSprite().getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(this.getInnerAsteroid(x, y, Asteroid.getNewPiFrom(this.getPi())));
		this.getScene().addAsteroid(this.getInnerAsteroid(x, y, Asteroid.getNewPiFrom(this.getPi())));
	}
	
	public abstract void store();
	
	public abstract int getPoints();
	
	public Asteroid reset() {
		this.setSpeed(Utils.randDouble(
				Configuration.getValue("asteroidMinSpeed"), this.getMaxSpeed()));
		this.setX(Utils.randDouble(Configuration.getDisplayWidth()
				- this.getWidth() / 2));
		this.setY(Utils.randDouble(Configuration.getDisplayHeight()
				- this.getHeight() / 2));
		this.setDestroyPending(false);
		return this;
	}
	
	protected static double getNewPiFrom(double pi) {
		double piExp = Configuration.getValue("asteroidPiExplosion");
		return Utils.randDouble(pi - piExp, pi + piExp);
	}
		
	@Override
	public void destroy() {
		this.getScene().getGame().BOARD.add(this.getPoints());
		this.store();
		this.explode();
		super.destroy();
	}
	
	protected Shape shape() {
		SimpleShape shape = new Circle(this.getSprite().getWidth());
		shape.setComponent(this);
		return shape;
	}
	
	public Asteroid setXYPI(double x, double y, double pi) {
		this.setX(x);
		this.setY(y);
		this.setPi(pi);
		return this;
	}
	
	public Asteroid setPi(double pi){ 
		this.pi = pi;
		this.getUVector().setPI(this.getPi());
		return this;
	}
	
	protected double getPi() {
		return this.pi;
	}

}
