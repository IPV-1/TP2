package components;


import components.shapes.Shapeable;

public interface Collidable extends Shapeable{

    public void collide(Collidable collidable);

    public void collidedBy(Collidable collidable);

}
