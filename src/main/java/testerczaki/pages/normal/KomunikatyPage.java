package testerczaki.pages.normal;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testerczaki.pages.base.BasePage;

public class KomunikatyPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public KomunikatyPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(id = "msg")
    private WebElement komunikatInput;
    @FindBy(id = "msgBtn")
    private WebElement wyswietlKomunikatButton;
    @FindBy(id = "submit")
    private WebElement sprawdzButton;
    @FindBy(id = "alert")
    private WebElement gratulacjeAlert;

    // -------
    // METHODS
    // -------

    public KomunikatyPage clickWyswietlKomunikatButton() {
        wyswietlKomunikatButton.click();
        return this;
    }

    public KomunikatyPage writeKomunikat(String komunikatTextFromAlert) {
        komunikatInput.sendKeys(komunikatTextFromAlert);
        return this;
    }

    public KomunikatyPage clickSprawdzButton() {
        sprawdzButton.click();
        return this;
    }

    // Alerts

    public Alert waitForAlert() {
        return defaultWait.until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertText() {
        return waitForAlert().getText();
    }

    public KomunikatyPage acceptAlert() {
        waitForAlert().accept();
        return this;
    }

    public KomunikatyPage dismissAlert() {
        waitForAlert().dismiss();
        return this;
    }

    public KomunikatyPage writeTextInAlertAndAccept(String textInAlert) {
        Alert alert = waitForAlert();
        alert.sendKeys(textInAlert);
        alert.accept();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getGratulacjeAlert() {
        return gratulacjeAlert;
    }
}
