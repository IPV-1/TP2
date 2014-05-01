package asteroids;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidLarge extends Asteroid {

	public AsteroidLarge(){
	}
	
	public AsteroidLarge(double x, double y) {
		super(x,y);
	}
	
	@Override
	protected Sprite getSprite() {
		return this.getGame().getSprite("asteroidL");
	}

	@Override
	protected double getMaxSpeed() {
		return this.getGame().getValue("asteroidLMaxSpeed");
	}

	@Override
	protected void destroyed() {
		double radius = this.getGame().getSprite("asteroidM").getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(new AsteroidMedium(x,y));
		this.getScene().addAsteroid(new AsteroidMedium(x,y));
	}

}
