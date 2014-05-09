package asteroid.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Config {

    private Properties properties;

    public Config(String file){
        properties = getConfigurations(file);
    }

    public String fetch(String key){
        return (String) this.properties.get(key);
    }

    private static Properties getConfigurations(String file) {
        URL configFile = Config.class.getResource(file);
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
}