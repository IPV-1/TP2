package components.shapes;


import com.uqbar.vainilla.colissions.CollisionDetector;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Circle extends SimpleShape implements Shape {

    private double diameter;

    public Circle(double diameter) {
        setDiameter(diameter);
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getRadio() {
        return this.getDiameter() / 2;
    }


    @Override
    public boolean isColliding(Shape shape) {
        return shape.collidedByCircle(this);
    }

    @Override
    public boolean collidedByCircle(Circle shape) {
        return CollisionDetector.INSTANCE.collidesCircleAgainstCircle(getX(), getY(), (int) getRadio(), shape.getX(), shape.getY(), (int) shape.getRadio());
    }

    @Override
    public boolean collidedByRectangle(Rectangle rectangle) {
        return CollisionDetector.INSTANCE.collidesCircleAgainstRect(getX(), getY(), getRadio(), rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    @Override
    public boolean collidedByMultiShape(MultiShape multiShape) {
        throw new NotImplementedException();
    }
}
