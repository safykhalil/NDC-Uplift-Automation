package utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtils {
    private static final String TEST_DATA_PATH = "src/test/resources/testDataFiles";

    public static String getJsonData(String fileName, String field) throws FileNotFoundException {
        try {
            FileReader reader = new FileReader(TEST_DATA_PATH + fileName + ".json");
            JsonElement jsonElement = JsonParser.parseReader(reader);

            String[] keys = field.split("\\.");

            for (String key : keys) {
                if (jsonElement.getAsJsonObject().has(key)) {
                    jsonElement = jsonElement.getAsJsonObject().get(key);
                } else {
                    System.out.println("Field '" + field + "' not found in the JSON file.");
                    return "";
                }
            }

            if (!jsonElement.isJsonNull()) {
                return jsonElement.getAsString();
            } else {
                System.out.println("Field '" + field + "' is null in the JSON file.");
            }
        } catch (Exception e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
            e.printStackTrace();
        }
        return "";
    }

    public static String getPropertyValue(String fileName,String key) throws IOException {
        Properties properties=new Properties();
        properties.load(new FileInputStream(TEST_DATA_PATH+ fileName+  ".properties"));
        return properties.getProperty(key);
    }

    //read data from properties file
    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/Environment.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
