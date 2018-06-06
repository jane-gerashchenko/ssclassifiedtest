package data;

import com.codeborne.selenide.webdriver.WebDriverFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestPropertiesLoader {

    private static Properties testProperties;

    private static final String TEST_PROPERTIES = "test.properties";
    private static final String BASE_URL = "baseUrl";
    private static final String BROWSER = "browser";

    private TestPropertiesLoader() {
    }

    static {
        testProperties = loadProperties();
        testProperties.putAll(System.getProperties());
        System.setProperties(testProperties);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        properties = loadProperties(TEST_PROPERTIES, properties);
        return properties;
    }

    private static Properties loadProperties(final String propertiesFile, final Properties properties) {
        InputStream is = WebDriverFactory.class.getClassLoader().getResourceAsStream(propertiesFile);
        if (is == null) {
            return properties;
        }
        try {
            properties.load(is);
        } catch (IOException e) {
            System.out.println("[INFO] " + propertiesFile + " wasn't not found in classpath.");
        }
        return properties;
    }

    public static String getBrowser() {
        return getPropertyAndFailIfMissing(BROWSER);
    }

    public static String getBaseUrl() {
        return getPropertyAndFailIfMissing(BASE_URL);
    }

    private static String getPropertyAndFailIfMissing(final String key) {
        String value = testProperties.getProperty(key);
        if (value == null) {
            throw new RuntimeException(key + " system property is not defined");
        }
        return value;
    }
}