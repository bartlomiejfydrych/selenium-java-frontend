package tools_qa.pages.normal.alerts_frame_windows_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

import java.util.ArrayList;

public class BrowserWindowsPage extends BasePage {

    // https://demoqa.com/browser-windows

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
    // New Tab/Window page
    @FindBy(css = "#sampleHeading")
    private WebElement newTabWindowText;
    @FindBy(tagName = "body")
    private WebElement newTabWindowBody;

    // -------
    // METHODS
    // -------

    public BrowserWindowsPage clickNewTabButton() {
        newTabButton.click();
        waitForNewTabOrWindow();
        return this;
    }

    public BrowserWindowsPage clickNewWindowButton() {
        newWindowButton.click();
        waitForNewTabOrWindow();
        return this;
    }

    public BrowserWindowsPage switchTabOrWindow(int tabOrWindowNumber) {
        ArrayList<String> tabOrWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabOrWindow.get(tabOrWindowNumber));
        return this;
    }

    public BrowserWindowsPage switchTabOrWindowAndMaximize(int tabOrWindowNumber) {
        switchTabOrWindow(tabOrWindowNumber);
        if (tabOrWindowNumber > 0) {
            driver.manage().window().maximize();
        }
        return this;
    }

    // -------
    // HELPERS
    // -------

    private void waitForNewTabOrWindow() {
        defaultWait.until(ExpectedConditions.numberOfWindowsToBe(2));
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
