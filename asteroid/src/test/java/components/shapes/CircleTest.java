package components.shapes;

import components.BasicAsteroidMovingGameComponent;
import junit.framework.TestCase;

public class CircleTest extends TestCase {
    BasicAsteroidMovingGameComponent component;
    Circle circle;
    BasicAsteroidMovingGameComponent component2;
    Circle circle2;

    public void setUp() {
        component = new BasicAsteroidMovingGameComponent(0, 0);
        circle = new Circle(20);
        circle.setComponent(component);

        component2 = new BasicAsteroidMovingGameComponent(0, 0);
        circle2 = new Circle(20);
        circle2.setComponent(component2);
    }

    public void testCirclesCollided() {
        assertTrue(circle.isColliding(circle2));
    }

    public void testCirclesCollidedWhenOneTouchsAnother(){
        component2.setX(10);
        assertTrue(circle.isColliding(circle2));
    }
    public void testCirclesNotCollided(){
        component2.setX(20);
        assertFalse(circle.isColliding(circle2));
    }
}
