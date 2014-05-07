package components;

import java.util.Stack;

import asteroid.AsteroidGame;
import asteroids.AsteroidLarge;
import asteroids.AsteroidMedium;
import asteroids.AsteroidSmall;

public class PoolManager {

	public static final Stack<Bullet> BULLETS = new Stack<Bullet>();

	public static final Stack<AsteroidLarge> ASTEROIDS_L = new Stack<AsteroidLarge>();
	public static final Stack<AsteroidMedium> ASTEROIDS_M = new Stack<AsteroidMedium>();
	public static final Stack<AsteroidSmall> ASTEROIDS_S = new Stack<AsteroidSmall>();

	public static Bullet getBullet(AsteroidGame game, double x, double y,
			double angle) {
		Bullet bullet = BULLETS.empty() ? new Bullet(game) : BULLETS.pop();
		bullet.reset(game, x, y, angle);
		return bullet;
	}

	public static AsteroidLarge getAsteroidL(AsteroidGame game) {
		return (AsteroidLarge) (ASTEROIDS_L.empty() ? new AsteroidLarge(game)
				: ASTEROIDS_L.pop().reset(game));
	}

	public static AsteroidMedium getAsteroidM(AsteroidGame game) {
		return (AsteroidMedium) (ASTEROIDS_M.empty() ? new AsteroidMedium(game)
				: ASTEROIDS_M.pop().reset(game));
	}

	public static AsteroidSmall getAsteroidS(AsteroidGame game) {
		return (AsteroidSmall) (ASTEROIDS_S.empty() ? new AsteroidSmall(game)
				: ASTEROIDS_S.pop().reset(game));
	}

	public static AsteroidMedium getAsteroidM(AsteroidGame game, double x,
			double y, double pi) {
		return (AsteroidMedium) PoolManager.getAsteroidM(game)
				.setXYPI(x, y, pi);
	}

	public static AsteroidSmall getAsteroidS(AsteroidGame game, double x,
			double y, double pi) {
		return (AsteroidSmall) PoolManager.getAsteroidS(game).setXYPI(x, y, pi);
	}

}
