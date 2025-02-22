package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testerczaki.pages.base.BasePage;

public class KliknijPrzytrzymajPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public KliknijPrzytrzymajPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Zadanie 1
    @FindBy(id = "contextClick")
    private WebElement z1KliknijTutajButton;
    @FindBy(css = ".list-group > li:nth-child(2)")
    private WebElement z1Opcja2Button;
    @FindBy(id = "alert1")
    private WebElement z1Alert;
    // Zadanie 2
    @FindBy(id = "holdClick")
    private WebElement z2KliknijPrzytrzymajTutajButton;
    @FindBy(id = "alert2")
    private WebElement z2Alert;

    // -------
    // METHODS
    // -------

    // Zadanie 1

    public KliknijPrzytrzymajPage z1ClickRightKliknijTutajButton() {
        actions.contextClick(z1KliknijTutajButton).perform();
        return this;
    }

    public KliknijPrzytrzymajPage z1ClickOpcja2Button() {
        z1Opcja2Button.click();
        return this;
    }

    // Zadanie 2

    public KliknijPrzytrzymajPage z2ClickAndHoldKliknijPrzytrzymajButton() {
        actions.clickAndHold(z2KliknijPrzytrzymajTutajButton).pause(3100).release().perform();
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
}
