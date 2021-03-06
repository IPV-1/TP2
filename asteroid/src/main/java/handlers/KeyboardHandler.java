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
	
	private Map<Key, Action> KEYS = new HashMap<Key, Action>();
	
	private KeyboardHandler() {
		super();
		reset();
	}
	
	public void reset() {
		KEYS = getKeyActions();
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
		
		if(! KEYS.get(Key.UP).isSelected() && ship.getSpeed() > 0) {
        	ship.breakingSpeed(deltaState);
		}
	}
	
	private void updateKEYS(Ship ship, DeltaState deltaState) {
		for (Key key : getListeningKeys()) {
			if(deltaState.isKeyPressed(key)) {
				KEYS.get(key).setSelected(ship, true);
			} else if(deltaState.isKeyReleased(key)){
				KEYS.get(key).setSelected(ship, false);
			}
			
			if(KEYS.get(key).isSelected()) {
				getKeyActions().get(key).execute(ship, deltaState.getDelta());
			}
		}
		
		verifyMultipleSides(ship, deltaState);
	}

	private void verifyMultipleSides(Ship ship, DeltaState deltaState) {
		if(deltaState.isKeyPressed(Key.LEFT)) {
			KEYS.get(Key.RIGHT).setSelected(ship, false);
		} else if(deltaState.isKeyReleased(Key.RIGHT)){
			KEYS.get(Key.LEFT).setSelected(ship, false);
		}
	}

	private List<Key> getListeningKeys() {
		return new ArrayList<Key>(KEYS.keySet());
	}
	
}
