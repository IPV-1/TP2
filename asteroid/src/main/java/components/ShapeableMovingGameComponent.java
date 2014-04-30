package components;


import components.shapes.Shape;
import components.shapes.Shapeable;

public class ShapeableMovingGameComponent extends BasicAsteroidMovingGameComponent implements Shapeable {
    private Shape shape;

    public ShapeableMovingGameComponent(int x, int y) {
        super(x, y);
    }


    @Override
    public boolean isColliding(Shapeable shapeable) {
        return getShape().isColliding(shapeable.getShape());
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
