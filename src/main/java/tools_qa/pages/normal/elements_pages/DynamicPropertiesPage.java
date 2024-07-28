package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class DynamicPropertiesPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(xpath = "//div//p")
    private WebElement randomIdText;
    @FindBy(css = "#enableAfter")
    private WebElement enableFiveSecondsButton;
    @FindBy(css = "#colorChange")
    private WebElement colorChangeButton;
    @FindBy(css = "#visibleAfter")
    private WebElement visibleFiveSecondsButton;

    // -------
    // METHODS
    // -------

    // Button 1 (enable after 5 seconds)

    public WebElement waitForButtonBeClickable() {
        WebElement buttonClickable = defaultWait.until(ExpectedConditions.elementToBeClickable(enableFiveSecondsButton));
        return buttonClickable;
    }

    // Button 2 (change color after some time)

    public String getButtonColor() {
        String buttonColor = colorChangeButton.getCssValue("color");
        return buttonColor;
    }

    public boolean waitForButtonChangeColor(String startColor) {
        boolean colorChanged = defaultWait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(colorChangeButton, "color", startColor)));
        return colorChanged;
    }

    // Button 3 (visible after 5 seconds)

    public WebElement waitForButtonBeVisible() {
        WebElement buttonVisible = defaultWait.until(ExpectedConditions.visibilityOf(visibleFiveSecondsButton));
        return buttonVisible;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getRandomIdText() {
        return randomIdText;
    }
}
