package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsercjaPage extends PodstawyPage {

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
