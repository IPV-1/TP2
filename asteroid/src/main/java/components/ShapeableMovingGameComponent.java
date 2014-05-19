package components;


import com.uqbar.vainilla.appearances.Appearance;

import components.shapes.Shape;
import components.shapes.Shapeable;

public class ShapeableMovingGameComponent extends BasicAsteroidMovingGameComponent implements Shapeable {
    private Shape shape;
    
    public ShapeableMovingGameComponent(){
    }

    public ShapeableMovingGameComponent(double x, double y) {
        super(x, y);
    }

    public ShapeableMovingGameComponent(Appearance appearance, Shape shape, double x, double y) {
    	super(x, y);
    	this.setAppearance(appearance);
    	this.setShape(shape);
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

	public void collided() {
		this.destroy();
	}
}
