package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class RadioButtonPage extends BasePage {

    // https://demoqa.com/radio-button

    // -----------
    // CONSTRUCTOR
    // -----------

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "#yesRadio")
    private WebElement yesRadioButton;
    @FindBy(css = "#impressiveRadio")
    private WebElement impressiveRadioButton;
    @FindBy(css = "#noRadio")
    private WebElement noRadioButton;
    @FindBy(css = "span.text-success")
    private WebElement confirmationText;

    // -------
    // METHODS
    // -------

    public RadioButtonPage clickYesRadioButton() {
        clickRadioButton(yesRadioButton);
        return this;
    }

    public RadioButtonPage clickImpressiveRadioButton() {
        clickRadioButton(impressiveRadioButton);
        return this;
    }

    // -------
    // HELPERS
    // -------

    private void clickRadioButton(WebElement radioButton) {
        // NOTE:
        // I know that in IF there could be a simpler notation (!radioButton.isSelected()), but
        // I find this one more readable and understandable.
        boolean selectState = radioButton.isSelected();
        if (selectState == false) {
            actions.moveToElement(radioButton).click().perform();
            waitForConfirmationText();
        } else {
            throw new IllegalStateException("Radio button is already selected.");
        }
    }

    private void waitForConfirmationText() {
        defaultWait.until(ExpectedConditions.visibilityOf(confirmationText));
    }

    // -------
    // GETTERS
    // -------

    public WebElement getYesRadioButton() {
        return yesRadioButton;
    }

    public WebElement getImpressiveRadioButton() {
        return impressiveRadioButton;
    }

    public WebElement getNoRadioButton() {
        return noRadioButton;
    }

    public WebElement getConfirmationText() {
        return confirmationText;
    }
}
