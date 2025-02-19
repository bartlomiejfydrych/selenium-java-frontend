package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testerczaki.pages.base.BasePage;

public class WiecejRamekPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public WiecejRamekPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "[src='/testerczaki/iframe2.php']")
    private WebElement iframe2;
    @FindBy(css = "[src='/testerczaki/iframe3.php']")
    private WebElement iframe3;
    @FindBy(css = "[src='/testerczaki/iframe4.php']")
    private WebElement iframe4;
    @FindBy(css = "[src='/testerczaki/iframe5.php']")
    private WebElement iframe5;

    // -------
    // METHODS
    // -------

    public WiecejRamekPage switchToIframe2() {
        driver.switchTo().frame(iframe2);
        return this;
    }

    public WiecejRamekPage switchToIframe3() {
        driver.switchTo().frame(iframe3);
        return this;
    }

    public WiecejRamekPage switchToIframe4() {
        driver.switchTo().frame(iframe4);
        return this;
    }

    public WiecejRamekPage switchToIframe5() {
        driver.switchTo().frame(iframe5);
        return this;
    }

    public WiecejRamekPage switchToParentFrame() {
        driver.switchTo().parentFrame();
        return this;
    }

    public WiecejRamekPage switchToDefaultContent() {
        driver.switchTo().defaultContent();
        return this;
    }
}
