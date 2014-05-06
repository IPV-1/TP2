package components.shapes;


public interface Shapeable {

    public boolean isColliding(Shapeable shapeable);

    public Shape getShape();

	public void setShape(Shape shape);

	public double getX();

	public double getY();

	public void setY(double y);

	public void setX(double x);
}
