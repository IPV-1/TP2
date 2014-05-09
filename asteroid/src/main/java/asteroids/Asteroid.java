package asteroids;

import asteroids.estrategies.ExplodeStrategy;
import asteroids.estrategies.Exploitable;
import asteroids.estrategies.JustExplode;
import asteroids.pools.AsteroidPools;
import components.Collidable;
import components.CollidableMovingGameComponent;
import utils.Utils;

import asteroid.AsteroidGame;

public class Asteroid extends CollidableMovingGameComponent implements Exploitable {
    private int points;
    private ExplodeStrategy explodeStrategy = new JustExplode();

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
        this.getGame().BOARD.add(this.getPoints());
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
