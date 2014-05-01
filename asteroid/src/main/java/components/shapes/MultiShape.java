package components.shapes;

import java.util.ArrayList;
import java.util.List;

public class MultiShape implements Shape {
	private List<Shape> shapes;

	public MultiShape() {
		setShapes(new ArrayList<Shape>());
	}

	public void addShape(Shape shape) {
		getShapes().add(shape);
	}

	@Override
	public boolean isColliding(Shape shape) {
		return shape.collidedByMultiShape(this);
	}

	@Override
	public boolean collidedByCircle(Circle circle) {
		return delagateOnChilden(circle);
	}

	@Override
	public boolean collidedByRectangle(Rectangle rectangle) {
		return delagateOnChilden(rectangle);
	}

	@Override
	public boolean collidedByMultiShape(MultiShape multiShape) {
		return delagateOnChilden(multiShape);
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}

	private boolean delagateOnChilden(Shape shape) {
		boolean collided = false;
		for (Shape s : getShapes())
			collided |= shape.isColliding(s);
		return collided;
	}
}
