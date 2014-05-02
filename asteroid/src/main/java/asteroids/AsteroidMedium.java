package asteroids;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidMedium extends Asteroid {

	public AsteroidMedium(AsteroidGame game){
		super(game);
	}
	
	public AsteroidMedium(AsteroidGame game, double x, double y) {
		super(game,x,y);
	}
	
	@Override
	protected Sprite getSprite(AsteroidGame game) {
		return game.getSprite("asteroidM");
	}

	@Override
	protected double getMaxSpeed(AsteroidGame game) {
		return game.getValue("asteroidMMaxSpeed");
	}
	
	@Override
	protected void destroyed() {
		double radius = this.getGame().getSprite("asteroidS").getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(new AsteroidSmall(this.getGame(),x,y));
		this.getScene().addAsteroid(new AsteroidSmall(this.getGame(),x,y));
	}

}
