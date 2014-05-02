package asteroids;

import asteroid.AsteroidGame;

import com.uqbar.vainilla.appearances.Sprite;

public class AsteroidSmall extends Asteroid {

	public AsteroidSmall(AsteroidGame game){
		super(game);
	}
	
	public AsteroidSmall(AsteroidGame game, double x, double y) {
		super(game,x,y);
	}
	
	@Override
	protected Sprite getSprite(AsteroidGame game) {
		return game.getSprite("asteroidS");
	}

	@Override
	protected double getMaxSpeed(AsteroidGame game) {
		return game.getValue("asteroidSMaxSpeed");
	}
	
	@Override
	protected void destroyed() {
	}

}
