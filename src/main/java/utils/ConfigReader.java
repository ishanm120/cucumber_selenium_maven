package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader configReader;

    private final Properties properties = new Properties();
    private static final String PROPERTY_FILE = "configs/global.properties";


    public static synchronized ConfigReader getConfigReader(){
        if(Objects.isNull(configReader)){
            configReader = new ConfigReader();
            configReader.initConfigLoader();
        }
        return configReader;
    }

    private void initConfigLoader(){
        configReader.loadProperties();
    }


    public void loadProperties(){
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(PROPERTY_FILE)) {
            if (input == null) {
                throw new IllegalStateException("Configuration file not found on classpath: " + PROPERTY_FILE);
            }
            properties.load(input);
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load " + PROPERTY_FILE, exception);
        }
    }

    public String getProperty(final String propertyName){
        String systemValue = System.getProperty(propertyName);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }
        String environmentName = propertyName
                .replaceAll("([a-z0-9])([A-Z])", "$1_$2")
                .replace('.', '_')
                .replace('-', '_')
                .toUpperCase();
        String environmentValue = System.getenv(environmentName);
        if (environmentValue != null && !environmentValue.isBlank()) {
            return environmentValue;
        }
        return properties.getProperty(propertyName);
    }

    public long getGlobalWait() {
        String implicitlyWait = getProperty("globalTimeout");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("globalTimeout not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = getProperty("baseUrl");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getBrowser() {
        String browser = getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("browser not specified in the Configuration.properties file.");
    }
}
