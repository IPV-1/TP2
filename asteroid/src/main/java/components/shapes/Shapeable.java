package components.shapes;


public interface Shapeable {

    public boolean isColliding(Shapeable shapeable);

    public Shape getShape();
}
