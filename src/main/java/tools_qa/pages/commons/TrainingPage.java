package tools_qa.pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

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

    // Footer
    @FindBy(css = "footer")
    private WebElement footer;
    // Ads
    @FindBy(css = "#fixedban")
    private WebElement footerAdFrame;
    @FindBy(xpath = "//div[@id='Ad.Plus-970x250-1']")
    private WebElement topAdFrame;
    @FindBy(xpath = "//div[@id='Ad.Plus-970x250-2']")
    private WebElement bottomAdFrame;

    // -------
    // METHODS
    // -------

    public TrainingPage removeFooterAndAds() {
        removeElements(footer, footerAdFrame, topAdFrame, bottomAdFrame);
        return this;
    }

    // -------
    // HELPERS
    // -------

    private void removeElements(WebElement... elements) {
        for (WebElement element : elements) {
            removeElement(element);
        }
    }

    private void removeElement(WebElement element) {
        if (element != null) {
            jse.executeScript("arguments[0].remove();", element);
        }
    }
}
