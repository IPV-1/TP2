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
		this.cleanWithPi(game, pi);
		this.setAppearance(new com.uqbar.vainilla.appearances.Circle(Color.BLUE, (int)this.getSprite(game).getWidth()));//this.getSprite(game));
		this.setShape(this.shape(game));
	}

	protected Asteroid(AsteroidGame game) {
		this(game, Utils.randDouble(2));
	}
	
	protected abstract Sprite getSprite(AsteroidGame game);

	protected abstract double getMaxSpeed(AsteroidGame game);
	
	protected abstract void explode();
	
	public abstract void store();
	
	public abstract int getPoints();
	
	protected Asteroid clean(AsteroidGame game) {
		return this.cleanWithPi(game, Utils.randDouble(2));
	}
	
	protected Asteroid cleanWithPi(AsteroidGame game, double pi) {
		this.setPi(pi);
		this.getUVector().setPI(this.getPi());
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
		shape.setShapeable(this);
		return shape;
	}
	
	protected double getPi() {
		return this.pi;
	}
	
	protected void setPi(double pi){ 
		this.pi = pi;
	}

}
