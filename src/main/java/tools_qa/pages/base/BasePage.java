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
        this.actions = new Actions(driver);
        this.defaultWait = new WebDriverWait(driver, Duration.ofSeconds(Config.getDefaultWait()));
        this.jse = (JavascriptExecutor) driver;
    }

    // ------------------
    // Class constructors
    // ------------------

    public BasePage(WebDriver driver) {
        initDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebElement parent, WebDriver driver) {
        initDriver(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(parent), this);
    }
}

/*

// -----------------------------------------------------------------------
// Examples of overriding basic methods to ones that log performed actions
// -----------------------------------------------------------------------

I believe that logging the actions performed in the console is unnecessary, because it can slow down the process
a bit and if the test fails, it is usually known at what step.

// ACTION METHODS WITH LOGGING

protected void click(WebElement element) {
    logAction("Clicking on", element);
    element.click();
}

protected void sendKeys(WebElement element, String textToSend) {
    logAction("Typing: " + textToSend, element);
    element.sendKeys(textToSend);
}

protected void sendKeysAndClear(WebElement element, String textToSend) {
    logAction("Clearing input", element);
    element.clear();
    sendKeys(element, textToSend);
}

protected void scrollToElement(WebElement element) {
    logAction("Scrolling to element", element);
    jse.executeScript("arguments[0].scrollIntoView(true);", element);
}

// HELPER LOG METHOD

private void logAction(String action, WebElement element) {
    try {
        String elementText = element.getText().replace("\r\n", " ").trim();
        System.out.println(action + ": " + (elementText.isEmpty() ? "[non-visible element]" : elementText));
    } catch (Exception e) {
        System.out.println(action + ": [unable to retrieve element details]");
    }
}

*/
