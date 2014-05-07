package asteroids.estrategies;

import asteroids.AsteroidMedium;

public class ExplodeToMediumAsteroids implements ExplodeStrategy{
    @Override
    public void explode(Exploitable exploitable) {
        double radius = exploitable.getGame().getSprite("asteroidM").getWidth() / 2;
        double x = exploitable.getX() + exploitable.getWidth() / 2 - radius / 2;
        double y = exploitable.getY() + exploitable.getHeight() / 2 - radius / 2;
        exploitable.getScene().addAsteroid(
                AsteroidMedium.getPool().get(exploitable.getGame(), x, y, exploitable.getPi()));
        exploitable.getScene().addAsteroid(
                AsteroidMedium.getPool().get(exploitable.getGame(), x, y, exploitable.getPi()));
    }
}
