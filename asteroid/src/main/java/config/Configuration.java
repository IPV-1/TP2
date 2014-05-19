package config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import resource.ResourceUtils;

import com.uqbar.vainilla.appearances.Sprite;
import com.uqbar.vainilla.sound.Sound;

public class Configuration {

    private static Properties properties;
    
	private static Map<String, Sprite> sprites = new HashMap<String, Sprite>();
	private static Map<String, Double> values = new HashMap<String, Double>();
	private static Map<String, Sound> sounds = new HashMap<String, Sound>();
	
    private static void loadConfiguration() {
		addSprite("background");
		addSprite("bullet");
		addSprite("asteroidS");
		addSprite("asteroidM");
		addSprite("asteroidL");
		addSprite("ship");
		addSprite("shipFire");
		addSprite("shipWaiting");
	
		addValue("screenWidth");
		addValue("screenHeight");
	
		addValue("bulletSpeed");
		addValue("bulletQty");
		addValue("asteroidMinSpeed");
		addValue("asteroidSMaxSpeed");
		addValue("asteroidMMaxSpeed");
		addValue("asteroidLMaxSpeed");
		addValue("asteroidPiExplosion");
		addValue("shipMaxSpeed");
		addValue("shipRotation");
		addValue("shipFriction");
		addValue("shipAceleration");
	
		addValue("asteroidSQty");
		addValue("asteroidMQty");
		addValue("asteroidLQty");
		
		addSound("shooting");
		addSound("loseSound");
    }
    
    public static void LOAD(String file) {
    	properties = getConfigurations(file);
    	loadConfiguration();
    }
    
	public static Sprite getSprite(String key) {
		return sprites.get(key);
	}

	public static Double getValue(String key) {
		return values.get(key);
	}
	
	public static Sound getSound(String key) {
		return sounds.get(key);
	}
	
    private static String FETCH(String key){
        return (String) properties.get(key);
    }

    private static Properties getConfigurations(String file) {
        URL configFile = Configuration.class.getResource(file);
        try {
            InputStream configFileStream = configFile.openStream();
            Properties p = new Properties();
            p.loadFromXML(configFileStream);
            configFileStream.close();
            return p;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    
	private static void addValue(String key) {
		values.put(key, Double.valueOf(FETCH(key)));
	}

	private static void addSprite(String key) {
		sprites.put(key, ResourceUtils.getSprite(FETCH(key)));
	}
	
	private static void addSound(String key) {
		sounds.put(key, ResourceUtils.getSound(FETCH(key)));
	}

	public static double getDisplayWidth() {
		return getValue("screenWidth");
	}

	public static double getDisplayHeight() {
		return getValue("screenHeight");
	}

}