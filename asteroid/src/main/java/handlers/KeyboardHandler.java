package handlers;

import ship.Ship;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.Key;

public class KeyboardHandler {
	
	public static final KeyboardHandler INSTANCE = new KeyboardHandler();

	private KeyboardHandler() {		
	}

	public void updateShip(Ship ship, DeltaState deltaState) {
		if(deltaState.isKeyBeingHold(Key.LEFT)) {
        	ship.rotate(ship.getGame(), -1);
        } else if(deltaState.isKeyBeingHold(Key.RIGHT)) {
        	ship.rotate(ship.getGame(), 1);
        } else if(deltaState.isKeyBeingHold(Key.UP)) {
        	ship.setMaxSpeed();
        } else if(deltaState.isKeyReleased(Key.SPACE)) {
        	ship.shot();
        }
		
		if(! deltaState.isKeyBeingHold(Key.UP) && ship.getSpeed() > 0) {
        	ship.breakingSpeed(deltaState);
		}
	}

}
