package asteroids;

import com.uqbar.vainilla.appearances.Appearance;
import utils.Utils;

import asteroid.AsteroidGame;

import components.ShapeableMovingGameComponent;
import components.shapes.Shape;
public abstract class Asteroid extends ShapeableMovingGameComponent {
	
	protected double pi;

	public Asteroid(Appearance appearance, Shape shape, double x,double y, double pi, double speed){
		setPi(pi);
		getUVector().setPI(getPi());
		setSpeed(speed);
		setX(x);
		setY(y);
		setAppearance(appearance);
		setShape(shape);
		shape.setShapeable(this);
	}

	public Asteroid() {
		super();
	}
	
	protected abstract void explode();
	
	public abstract void store();
	
	public abstract int getPoints();
	
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
	
	public double getPi() {
		return this.pi;
	}

	public void setPi(double pi){
		this.pi = pi;
	}

}
