package components.asteroids;

import components.asteroids.estrategies.ExplodeStrategy;
import components.asteroids.estrategies.Exploitable;
import components.asteroids.estrategies.JustExplode;
import components.asteroids.pools.AsteroidPools;
import components.Collidable;
import components.CollidableMovingGameComponent;
import utils.Utils;

import asteroid.AsteroidGame;

public class Asteroid extends CollidableMovingGameComponent implements Exploitable {
    private int points;
    private ExplodeStrategy explodeStrategy = JustExplode.getInstance();

    protected double pi;

    public Asteroid() {
        super();
    }

    public void explode() {
        getExplodeStrategy().explode(this);
    }

    public void store() {
        AsteroidPools.getInstance().push(this);
    }

    public static double getNewPiFrom(AsteroidGame game, double pi) {
        double piExp = game.getValue("asteroidPiExplosion");
        return Utils.randDouble(pi - piExp, pi + piExp);
    }

    @Override
    public void destroy() {
        getScene().getEnemyGroup().remove(this);
        this.getGame().getBoard().add(this.getPoints());
        this.explode();
        this.store();
        super.destroy();
    }

    public double getPi() {
        return this.pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ExplodeStrategy getExplodeStrategy() {
        return explodeStrategy;
    }

    public void setExplodeStrategy(ExplodeStrategy explodeStrategy) {
        this.explodeStrategy = explodeStrategy;
    }

    @Override
    public void collidedBy(Collidable component) {
        if (!isDestroyPending())
            destroy();
    }
}
