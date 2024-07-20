package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class ButtonsPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Buttons
    @FindBy(css = "#doubleClickBtn")
    private WebElement doubleClickMeButton;
    @FindBy(css = "#rightClickBtn")
    private WebElement rightClickMeButton;
    @FindBy(xpath = "//div/button[text()='Click Me']")
    private WebElement clickMeButton;
    // Messages
    @FindBy(css = "#doubleClickMessage")
    private WebElement doubleClickMessage;
    @FindBy(css = "#rightClickMessage")
    private WebElement rightClickMessage;
    @FindBy(css = "#dynamicClickMessage")
    private WebElement clickMessage;

    // -------
    // METHODS
    // -------

    // Buttons clicks

    public ButtonsPage clickDoubleClickMeButton() {
        actions.doubleClick(doubleClickMeButton).perform();
        return this;
    }

    public ButtonsPage clickRightClickMeButton() {
        actions.contextClick(rightClickMeButton).perform();
        return this;
    }

    public ButtonsPage clickClickMeButton() {
        clickMeButton.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getDoubleClickMessage() {
        return doubleClickMessage;
    }

    public WebElement getRightClickMessage() {
        return rightClickMessage;
    }

    public WebElement getClickMessage() {
        return clickMessage;
    }
}
