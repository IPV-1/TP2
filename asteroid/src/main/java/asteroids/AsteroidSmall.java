package asteroids;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidSmall extends Asteroid {

	public AsteroidSmall(){
	}
	
	public AsteroidSmall(double x, double y) {
		super(x,y);
	}
	
	@Override
	protected Sprite getSprite() {
		return this.getGame().getSprite("asteroidS");
	}

	@Override
	protected double getMaxSpeed() {
		return this.getGame().getValue("asteroidSMaxSpeed");
	}
	
	@Override
	protected void destroyed() {
	}

}
