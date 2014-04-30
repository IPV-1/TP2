package components.shapes;

import components.BasicAsteroidMovingGameComponent;
import junit.framework.TestCase;

public class CircleTest extends TestCase {
    BasicAsteroidMovingGameComponent component;
    Circle circle;


    BasicAsteroidMovingGameComponent component2;
    Circle circle2;

    BasicAsteroidMovingGameComponent component3;
    Rectangle rectangle;

    BasicAsteroidMovingGameComponent component4;
    MultiShape multiShape;


    public void setUp() {
        component = new BasicAsteroidMovingGameComponent(0, 0);
        circle = new Circle(20);
        circle.setComponent(component);

        component2 = new BasicAsteroidMovingGameComponent(0, 0);
        circle2 = new Circle(20);
        circle2.setComponent(component2);

        component3 = new BasicAsteroidMovingGameComponent(0, 0);
        rectangle = new Rectangle(20, 10);
        rectangle.setComponent(component3);

        component4 = new BasicAsteroidMovingGameComponent(0,0);
        multiShape = new MultiShape();
        Rectangle multiShapeRectangle = new Rectangle(40, 20);
        Rectangle multiShapeRectangle2 = new Rectangle(20, 40);
        multiShapeRectangle.setComponent(new BasicAsteroidMovingGameComponent(0, 0));
        multiShapeRectangle2.setComponent(new BasicAsteroidMovingGameComponent(0, 0));
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
        circle.getComponent().setX(20);
        assertTrue(circle.isColliding(multiShape));
    }

    public void testCircleCollidesWithSecondMultiShape(){
        circle.getComponent().setY(20);
        assertTrue(circle.isColliding(multiShape));
    }

    public void testCircleDoesntCollideMultiShape(){
        circle.getComponent().setY(20);
        circle.getComponent().setX(20);
        assertFalse(circle.isColliding(multiShape));
    }
}
