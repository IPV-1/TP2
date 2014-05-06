package components.shapes;

public abstract class SimpleShape implements Shape {
	private Shapeable shapeable;
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

	public double getX() {
		return getShapeable().getX() + getRelativeX();
	}

	public double getY() {
		return getShapeable().getY() + getRelativeY();
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

	public Shapeable getShapeable() {
		return shapeable;
	}

	public void setShapeable(Shapeable shapeable) {
		this.shapeable = shapeable;
	}
}
