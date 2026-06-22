package support;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties config;

    private static Properties getConfig() {
        if (config == null) {
            new ConfigLoader();
        }
        return config;
    }

    private ConfigLoader() {
        config = new Properties();
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")){
            config.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not loaded\n" + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String systemValue = System.getProperty(key);
        return systemValue != null ? systemValue : getConfig().getProperty(key);
    }

}
