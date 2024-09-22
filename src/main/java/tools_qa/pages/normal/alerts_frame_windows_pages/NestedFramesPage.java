package tools_qa.pages.normal.alerts_frame_windows_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class NestedFramesPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "#frame1")
    private WebElement parentFrame;
    @FindBy(css = "iframe[srcdoc='<p>Child Iframe</p>']")
    private WebElement childFrame;
    @FindBy(css = "body")
    private WebElement parentFrameBody;
    @FindBy(css = "body p")
    private WebElement childFrameBody;

    // -------
    // METHODS
    // -------

    public NestedFramesPage switchToParentFrame() {
        driver.switchTo().frame(parentFrame);
        return this;
    }

    public NestedFramesPage switchToChildFrame() {
        driver.switchTo().frame(childFrame);
        return this;
    }

    public String getPageSource() {
        String pageSource = driver.getPageSource();
        return pageSource;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getParentFrameBody() {
        return parentFrameBody;
    }

    public WebElement getChildFrameBody() {
        return childFrameBody;
    }
}
