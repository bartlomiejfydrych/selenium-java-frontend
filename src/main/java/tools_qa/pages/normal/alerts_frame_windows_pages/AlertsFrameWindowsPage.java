package tools_qa.pages.normal.alerts_frame_windows_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class AlertsFrameWindowsPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Browser Windows']")
    private WebElement browserWindowsButton;

    // -------
    // METHODS
    // -------

    public BrowserWindowsPage goToBrowserWindowsPage() {
        browserWindowsButton.click();
        return new BrowserWindowsPage(driver);
    }
}
