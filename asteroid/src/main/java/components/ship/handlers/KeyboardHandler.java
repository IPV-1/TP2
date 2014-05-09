package components.ship.handlers;

import components.ship.Ship;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.Key;

public class KeyboardHandler {

    public static final KeyboardHandler INSTANCE = new KeyboardHandler();

    private KeyboardHandler() {
    }

    public void updateShip(Ship ship, DeltaState deltaState) {
        if (deltaState.isKeyBeingHold(Key.LEFT)) {
            ship.rotate(-1);
        } else if (deltaState.isKeyBeingHold(Key.RIGHT)) {
            ship.rotate(1);
        }
        if (deltaState.isKeyBeingHold(Key.UP)) {
            ship.setMaxSpeed();
        } else if (ship.getSpeed() > 0) {
            ship.breakingSpeed(deltaState);
        }
        if (deltaState.isKeyReleased(Key.SPACE)) {
            ship.shot();
        }
    }

}