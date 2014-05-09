package components;

import components.asteroids.pools.BulletPool;
import com.uqbar.vainilla.DeltaState;

public class Bullet extends CollidableMovingGameComponent {

    public Bullet() {
        super();
    }

    @Override
    public void update(DeltaState deltaState) {
        super.update(deltaState);
        if (this.getScene().isOutside(this)) {
            this.destroy();
        }

    }

    @Override
    public void destroy() {
        getScene().getPlayerGroup().remove(this);
        BulletPool.getInstance().push(this);
        super.destroy();
    }

    public void collide(Collidable collidable) {
        if (!isDestroyPending()) {
            super.collide(collidable);
            destroy();
        }

    }

}
