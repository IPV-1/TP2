package asteroid;


import com.uqbar.vainilla.Game;
import config.Config;

import java.awt.*;

public class AsteroidGame extends Game {
    private Config configuration;


    public AsteroidGame(String configFile) {
        super();
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

    private void setConfiguration(Config configuration) {
        this.configuration = configuration;
    }
}
