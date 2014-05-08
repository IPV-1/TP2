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
	
	protected double pi;
	
	protected Asteroid(AsteroidGame game, double pi) {
		this.reset(game);
		this.setAppearance(new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int)this.getSprite(game).getWidth()));
//		this.setAppearance(this.getSprite(game));
		this.setShape(this.shape(game));
		this.setPi(pi);
	}

	protected Asteroid(AsteroidGame game) {
		this(game, Utils.randDouble(2));
	}
	
	protected abstract Sprite getSprite(AsteroidGame game);

	protected abstract double getMaxSpeed(AsteroidGame game);
	
	protected abstract Asteroid getInnerAsteroid(double x, double y, double pi);
	
	protected void explode() {
		double radius = this.getSprite(this.getGame()).getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(this.getInnerAsteroid(x, y, getNewPiFrom(this.getGame(), this.getPi())));
		this.getScene().addAsteroid(this.getInnerAsteroid(x, y, getNewPiFrom(this.getGame(), this.getPi())));
	}
	
	public abstract void store();
	
	public abstract int getPoints();
	
	public Asteroid reset(AsteroidGame game) {
		this.setSpeed(Utils.randDouble(
				game.getValue("asteroidMinSpeed"), this.getMaxSpeed(game)));
		this.setX(Utils.randDouble(game.getDisplayWidth()
				- this.getWidth() / 2));
		this.setY(Utils.randDouble(game.getDisplayHeight()
				- this.getHeight() / 2));
		this.setDestroyPending(false);
		return this;
	}
	
	protected static double getNewPiFrom(AsteroidGame game, double pi) {
		double piExp = game.getValue("asteroidPiExplosion");
		return Utils.randDouble(pi - piExp, pi + piExp);
	}
		
	@Override
	public void destroy() {
		this.getScene().getGame().BOARD.add(this.getPoints());
		this.store();
		this.explode();
		super.destroy();
	}
	
	protected Shape shape(AsteroidGame game) {
		SimpleShape shape = new Circle(this.getSprite(game).getWidth());
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
