package components.text;


import scenes.AsteroidScene;

import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.events.constants.Key;

public class NewGameText extends SelectableText {

    public NewGameText(Appearance appearance, double x, double y, boolean selected) {
        super(appearance, x, y, selected);
    }

    @Override
    protected Key textKey() {
        return Key.ENTER;
    }

    @Override
    public GameScene getNewScene() {
        return new AsteroidScene();
    }
}
