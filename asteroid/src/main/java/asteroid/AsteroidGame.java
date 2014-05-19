package asteroid;

import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;

import resource.ResourceUtils;
import scenes.AsteroidScene;
import scenes.levels.Level1;
import boards.LivesBoard;
import boards.ScoreBoard;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.appearances.Sprite;

import config.Config;
import config.Configuration;

public class AsteroidGame extends Game {
	private static AsteroidScene defaultScene = new Level1();
	private static String defaultConfigurationFile = "application.xml";
	private HashMap<String, Sprite> sprites;
	private HashMap<String, Double> values;
	private Config configuration;
	
	public final ScoreBoard BOARD = new ScoreBoard(20, 0, Color.WHITE);
	public final LivesBoard LIVES = new LivesBoard(620, 0, Color.WHITE);
	
	public AsteroidGame(String configFile, AsteroidScene scene) {
		super();
		Configuration.LOAD(configFile);
		setConfiguration(new Config(configFile));
		loadConfigurations();
		setCurrentScene(scene);
	}

	public AsteroidGame(AsteroidScene scene) {
		this(defaultConfigurationFile, scene);
	}

	public AsteroidGame(String configFile) {
		this(configFile, defaultScene);
	}

	public AsteroidGame() {
		this(defaultConfigurationFile, defaultScene);
	}

	/**
	 * This method should be val
	 */
	public void loadConfigurations() {
		addSprite("background", getConfig("background"));
		addSprite("bullet", getConfig("bullet"));
		addSprite("asteroidS", getConfig("asteroidS"));
		addSprite("asteroidM", getConfig("asteroidM"));
		addSprite("asteroidL", getConfig("asteroidL"));
		addSprite("ship", getConfig("ship"));

		addValue("screenWidth");
		addValue("screenHeight");

		addValue("bulletSpeed");
		addValue("asteroidMinSpeed");
		addValue("asteroidSMaxSpeed");
		addValue("asteroidMMaxSpeed");
		addValue("asteroidLMaxSpeed");
		addValue("asteroidPiExplosion");
		addValue("shipMaxSpeed");
		addValue("shipRotation");

		addValue("asteroidSQty");
		addValue("asteroidMQty");
		addValue("asteroidLQty");
	}

	@Override
	protected void initializeResources() {
		setSprites(new HashMap<String, Sprite>());
		setValues(new HashMap<String, Double>());
	}

	@Override
	protected void setUpScenes() {
		// setCurrentScene(new Level1());
	}

	@Override
	public Dimension getDisplaySize() {
		return new Dimension((int) getValue("screenWidth"),
				(int) getValue("screenHeight"));
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

	public void addValue(String value) {
		this.addValue(value, getConfig(value));
	}

	public void addValue(String key, String value) {
		getValues().put(key, Double.valueOf(value));
	}

	public double getValue(String valueKey) {
		return getValues().get(valueKey);
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
		return this.sprites;
	}

	private void setSprites(HashMap<String, Sprite> sprites) {
		this.sprites = sprites;
	}

	public HashMap<String, Double> getValues() {
		return values;
	}

	public void setValues(HashMap<String, Double> values) {
		this.values = values;
	}

}
