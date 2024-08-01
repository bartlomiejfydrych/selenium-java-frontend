package tools_qa.pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;
import tools_qa.pages.normal.elements_pages.ElementsPage;

public class TrainingPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public TrainingPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Ad
    @FindBy(css = "#fixedban")
    private WebElement adFrame;
    // Footer
    @FindBy(css = "footer")
    private WebElement footer;

    // -------
    // METHODS
    // -------

    public TrainingPage removeAdFrameAndFooter() {
        jse.executeScript("arguments[0].remove();", adFrame);
        jse.executeScript("arguments[0].remove();", footer);
        return this;
    }
}
