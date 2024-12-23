package tools_qa.pages.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools_qa.configuration.Config;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public abstract class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait defaultWait;
    protected JavascriptExecutor jse;

    // -----------------------
    // WebDriver configuration
    // -----------------------

    private void initDriver(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        defaultWait = new WebDriverWait(driver, Duration.ofSeconds(Config.getDefaultWait()));
        jse = (JavascriptExecutor)driver;
    }

    // ------------------
    // Class constructors
    // ------------------

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        initDriver(driver);
    }

    public BasePage(WebElement parent, WebDriver driver) {
        PageFactory.initElements(new DefaultElementLocatorFactory(parent), this);
        initDriver(driver);
    }

    // ----------------------------------------------
    // Overriding methods with action logging methods
    // ----------------------------------------------

    protected void click(WebElement element) {
        System.out.println("Clicking on: " + element.getText().replace("\r\n", " "));
        element.click();
    }

    protected void sendKeys(WebElement element, String textToSend) {
        System.out.println("Typing: " + textToSend);
        element.sendKeys(textToSend);
    }

    protected void sendKeysAndClear(WebElement element, String textToSend) {
        System.out.println("Clearing input");
        element.clear();
        sendKeys(element, textToSend);
    }
}
