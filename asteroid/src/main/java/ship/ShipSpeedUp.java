package ship;

import com.uqbar.vainilla.appearances.Sprite;

import config.Configuration;

public class ShipSpeedUp extends ShipState {

	@Override
	public Sprite getSprite() {
		return Configuration.getSprite("shipFire");
	}
	
}
