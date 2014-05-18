package components;

import java.util.Stack;

import ship.Ship;

import config.Configuration;

import asteroids.AsteroidLarge;
import asteroids.AsteroidMedium;
import asteroids.AsteroidSmall;

public class PoolManager {

	public static final Stack<Bullet> BULLETS = new Stack<Bullet>();

	public static final Stack<AsteroidLarge> ASTEROIDS_L = new Stack<AsteroidLarge>();
	public static final Stack<AsteroidMedium> ASTEROIDS_M = new Stack<AsteroidMedium>();
	public static final Stack<AsteroidSmall> ASTEROIDS_S = new Stack<AsteroidSmall>();

	static {
		for (int i = 0; i < Configuration.getValue("bulletQty"); i++) {
			BULLETS.add(new Bullet());
		}
	}

	public static Bullet getBullet(double x, double y, double angle, Ship ship) {
		Bullet bullet;
		if (!BULLETS.empty()) {
			bullet = BULLETS.pop();
			bullet.reset(x, y, angle);
			bullet.applyShipModifier(ship);
		} else {
			bullet = null;
		}
		return bullet;
	}

	public static boolean bulletAvailable() {
		return !BULLETS.empty();
	}

	public static AsteroidLarge getAsteroidL() {
		return (AsteroidLarge) (ASTEROIDS_L.empty() ? new AsteroidLarge()
				: ASTEROIDS_L.pop().reset());
	}

	public static AsteroidMedium getAsteroidM() {
		return (AsteroidMedium) (ASTEROIDS_M.empty() ? new AsteroidMedium()
				: ASTEROIDS_M.pop().reset());
	}

	public static AsteroidSmall getAsteroidS() {
		return (AsteroidSmall) (ASTEROIDS_S.empty() ? new AsteroidSmall()
				: ASTEROIDS_S.pop().reset());
	}

	public static AsteroidMedium getAsteroidM(double x, double y, double pi) {
		return (AsteroidMedium) PoolManager.getAsteroidM().setXYPI(x, y, pi);
	}

	public static AsteroidSmall getAsteroidS(double x, double y, double pi) {
		return (AsteroidSmall) PoolManager.getAsteroidS().setXYPI(x, y, pi);
	}

}
