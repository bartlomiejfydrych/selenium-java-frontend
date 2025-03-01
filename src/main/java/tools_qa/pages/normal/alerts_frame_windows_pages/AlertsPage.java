package tools_qa.pages.normal.alerts_frame_windows_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class AlertsPage extends BasePage {

    // https://demoqa.com/alerts

    // -----------
    // CONSTRUCTOR
    // -----------

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Click me buttons
    @FindBy(css = "#alertButton")
    private WebElement alertButton;
    @FindBy(css = "#timerAlertButton")
    private WebElement alertFiveSecondsButton;
    @FindBy(css = "#confirmButton")
    private WebElement alertConfirmButton;
    @FindBy(css = "#promtButton")
    private WebElement alertPromptButton;
    // Other
    @FindBy(css = "#confirmResult")
    private WebElement confirmAlertText;
    @FindBy(css = "#promptResult")
    private WebElement promptAlertText;

    // -------
    // METHODS
    // -------

    // Clicks

    public AlertsPage clickAlertButton() {
        alertButton.click();
        return this;
    }

    public AlertsPage clickAlertFiveSecondsButton() {
        alertFiveSecondsButton.click();
        return this;
    }

    public AlertsPage clickAlertConfirmButton() {
        alertConfirmButton.click();
        return this;
    }

    public AlertsPage clickAlertPromptButton() {
        alertPromptButton.click();
        return this;
    }

    // Alerts

    public Alert waitForAlert() {
        return defaultWait.until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertText() {
        return waitForAlert().getText();
    }

    public AlertsPage acceptAlert() {
        waitForAlert().accept();
        return this;
    }

    public AlertsPage dismissAlert() {
        waitForAlert().dismiss();
        return this;
    }

    public AlertsPage writeTextInAlertAndAccept(String textInAlert) {
        Alert alert = waitForAlert();
        alert.sendKeys(textInAlert);
        alert.accept();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getConfirmAlertText() {
        return confirmAlertText;
    }

    public WebElement getPromptAlertText() {
        return promptAlertText;
    }
}
