package tools_qa.providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import tools_qa.configuration.Config;
import tools_qa.enums.Browser;

import java.util.HashMap;
import java.util.Map;

public class DriverProvider {

    public static WebDriver getDriver(Browser browser, String downloadFilePath) {
        switch (browser) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");

                if (Config.isHeadless()) {
                    options.addArguments("--headless");
                }

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", downloadFilePath);
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
}
