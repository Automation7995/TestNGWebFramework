package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JSONConfigReader {

    private static final JsonObject jsonReader;

    static {

        try {
            String env = System.getProperty("env", "qa");
            String fileName = "config/" + env + ".json";

            InputStream inputStream = JSONConfigReader.class.getClassLoader().getResourceAsStream(fileName);

            if (inputStream == null) {
                throw new RuntimeException("Config file not found" + fileName);
            }

            String jsonText = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            jsonReader = JsonParser.parseString(jsonText).getAsJsonObject();

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file: ", e);
        }
    }

    public static String getString(String key) {
        return jsonReader.get(key).getAsString();
    }

    public static int getInt(String key) {
        return jsonReader.get(key).getAsInt();
    }

    public static boolean getBoolean(String key) {
        return jsonReader.get(key).getAsBoolean();
    }

    public static JsonObject getJsonObject(String key) {
        return jsonReader.getAsJsonObject(key);
    }
}
