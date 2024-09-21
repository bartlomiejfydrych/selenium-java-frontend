package tools_qa.pages.normal.alerts_frame_windows_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class FramesPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "#frame1")
    private WebElement bigFrame;
    @FindBy(css = "#frame2")
    private WebElement smallFrame;
    @FindBy(css = "html")
    private WebElement frameHtml;
    @FindBy(css = "body")
    private WebElement frameBody;
    @FindBy(css = "#sampleHeading")
    private WebElement frameHeading;

    // -------
    // METHODS
    // -------

    public FramesPage switchToBigFrame() {
        driver.switchTo().frame(bigFrame);
        return this;
    }

    public FramesPage switchToSmallFrame() {
        driver.switchTo().frame(smallFrame);
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getBigFrame() {
        return bigFrame;
    }

    public WebElement getFrameBody() {
        return frameBody;
    }

    public WebElement getFrameHeading() {
        return frameHeading;
    }
}
