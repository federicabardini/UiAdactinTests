package it.fedeb.uiadactintests.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private Properties properties = new Properties();

    public PropertyReader() {
        loadProperties();
    }

    private void loadProperties() {
        try {
            String build = System.getenv("ADACTIN_BUILD") != null ? System.getenv("ADACTIN_BUILD") : "build1";
            InputStream inputStream = new FileInputStream("src/test/resources/it/fedeb/uiadactintests/config-"+build+".properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: handle config file not found
            //TODO: add a readme file for test runs
        }
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }


}
