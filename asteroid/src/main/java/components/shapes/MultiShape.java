package components.shapes;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class MultiShape implements Shape{
    private List<Shape> shapes;

    public MultiShape(){
        setShapes(new ArrayList<Shape>());
    }

    public void addShape(Shape shape){
        getShapes().add(shape);
    }

    @Override
    public boolean isColliding(Shape shape) {
        return shape.collidedByMultiShape(this);
    }

    @Override
    public boolean collidedByCircle(Circle shape) {
        boolean collided = false;
        for(Shape s: getShapes())
            collided |= shape.isColliding(s);
        return collided;
    }

    @Override
    public boolean collidedByRectangle(Rectangle rectangle) {
        boolean collided = false;
        for(Shape s: getShapes())
            collided |= rectangle.isColliding(s);
        return collided;
    }

    @Override
    public boolean collidedByMultiShape(MultiShape multiShape) {
        throw new NotImplementedException();
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }
}
