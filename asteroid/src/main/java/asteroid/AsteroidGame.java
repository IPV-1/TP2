package asteroid;


import com.uqbar.vainilla.Game;
import config.Config;
import scenes.AsteroidScene;

import java.awt.*;

public class AsteroidGame extends Game {
    private Config configuration;


    public AsteroidGame(String configFile){
        setConfiguration(new Config(configFile));
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

    private void setConfiguration(Config configuration) {
        this.configuration = configuration;
    }
}
