package ship;

import handlers.KeyboardHandler;

import com.uqbar.vainilla.DeltaState;

public class ShipImmune extends ShipWaiting {
	
	@Override
	public void update(Ship ship, DeltaState deltaState) {
		KeyboardHandler.INSTANCE.updateShip(ship, deltaState);
	}
}
