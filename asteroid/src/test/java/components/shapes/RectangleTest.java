package components.shapes;

import components.CollidableMovingGameComponent;
import junit.framework.TestCase;


public class RectangleTest extends TestCase{
    CollidableMovingGameComponent component;
    Rectangle rectangle;

	CollidableMovingGameComponent component1;
    Circle circle;
    private Rectangle rectangle2;
    private CollidableMovingGameComponent component3;
    private CollidableMovingGameComponent component4;
    private MultiShape multiShape;

    public void setUp(){
        component = new CollidableMovingGameComponent(0, 0);
        rectangle = new Rectangle(20, 10);
        rectangle.setShapeable(component);

        component3 = new CollidableMovingGameComponent(0, 0);
        rectangle2 = new Rectangle(20, 10);
        rectangle2.setShapeable(component3);

        component1 = new CollidableMovingGameComponent(0, 0);
        circle = new Circle(20);
        circle.setShapeable(component1);


        component4 = new CollidableMovingGameComponent(0,0);
        multiShape = new MultiShape();
        Rectangle multiShapeRectangle = new Rectangle(40, 20);
        Rectangle multiShapeRectangle2 = new Rectangle(20, 40);
        multiShapeRectangle.setShapeable(new CollidableMovingGameComponent(0, 0));
        multiShapeRectangle2.setShapeable(new CollidableMovingGameComponent(0, 0));
        multiShape.addShape(multiShapeRectangle);
        multiShape.addShape(multiShapeRectangle2);
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

    public void testRectangleCollidesMultiShapes(){
        assertTrue(rectangle.isColliding(multiShape));
    }

    public void testRectangleCollidesMultiShape(){
        component.setX(20);
        assertTrue(rectangle.isColliding(multiShape));
    }

    public void testRectangleCollidesSecondMultiShape(){
        component.setY(20);
        assertTrue(rectangle.isColliding(multiShape));
    }
    public void testRectangleDoesntCollidesMultiShapes(){
        component.setY(20);
        component.setX(20);
        assertFalse(rectangle.isColliding(multiShape));
    }
}
