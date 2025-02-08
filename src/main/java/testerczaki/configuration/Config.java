package testerczaki.configuration;

import global.enums.Browser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;

public class Config {

    private static final Properties properties = new Properties();

    // --------------------------------------
    // Method that loads a configuration file
    // --------------------------------------

    /*
    NOTE FOR ME:
    Mechanizm, który zapewni, że plik z config.properties będzie wczytany tylko raz i później re-używany
    do wszystkich metod, które pobierają informacje z tego pliku konfiguracyjnego.
    */

    // Static initializer to load the configuration file
    static {
        try (InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("testerczaki/configs/config.properties")) {
            if (inputStream == null) {
                throw new IllegalStateException("Configuration file 'config.properties' not found");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Error loading configuration file", e);
        }
    }

    // -----
    // Utils
    // -----

    // Utility method to get property values with optional defaults
    private static String getProperty(String key, String defaultValue) {
        return Optional.ofNullable(properties.getProperty(key)).orElse(defaultValue).trim();
    }

    private static String getRequiredProperty(String key) {
        return Optional.ofNullable(properties.getProperty(key))
                .map(String::trim)
                .orElseThrow(() -> new IllegalStateException("Missing required configuration key: " + key));
    }

    // ------------------------------------------------------
    // Methods that retrieve data from the configuration file
    // ------------------------------------------------------

    // Get browser type from config, with a fallback to a default browser
    public static Browser getBrowser() {
        String browser = getProperty("browser", "CHROME").toUpperCase();
        try {
            return Browser.valueOf(browser);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Invalid browser specified in config: " + browser);
        }
    }

    // Get application URL, mandatory
    public static String getAppUrl() {
        return getRequiredProperty("appUrl");
    }

    // Get headless mode setting, with a default value of false
    public static boolean isHeadless() {
        return getBooleanProperty("isHeadless", false);
    }

    // Get default wait time, with a fallback to 10 seconds
    public static int getDefaultWait() {
        try {
            return Integer.parseInt(getProperty("defaultWait", "10"));
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid defaultWait value in config, must be an integer");
        }
    }

    // Get the main resources path, defaulting to the current directory
    public static String getMainResourcesPath() {
        return getResolvedPath("mainResourcesPath", ".");
    }

    // Get the test resources path, defaulting to the current directory
    public static String getTestResourcesPath() {
        return getResolvedPath("testResourcesPath", ".");
    }

    // Get clear Allure Report files setting, with a default value of false
    public static boolean getClearAllureReportFiles() {
        return getBooleanProperty("clearAllureReportFiles", false);
    }

    // -------
    // HELPERS
    // -------

    // Helper method to get boolean property with default value
    private static boolean getBooleanProperty(String key, boolean defaultValue) {
        return Boolean.parseBoolean(getProperty(key, String.valueOf(defaultValue)));
    }

    // Helper method to resolve path based on user directory
    private static String getResolvedPath(String key, String defaultPath) {
        return Paths.get(System.getProperty("user.dir"), getProperty(key, defaultPath)).toAbsolutePath().toString();
    }
}
