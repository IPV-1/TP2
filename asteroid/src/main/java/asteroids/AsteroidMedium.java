package asteroids;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidMedium extends Asteroid {

	public AsteroidMedium(){
	}
	
	public AsteroidMedium(double x, double y) {
		super(x,y);
	}
	
	@Override
	protected Sprite getSprite() {
		return this.getGame().getSprite("asteroidM");
	}

	@Override
	protected double getMaxSpeed() {
		return this.getGame().getValue("asteroidMMaxSpeed");
	}
	
	@Override
	protected void destroyed() {
		double radius = this.getGame().getSprite("asteroidS").getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(new AsteroidSmall(x,y));
		this.getScene().addAsteroid(new AsteroidSmall(x,y));
	}

}
