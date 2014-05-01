package components.shapes;


import components.BasicAsteroidMovingGameComponent;

public abstract class SimpleShape implements Shape {
	BasicAsteroidMovingGameComponent component;
	private double relativeX;
	private double relativeY;

	public SimpleShape() {
		setRelativeX(0);
		setRelativeY(0);
	}

	public SimpleShape(double relativeX, double relativeY) {
		setRelativeX(relativeX);
		setRelativeY(relativeY);
	}

	public BasicAsteroidMovingGameComponent getComponent() {
		return component;
	}

	public void setComponent(BasicAsteroidMovingGameComponent component) {
		this.component = component;
	}

	public double getX() {
		return getComponent().getX() + getRelativeX();
	}

	public double getY() {
		return getComponent().getY() + getRelativeY();
	}

	public double getRelativeY() {
		return relativeY;
	}

	public void setRelativeY(double relativeY) {
		this.relativeY = relativeY;
	}

	public double getRelativeX() {
		return relativeX;
	}

	public void setRelativeX(double relativeX) {
		this.relativeX = relativeX;
	}
}
