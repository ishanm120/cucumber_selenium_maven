package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader configReader;

    private static Properties properties = new Properties();
    private static final String propertyFilePath= "src/test/resources/configs/global.properties";


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
       final Properties props = new Properties();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            try {
                props.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
        properties.putAll(props);
    }

    public String getProperty(final String propertyName){
        return properties.getProperty(propertyName);
    }

    public long getGlobalWait() {
        String implicitlyWait = properties.getProperty("globalTimeout");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("globalTimeout not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("baseUrl");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getBrowser() {
        String url = properties.getProperty("browser");
        if(url != null) return url;
        else throw new RuntimeException("browser not specified in the Configuration.properties file.");
    }
}
