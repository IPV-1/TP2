package components.shapes;


public interface Shape {
    public boolean isColliding(Shape shape);

    public boolean collidedByCircle(Circle shape);

    public boolean collidedByRectangle(Rectangle rectangle);

    public boolean collidedByMultiShape(MultiShape multiShape);

	public void setShapeable(Shapeable shapeable);

	public Shapeable getShapeable();
}
