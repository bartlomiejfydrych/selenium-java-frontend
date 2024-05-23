package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class RadioButtonPage extends BasePage {

    // Konstruktor

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    // Web Elementy

    @FindBy(css = "#yesRadio")
    private WebElement yesRadioButton;
    @FindBy(css = "#impressiveRadio")
    private WebElement impressiveRadioButton;
    @FindBy(css = "noRadio")
    private WebElement noRadioButton;
    @FindBy(css = "span.text-success")
    private WebElement confirmationText;

    // Metody

    public RadioButtonPage clickYesRadioButton() {
        actions.moveToElement(this.yesRadioButton).click().perform();
        return this;
    }

    public RadioButtonPage clickImpressiveRadioButton() {
        actions.moveToElement(this.impressiveRadioButton).click().perform();
        return this;
    }

    public RadioButtonPage clickNoRadioButton() {
        actions.moveToElement(this.noRadioButton).click().perform();
        return this;
    }

    public String getConfirmationText() {
        return confirmationText.getText();
    }

    // Gettery dla asercji

    public WebElement getYesRadioButton() {
        return yesRadioButton;
    }

    public WebElement getImpressiveRadioButton() {
        return impressiveRadioButton;
    }

    public WebElement getNoRadioButton() {
        return noRadioButton;
    }
}
