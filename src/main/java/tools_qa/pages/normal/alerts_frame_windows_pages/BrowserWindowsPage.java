package tools_qa.pages.normal.alerts_frame_windows_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

import java.util.ArrayList;

public class BrowserWindowsPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // New Tab
    @FindBy(css = "#tabButton")
    private WebElement newTabButton;
    // New Window
    @FindBy(css = "#windowButton")
    private WebElement newWindowButton;
    // New Window Message
    @FindBy(css = "#messageWindowButton")
    private WebElement newWindowMessageButton;
    // New Tab/Window page
    @FindBy(css = "#sampleHeading")
    private WebElement newTabWindowText;
    @FindBy(css = "body")
    private WebElement newTabWindowBody;

    // -------
    // METHODS
    // -------

    public BrowserWindowsPage clickNewTabButton() {
        newTabButton.click();
        defaultWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public BrowserWindowsPage clickNewWindowButton() {
        newWindowButton.click();
        defaultWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public BrowserWindowsPage clickNewWindowMessageButton() {
        newWindowMessageButton.click();
        defaultWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public BrowserWindowsPage switchTabOrWindow(int tabOrWindowNumber) {
        ArrayList<String> tabOrWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabOrWindow.get(tabOrWindowNumber));
        if (tabOrWindowNumber > 0) {
            driver.manage().window().maximize();
        }
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getNewTabWindowText() {
        return newTabWindowText;
    }

    public WebElement getNewTabWindowBody() {
        return newTabWindowBody;
    }
}
