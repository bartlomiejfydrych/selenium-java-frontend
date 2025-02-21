package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testerczaki.pages.base.BasePage;

public class MenuPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Zadanie 1
    @FindBy(css = ".navbar-expand> .collapse > .navbar-nav > a:nth-child(2)")
    private WebElement z1Link2Button;
    @FindBy(id = "alert1")
    private WebElement z1Alert;
    // Zadanie 2
    @FindBy(css = ".m-2")
    private WebElement z2RozwinButton;
    @FindBy(css = "#navbarNavAltMarkup > .navbar-nav > a:nth-child(3)")
    private WebElement z2Link3Button;
    @FindBy(id = "alert2")
    private WebElement z2Alert;
    // Zadanie 3
    @FindBy(css = "[role=\"button\"]")
    private WebElement z3Link3Button;
    @FindBy(css = ".show > a:nth-child(3)")
    private WebElement z3Link3CButton;
    @FindBy(id = "alert3")
    private WebElement z3Alert;
    // Zadanie 4
    @FindBy(xpath = "(//a[contains(@class,\"dropdown-toggle\")])[2]")
    private WebElement z4Link3;
    @FindBy(xpath = "(//div[contains(@class,\"dropdown-menu\")])[2]/a[2]")
    private WebElement z4Link3BButton;
    @FindBy(id = "alert4")
    private WebElement z4Alert;
    // Zadanie 5
    @FindBy(xpath = "(//a[contains(@class,\"dropdown-toggle\")])[3]")
    private WebElement z5Link3;
    @FindBy(css = ".hover2nd")
    private WebElement z5Link3B;
    @FindBy(css = ".dropdown2nd > a:nth-child(1)")
    private WebElement z5Link3B1;
    @FindBy(css = ".dropdown2nd > a:nth-child(5)")
    private WebElement z5Link3B5Button;
    @FindBy(id = "alert5")
    private WebElement z5Alert;

    // -------
    // METHODS
    // -------

    // Zadanie 1

    public MenuPage z1ClickLink2Button() {
        z1Link2Button.click();
        return this;
    }

    // Zadanie 2

    public MenuPage z2ClickRozwinListeButton() {
        z2RozwinButton.click();
        return this;
    }

    public MenuPage z2ClickLink3Button() {
        defaultWait.until(ExpectedConditions.visibilityOf(z2Link3Button));
        z2Link3Button.click();
        return this;
    }

    // Zadanie 3

    public MenuPage z3ClickLink3Button() {
        z3Link3Button.click();
        return this;
    }

    public MenuPage z3ClickLink3C() {
        z3Link3CButton.click();
        return this;
    }

    // Zadanie 4

    public MenuPage z4ClickLink3BButton() {
        actions.moveToElement(z4Link3)
                .moveToElement(z4Link3BButton).click().perform();
        return this;
    }

    // Zadanie 5

    public MenuPage z5ClickLink3B5Button() {
        actions.moveToElement(z5Link3)
                .moveToElement(z5Link3B)
                .moveToElement(z5Link3B1)
                .moveToElement(z5Link3B5Button).click().perform();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getZ1Alert() {
        return z1Alert;
    }

    public WebElement getZ2Alert() {
        return z2Alert;
    }

    public WebElement getZ3Alert() {
        return z3Alert;
    }

    public WebElement getZ4Alert() {
        return z4Alert;
    }

    public WebElement getZ5Alert() {
        return z5Alert;
    }
}
