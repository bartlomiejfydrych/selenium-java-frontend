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
    // Footer AD
    @FindBy(css = "#fixedban")
    private WebElement footerAdFrame;
    // Top AD
    @FindBy(xpath = "//div[@id='Ad.Plus-970x250-1']")
    private WebElement topAdFrame;
    // Bottom AD
    @FindBy(xpath = "//div[@id='Ad.Plus-970x250-2']")
    private WebElement bottomAdFrame;

    // -------
    // METHODS
    // -------

    public TrainingPage removeFooterAndAds() {
        removeFooter();
        removeFooterAD();
        removeTopAD();
        removeBottomAD();
        return this;
    }

    public TrainingPage removeFooter() {
        jse.executeScript("arguments[0].remove();", footer);
        return this;
    }

    public TrainingPage removeFooterAD() {
        jse.executeScript("arguments[0].remove();", footerAdFrame);
        return this;
    }

    public TrainingPage removeTopAD() {
        jse.executeScript("arguments[0].remove();", topAdFrame);
        return this;
    }

    public TrainingPage removeBottomAD() {
        jse.executeScript("arguments[0].remove();", bottomAdFrame);
        return this;
    }
}
