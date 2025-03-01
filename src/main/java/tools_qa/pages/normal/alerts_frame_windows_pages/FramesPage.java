package tools_qa.pages.normal.alerts_frame_windows_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class FramesPage extends BasePage {

    // https://demoqa.com/frames

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

    public String getPageSource() {
        String pageSource = driver.getPageSource();
        return pageSource;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getFrameBody() {
        return frameBody;
    }

    public WebElement getFrameHeading() {
        return frameHeading;
    }
}
