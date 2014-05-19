package scenes.statics;

import scenes.levels.Level1;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.events.constants.Key;

import config.Configuration;

public class TitleScene extends GameScene {
	
	public TitleScene(Game game) {
		this.addComponent(new GameComponent<GameScene>(Configuration.getSprite("title"), 0, 0) {
			@Override
			public void update(DeltaState deltaState) {
				if (deltaState.isKeyPressed(Key.ENTER)) {
					this.getGame().setCurrentScene(new Level1());
				}
				super.update(deltaState);
			}
		});
	}

}
