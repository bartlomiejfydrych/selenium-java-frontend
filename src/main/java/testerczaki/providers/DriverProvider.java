package testerczaki.providers;

import global.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import testerczaki.configuration.Config;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DriverProvider {

    // -----------
    // MAIN METHOD
    // -----------

    // Main method to retrieve WebDriver
    public static WebDriver getDriver(Browser browser, String downloadFilePath) {
        WebDriver driver;
        switch (browser) {
            case CHROME -> driver = createChromeDriver(downloadFilePath);
            case FIREFOX -> driver = createFirefoxDriver();
            case EDGE -> driver = createEdgeDriver();
            case IE -> driver = createInternetExplorerDriver();
            default -> throw new IllegalStateException("Unexpected browser type: " + browser);
        }
        configureDriverDefaults(driver);
        return driver;
    }

    // --------------
    // HELPER METHODS
    // --------------

    // CHROME

    // Creates a ChromeDriver instance
    private static WebDriver createChromeDriver(String downloadFilePath) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "--disable-search-engine-choice-screen");

        if (Config.isHeadless()) {
            options.addArguments("--headless");
        }

        options.setExperimentalOption("prefs", getChromePreferences(downloadFilePath));

        return new ChromeDriver(options);
    }

    // Returns Chrome preferences
    private static Map<String, Object> getChromePreferences(String downloadFilePath) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", Paths.get(downloadFilePath).toAbsolutePath().toString());
        prefs.put("download.prompt_for_download", false);
        // To disable Chrome PDF viewer we should write this:
        // prefs.put("plugins.always_open_pdf_externally", true);
        return prefs;
    }

    // FIREFOX

    // Creates a FirefoxDriver instance
    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    // EDGE

    // Creates an EdgeDriver instance
    private static WebDriver createEdgeDriver() {
        return new EdgeDriver();
    }

    // INTERNET EXPLORER

    // Creates an InternetExplorerDriver instance
    private static WebDriver createInternetExplorerDriver() {
        return new InternetExplorerDriver();
    }

    // DRIVER DEFAULT SETTINGS

    // Configures common default settings for all drivers
    private static void configureDriverDefaults(WebDriver driver) {
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }
}

    /*
    -------------------------
    OLD CODE, BEFORE REFACTOR
    -------------------------

    NOTE:
    I decided to keep it just in case

    public static WebDriver getDriver(Browser browser, String downloadFilePath) {
        switch (browser) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--disable-search-engine-choice-screen");

                if (Config.isHeadless()) {
                    options.addArguments("--headless");
                }

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", Paths.get(downloadFilePath).toAbsolutePath().toString());
                prefs.put("download.prompt_for_download", false);
                // To disable Chrome PDF viewer we should write this:
                // prefs.put("plugins.always_open_pdf_externally", true);
                options.setExperimentalOption("prefs", prefs);

                return new ChromeDriver(options);
            }
            case FIREFOX -> {
                WebDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case EDGE -> {
                WebDriver driver = new EdgeDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case IE -> {
                WebDriver driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                return driver;
            }
            default -> throw new IllegalStateException("Unexpected value: " + browser);
        }
    }
    */
