package components;


import com.uqbar.vainilla.appearances.Appearance;
import components.shapes.Shape;
import components.shapes.Shapeable;

public class ShapeableMovingGameComponent extends BasicAsteroidMovingGameComponent implements Shapeable {
    private Shape shape;
    
    public ShapeableMovingGameComponent(){
    }

	public ShapeableMovingGameComponent(Appearance appearance, Shape shape, double xPos,
	                                    double yPos, double xVec, double yVec, double speed){
		super(appearance, xPos, yPos, xVec, yVec, speed);
		setShape(shape);
		shape.setShapeable(this);
	}

    public ShapeableMovingGameComponent(double x, double y) {
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
