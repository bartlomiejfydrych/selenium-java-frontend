package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testerczaki.pages.base.BasePage;

public class RamkaPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public RamkaPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(id = "frame")
    private WebElement iframe1;

    // -------
    // METHODS
    // -------

    public RamkaPage switchToIframe1() {
        driver.switchTo().frame(iframe1);
        return this;
    }

    public RamkaPage switchToDefaultContent() {
        driver.switchTo().defaultContent();
        return this;
    }
}
