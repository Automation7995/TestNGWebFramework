package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static{
        try {
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("Config file not present");
            }

            prop = new Properties();
            prop.load(input);

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return System.getProperty(key, prop.getProperty(key));
    }
}

