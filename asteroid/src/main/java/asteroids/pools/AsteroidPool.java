package asteroids.pools;

import asteroid.AsteroidGame;
import asteroids.Asteroid;


import java.util.Stack;

public abstract class AsteroidPool<AsteroidClass extends Asteroid> {
	public Stack<AsteroidClass> asteroids = new Stack<AsteroidClass>();

	public abstract AsteroidClass get(AsteroidGame game, double pi);

	public abstract AsteroidClass get(AsteroidGame game, double x, double y, double fromPi);

	public Stack<AsteroidClass> getAsteroids() {
		return asteroids;
	}

	public void setAsteroids(Stack<AsteroidClass> asteroids) {
		this.asteroids = asteroids;
	}

	public void push(AsteroidClass asteroid){
		getAsteroids().push(asteroid);
	}
}
