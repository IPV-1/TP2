package components.shapes;


import components.BasicAsteroidMovingGameComponent;

public abstract class SimpleShape implements Shape{
    BasicAsteroidMovingGameComponent component;
    public BasicAsteroidMovingGameComponent getComponent() {
        return component;
    }

    public void setComponent(BasicAsteroidMovingGameComponent component) {
        this.component = component;
    }

    public double getX() {
        return getComponent().getX();
    }

    public double getY() {
        return getComponent().getY();
    }
}
