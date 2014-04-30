package components.shapes;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MultiShape implements Shape{
    @Override
    public boolean isColliding(Shape shape) {
        return shape.collidedByMultiShape(this);
    }

    @Override
    public boolean collidedByCircle(Circle shape) {
        throw new NotImplementedException();
    }

    @Override
    public boolean collidedByRectangle(Rectangle rectangle) {
        throw new NotImplementedException();
    }

    @Override
    public boolean collidedByMultiShape(MultiShape multiShape) {
        throw new NotImplementedException();
    }
}
