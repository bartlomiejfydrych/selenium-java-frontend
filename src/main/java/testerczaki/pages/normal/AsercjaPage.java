package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testerczaki.pages.base.BasePage;

public class AsercjaPage extends BasePage {

    /*
    NOTE:
    This page uses the same elements and methods as the 'PodstawyPage'.
    */

    // -----------
    // CONSTRUCTOR
    // -----------

    public AsercjaPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(id = "rulesLabel")
    private WebElement regulaminCheckbox;

    // -------
    // METHODS
    // -------

    public AsercjaPage checkRegulaminCheckbox() {
        regulaminCheckbox.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getRegulaminCheckbox() {
        return regulaminCheckbox;
    }
}
