package asteroids;

import asteroids.estrategies.ExplodeStrategy;
import asteroids.estrategies.Exploitable;
import asteroids.estrategies.JustExplode;
import com.uqbar.vainilla.appearances.Appearance;
import utils.Utils;

import asteroid.AsteroidGame;

import components.ShapeableMovingGameComponent;
import components.shapes.Shape;

public abstract class Asteroid extends ShapeableMovingGameComponent implements Exploitable {
    private int points;
    private ExplodeStrategy explodeStrategy = new JustExplode();

    protected double pi;

    public Asteroid() {
        super();
    }

    public void explode() {
        getExplodeStrategy().explode(this);
    }

    public abstract void store();

    public static double getNewPiFrom(AsteroidGame game, double pi) {
        double piExp = game.getValue("asteroidPiExplosion");
        return Utils.randDouble(pi - piExp, pi + piExp);
    }

    @Override
    public void destroy() {
        this.getScene().getGame().BOARD.add(this.getPoints());
        this.store();
        this.explode();
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
}
