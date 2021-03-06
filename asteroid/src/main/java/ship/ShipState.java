package ship;

import handlers.KeyboardHandler;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Sprite;

public abstract class ShipState {

	public abstract Sprite getSprite();

	public void update(Ship ship, DeltaState deltaState) {
		KeyboardHandler.INSTANCE.updateShip(ship, deltaState);
		
		ship.getScene().updatePlayerComponent(ship);
	}
	
}
