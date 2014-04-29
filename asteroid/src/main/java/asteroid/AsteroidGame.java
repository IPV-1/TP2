package asteroid;


import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.appearances.Sprite;
import config.Config;
import resource.ResourceUtils;

import java.awt.*;
import java.util.HashMap;

public class AsteroidGame extends Game {
    private HashMap<String, Sprite> resources;
    private Config configuration;


    public AsteroidGame(String configFile) {
        super();
        setResources(new HashMap<String, Sprite>());
        setConfiguration(new Config(configFile));
    }

    public AsteroidGame() {
        this("application.xml");
    }

    @Override
    protected void initializeResources() {

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
        return configuration;
    }

    public void addResource(String key, String ResourceName){
        getResources().put(key, ResourceUtils.getSprite(ResourceName));
    }

    /**
     * Privates methods
     */

    private void setConfiguration(Config configuration) {
        this.configuration = configuration;
    }

    private HashMap<String, Sprite> getResources() {
        return resources;
    }

    private void setResources(HashMap<String, Sprite> resources) {
        this.resources = resources;
    }
}
