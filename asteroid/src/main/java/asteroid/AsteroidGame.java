package asteroid;


import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Sprite;
import config.Config;
import resource.ResourceUtils;

import java.awt.*;
import java.util.HashMap;

public class AsteroidGame extends Game {
    private HashMap<String, Sprite> sprites;
    private Config configuration;


    public AsteroidGame(String configFile) {
        super();
        setConfiguration(new Config(configFile));
        loadConfigurations();
    }

    public AsteroidGame() {
        this("application.xml");
    }

    /**
     * This method should be val
     */
    public void loadConfigurations() {
        addSprite("background", getConfig("background"));
    }

    @Override
    protected void initializeResources() {
        setSprites(new HashMap<String, Sprite>());
    }

    @Override
    protected void setUpScenes() {

    }

    @Override
    public Dimension getDisplaySize() {
        return new Dimension(800, 600);
    }

    @Override
    public String getTitle() {
        return "Asteroid";
    }

    public Config getConfiguration() {
        return this.configuration;
    }

    public String getConfig(String key) {
        return getConfiguration().fetch(key);
    }

    public void addSprite(String key, String spritePath) {
        getSprites().put(key, ResourceUtils.getSprite(spritePath));
    }

    public Sprite getSprite(String spriteKey) {
        return getSprites().get(spriteKey);
    }

    public static void main(String[] args) throws Exception {
        new DesktopGameLauncher(new AsteroidGame()).launch();
    }

    /**
     * Privates methods
     */

    private void setConfiguration(Config configuration) {
        this.configuration = configuration;
    }

    private HashMap<String, Sprite> getSprites() {
        return sprites;
    }

    private void setSprites(HashMap<String, Sprite> sprites) {
        this.sprites = sprites;
    }
}
