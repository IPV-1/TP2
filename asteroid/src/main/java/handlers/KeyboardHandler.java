package handlers;

import handlers.actions.Action;
import handlers.actions.ActionLeft;
import handlers.actions.ActionRight;
import handlers.actions.ActionSpace;
import handlers.actions.ActionUp;

import java.util.ArrayList;
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
	
	/**
	 * Change to define key actions
	 */
	private Map<Key, Action> getKeyActions() {
		Map<Key, Action> actions = new HashMap<Key,Action>();
		actions.put(Key.LEFT, new ActionLeft());
		actions.put(Key.RIGHT, new ActionRight());
		actions.put(Key.UP, new ActionUp());
		actions.put(Key.SPACE, new ActionSpace());

		return actions;
	}

	public void updateShip(Ship ship, DeltaState deltaState) {
		
		this.updateKEYS(ship, deltaState);
		
		if(! KEYS.get(Key.UP) && ship.getSpeed() > 0) {
        	ship.breakingSpeed(deltaState);
		}
	}
	
	private void updateKEYS(Ship ship, DeltaState deltaState) {
		for (Key key : getListeningKeys()) {
			if(deltaState.isKeyPressed(key)) {
				KEYS.put(key, true);
			} else if(deltaState.isKeyReleased(key)){
				KEYS.put(key, false);
			}
			
			if(KEYS.get(key)) {
				getKeyActions().get(key).execute(ship, deltaState.getDelta());
			}
		}
	}

	private List<Key> getListeningKeys() {
		return new ArrayList<Key>(getKeyActions().keySet());
	}
	
}
