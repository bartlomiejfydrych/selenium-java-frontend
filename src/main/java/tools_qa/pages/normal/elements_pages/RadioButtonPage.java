package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class RadioButtonPage extends BasePage {

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
    @FindBy(css = "noRadio")
    private WebElement noRadioButton;
    @FindBy(css = "span.text-success")
    private WebElement confirmationText;

    // -------
    // METHODS
    // -------

    public RadioButtonPage waitForConfirmationText() {
        defaultWait.until(ExpectedConditions.visibilityOf(confirmationText));
        return this;
    }

    public RadioButtonPage clickYesRadioButton() {
        actions.moveToElement(this.yesRadioButton).click().perform();
        waitForConfirmationText();
        return this;
    }

    public RadioButtonPage clickImpressiveRadioButton() {
        actions.moveToElement(this.impressiveRadioButton).click().perform();
        waitForConfirmationText();
        return this;
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
