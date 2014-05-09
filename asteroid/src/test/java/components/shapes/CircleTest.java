package components.shapes;

import components.CollidableMovingGameComponent;
import junit.framework.TestCase;

public class CircleTest extends TestCase {
    CollidableMovingGameComponent component;
    Circle circle;


    CollidableMovingGameComponent component2;
    Circle circle2;

    CollidableMovingGameComponent component3;
    Rectangle rectangle;

    CollidableMovingGameComponent component4;
    MultiShape multiShape;


    public void setUp() {
        component = new CollidableMovingGameComponent(0, 0);
        circle = new Circle(20);
        circle.setShapeable(component);

        component2 = new CollidableMovingGameComponent(0, 0);
        circle2 = new Circle(20);
        circle2.setShapeable(component2);

        component3 = new CollidableMovingGameComponent(0, 0);
        rectangle = new Rectangle(20, 10);
        rectangle.setShapeable(component3);

        component4 = new CollidableMovingGameComponent(0,0);
        multiShape = new MultiShape();
        Rectangle multiShapeRectangle = new Rectangle(40, 20);
        Rectangle multiShapeRectangle2 = new Rectangle(20, 40);
        multiShapeRectangle.setShapeable(new CollidableMovingGameComponent(0, 0));
        multiShapeRectangle2.setShapeable(new CollidableMovingGameComponent(0, 0));
        multiShape.addShape(multiShapeRectangle);
        multiShape.addShape(multiShapeRectangle2);


    }

    public void testCirclesCollided() {
        assertTrue(circle.isColliding(circle2));
    }

    public void testCirclesCollidedWhenOneTouchesAnother() {
        component2.setX(10);
        assertTrue(circle.isColliding(circle2));
    }

    public void testCirclesNotCollided() {
        component2.setX(20);
        assertFalse(circle.isColliding(circle2));
    }

    public void testCircleCollidesRectangle() {
        assertTrue(circle.isColliding(rectangle));
    }

    public void testCircleDoesntCollideRectangle() {
        component3.setX(20);
        assertFalse(circle.isColliding(rectangle));
    }

    public void testCircleCollidesWithMultiShapes(){
        assertTrue(circle.isColliding(multiShape));
    }

    public void testCircleCollidesWithMultiShape(){
        circle.getShapeable().setX(20);
        assertTrue(circle.isColliding(multiShape));
    }

    public void testCircleCollidesWithSecondMultiShape(){
        circle.getShapeable().setY(20);
        assertTrue(circle.isColliding(multiShape));
    }

    public void testCircleDoesntCollideMultiShape(){
        circle.getShapeable().setY(20);
        circle.getShapeable().setX(20);
        assertFalse(circle.isColliding(multiShape));
    }
}
