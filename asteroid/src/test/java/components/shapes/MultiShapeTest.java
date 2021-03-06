package components.shapes;

import components.BasicAsteroidMovingGameComponent;
import junit.framework.TestCase;

public class MultiShapeTest extends TestCase {

    private MultiShape multiShape;
    private BasicAsteroidMovingGameComponent component;
    private Circle circle;
    private Rectangle rectangle;
    private BasicAsteroidMovingGameComponent component1;
    private MultiShape multiShape2;

    public void setUp() {
        multiShape = new MultiShape();
        Rectangle multiShapeRectangle = new Rectangle(40, 20);
        Rectangle multiShapeRectangle2 = new Rectangle(20, 40);
        multiShapeRectangle.setComponent(new BasicAsteroidMovingGameComponent(0, 0));
        multiShapeRectangle2.setComponent(new BasicAsteroidMovingGameComponent(0, 0));
        multiShape.addShape(multiShapeRectangle);
        multiShape.addShape(multiShapeRectangle2);

        component = new BasicAsteroidMovingGameComponent(0, 0);
        circle = new Circle(20);
        circle.setComponent(component);

        component1 = new BasicAsteroidMovingGameComponent(0, 0);
        rectangle = new Rectangle(20, 20);
        rectangle.setComponent(component1);


        multiShape2 = new MultiShape();
        multiShape2.addShape(circle);
        multiShape2.addShape(rectangle);

    }

    public void testMultiShapesCollideCircle() {
        assertTrue(multiShape.isColliding(circle));
    }

    public void testMultiShapesDontCollideCircle() {
        component.setX(20);
        component.setY(20);
        assertFalse(multiShape.isColliding(circle));
    }

    public void testMultiShapesCollideRectangle() {
        assertTrue(multiShape.isColliding(rectangle));
    }

    public void testMultiShapesDontCollideRectangle() {
        component1.setX(20);
        component1.setY(20);
        assertFalse(multiShape.isColliding(rectangle));
    }

    public void testMultiShapesCollideOthersMultiShapes() {
        assertTrue(multiShape.isColliding(multiShape2));
    }

    public void testMultiShapesDontCollideOtherMultiShape() {
        component1.setX(20);
        component1.setY(20);
        component.setX(20);
        component.setY(20);
        assertFalse(multiShape.isColliding(multiShape2));
    }
}
