package asteroids;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidLarge extends Asteroid {

	public AsteroidLarge(AsteroidGame game){
		super(game);
	}
	
	public AsteroidLarge(AsteroidGame game, double x, double y) {
		super(game,x,y);
	}
	
	@Override
	protected Sprite getSprite(AsteroidGame game) {
		return game.getSprite("asteroidL");
	}

	@Override
	protected double getMaxSpeed(AsteroidGame game) {
		return game.getValue("asteroidLMaxSpeed");
	}

	@Override
	protected void destroyed() {
		double radius = this.getGame().getSprite("asteroidM").getWidth() / 2;
		double x = this.getX() + this.getWidth() / 2 - radius / 2;
		double y = this.getY() + this.getHeight() / 2 - radius / 2;
		this.getScene().addAsteroid(new AsteroidMedium(this.getGame(),x,y));
		this.getScene().addAsteroid(new AsteroidMedium(this.getGame(),x,y));
	}

}
