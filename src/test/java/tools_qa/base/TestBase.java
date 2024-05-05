package tools_qa.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import tools_qa.configuration.Config;
import tools_qa.providers.DriverProvider;
import tools_qa.providers.UrlProvider;

public class TestBase {
    public WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverProvider.getDriver(Config.getBrowser());
        driver.get(UrlProvider.homePage);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
