package tools_qa.pages.normal.alerts_frame_windows_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class AlertsPage extends BasePage {

    Alert alert;

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
    @FindBy(css = "#alertButton")
    private WebElement alertFiveSecondsButton;
    @FindBy(css = "#alertButton")
    private WebElement alertConfirmButton;
    @FindBy(css = "#alertButton")
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

    public AlertsPage waitForAlert() {
        defaultWait.until(ExpectedConditions.alertIsPresent());
        return this;
    }

    public String getAlertText() {
        String alertText = alert.getText();
        return alertText;
    }

    public AlertsPage acceptAlert() {
        alert.accept();
        return this;
    }

    public AlertsPage dismissAlert() {
        alert.dismiss();
        return this;
    }

    public AlertsPage writeTextInAlert(String textInAlert) {
        alert.sendKeys(textInAlert);
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
