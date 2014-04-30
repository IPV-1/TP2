package components.shapes;


import com.uqbar.vainilla.colissions.CollisionDetector;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Rectangle extends SimpleShape implements Shape {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean isColliding(Shape shape) {
        return shape.collidedByRectangle(this);
    }

    @Override
    public boolean collidedByCircle(Circle shape) {
        return CollisionDetector.INSTANCE.collidesCircleAgainstRect(shape.getX(), shape.getY(), (int) shape.getRadio(), getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public boolean collidedByRectangle(Rectangle rectangle) {
        throw new NotImplementedException();
    }

    @Override
    public boolean collidedByMultiShape(MultiShape multiShape) {
        throw new NotImplementedException();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
