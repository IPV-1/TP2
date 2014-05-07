package handlers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ship.Ship;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.Key;

public class KeyboardHandler {
	
	public static final KeyboardHandler INSTANCE = new KeyboardHandler();
	
	private Map<Key, Boolean> KEYS = new HashMap<Key, Boolean>();
	
	private KeyboardHandler() {
		super();
		
		for (Key key : getListeningKeys()) {
			KEYS.put(key, false);
		}
	}

	public void updateShip(Ship ship, DeltaState deltaState) {
		
		this.updateKEYS(deltaState);
		
		if(KEYS.get(Key.LEFT)) {
        	ship.rotate(ship.getGame(), -1);
        }
		if(KEYS.get(Key.RIGHT)) {
        	ship.rotate(ship.getGame(), 1);
        }
		if(KEYS.get(Key.UP)) {
        	ship.setMaxSpeed();
        }
		if(KEYS.get(Key.SPACE)) {
        	ship.shot();
        }
		if(! KEYS.get(Key.UP) && ship.getSpeed() > 0) {
        	ship.breakingSpeed(deltaState);
		}
	}
	
	private void updateKEYS(DeltaState deltaState) {
		for (Key key : getListeningKeys()) {
			if(deltaState.isKeyPressed(key)) {
				KEYS.put(key, true);
			} else if(deltaState.isKeyReleased(key)){
				KEYS.put(key, false);
			}
		}
	}

	private List<Key> getListeningKeys() {
		return Arrays.asList(new Key[]{
			Key.LEFT,
			Key.RIGHT,
			Key.UP,
			Key.SPACE
		});
	}

}
