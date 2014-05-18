package ship;

import com.uqbar.vainilla.appearances.Sprite;

import config.Configuration;

public class ShipWaiting extends ShipState {

	@Override
	public Sprite getSprite() {
		return Configuration.getSprite("shipWaiting");
	}

}
