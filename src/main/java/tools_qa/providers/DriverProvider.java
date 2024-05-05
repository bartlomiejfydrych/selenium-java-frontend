package tools_qa.providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import tools_qa.configuration.Config;
import tools_qa.enums.Browser;

public class DriverProvider {

    public static WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");

                if (Config.isHeadless()) {
                    options.addArguments("--headless");
                }

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
