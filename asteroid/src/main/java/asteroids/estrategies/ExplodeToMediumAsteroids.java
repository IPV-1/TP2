package asteroids.estrategies;

import asteroids.pools.AsteroidPools;

/**
 * This class is stateless, so i made it singleton.
 */
public class ExplodeToMediumAsteroids implements ExplodeStrategy {

    private static ExplodeToMediumAsteroids ourInstance = new ExplodeToMediumAsteroids();

    public static ExplodeToMediumAsteroids getInstance() {
        return ourInstance;
    }

    private ExplodeToMediumAsteroids() {
    }


    @Override
    public void explode(Exploitable exploitable) {
        double radius = exploitable.getGame().getSprite("asteroidM").getWidth() / 2;
        double x = exploitable.getX() + exploitable.getWidth() / 2 - radius / 2;
        double y = exploitable.getY() + exploitable.getHeight() / 2 - radius / 2;
        exploitable.getScene().addAsteroid(
                AsteroidPools.getInstance().getAsteroidMedium(exploitable.getGame(), x, y, exploitable.getPi()));
        exploitable.getScene().addAsteroid(
                AsteroidPools.getInstance().getAsteroidMedium(exploitable.getGame(), x, y, exploitable.getPi()));
    }
}
