package components.shapes;

import components.BasicAsteroidMovingGameComponent;
import junit.framework.TestCase;


public class RectangleTest extends TestCase{
    BasicAsteroidMovingGameComponent component;
    Rectangle rectangle;

    BasicAsteroidMovingGameComponent component1;
    Circle circle;
    private Rectangle rectangle2;
    private BasicAsteroidMovingGameComponent component3;

    public void setUp(){
        component = new BasicAsteroidMovingGameComponent(0, 0);
        rectangle = new Rectangle(20, 10);
        rectangle.setComponent(component);

        component3 = new BasicAsteroidMovingGameComponent(0, 0);
        rectangle2 = new Rectangle(20, 10);
        rectangle2.setComponent(component3);

        component1 = new BasicAsteroidMovingGameComponent(0, 0);
        circle = new Circle(20);
        circle.setComponent(component1);
    }

    public void testRectangleCollidesRectangle(){
        assertTrue(rectangle.isColliding(rectangle2));
    }

    public void testRectangleDoesntCollideRectangle(){
        component3.setX(20);
        assertFalse(rectangle.isColliding(rectangle2));
    }

    public void testRectangleCollidesCircle(){
        assertTrue(rectangle.isColliding(circle));
    }

    public void testRectangleDoesntCollideCircle(){
        component.setX(20);
        assertFalse(rectangle.isColliding(circle));
    }
}
