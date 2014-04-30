package components.shapes;

import components.BasicAsteroidMovingGameComponent;
import junit.framework.TestCase;

public class MultiShapeTest extends TestCase{

    private MultiShape multiShape;
    private BasicAsteroidMovingGameComponent component;
    private Circle circle;

    public void setUp(){
        multiShape = new MultiShape();
        Rectangle multiShapeRectangle = new Rectangle(40, 20);
        Rectangle multiShapeRectangle2 = new Rectangle(20, 40);
        multiShapeRectangle.setComponent(new BasicAsteroidMovingGameComponent(0, 0));
        multiShapeRectangle2.setComponent(new BasicAsteroidMovingGameComponent(0, 0));
        multiShape.addShape(multiShapeRectangle);
        multiShape.addShape(multiShapeRectangle2);

        component = new BasicAsteroidMovingGameComponent(0,0);
        circle = new Circle(20);
        circle.setComponent(component);

    }

    public void testMultiShapesCollideCircle(){
        assertTrue(multiShape.isColliding(circle));
    }

    public void testMultiShapesDontCollideCircle(){
        component.setX(20);
        component.setY(20);
        assertFalse(multiShape.isColliding(circle));
    }
}
