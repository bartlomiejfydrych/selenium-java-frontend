package tools_qa.configuration;

import tools_qa.enums.Browser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static Properties properties;

    //---------------------------------------
    // Method that loads a configuration file
    //---------------------------------------

    /*
    NOTE FOR ME:
    Mechanizm, który zapewni, że plik z config.properties będzie wczytany tylko raz i później re-używany
    do wszystkich metod, które pobierają informacje z tego pliku konfiguracyjnego.
    */

    static {
        properties = new Properties();
        try (InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("tools_qa/config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("Configuration file 'config.properties' not found");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading configuration file", e);
        }
    }

    //-------------------------------------------------------
    // Methods that retrieve data from the configuration file
    //-------------------------------------------------------

    public static Browser getBrowser() {
        return Browser.valueOf(properties.getProperty("browser").trim().toUpperCase());
    }

    public static String getAppUrl() {
        return properties.getProperty("appUrl");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("isHeadless"));
    }

    public static int getDefaultWait() {
        return Integer.parseInt(properties.getProperty("defaultWait"));
    }
}
