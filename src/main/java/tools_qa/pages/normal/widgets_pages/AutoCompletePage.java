package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

import java.util.List;

public class AutoCompletePage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Multiple color input
    @FindBy(css = ".auto-complete__input #autoCompleteMultipleInput")
    private WebElement multipleColorInput;
    @FindBy(css = ".auto-complete__multi-value__label")
    private List<WebElement> colorsInInput;
    @FindBy(css = ".auto-complete__indicators .auto-complete__indicator")
    private WebElement clearMultipleColorInputButton;
    // Single color input
    @FindBy(css = "#autoCompleteSingleInput")
    private WebElement singleColorWriteInput;
    @FindBy(css = ".auto-complete__single-value")
    private WebElement singleColorReadInput;

    // -------
    // METHODS
    // -------

    // Multiple color input

    public AutoCompletePage writeColors(List<String> colorList) {
        multipleColorInput.click();
        for (String color : colorList) {
            multipleColorInput.sendKeys(color);
            multipleColorInput.sendKeys(Keys.ENTER);
        }
        return this;
    }

    public AutoCompletePage clearOneColor(String color) {
        String xpathAsString = "//div[text()='" + color + "']/following-sibling::div";
        WebElement oneColorClearButtonXpathLocator = driver.findElement((By.xpath(xpathAsString)));
        oneColorClearButtonXpathLocator.click();
        return this;
    }

    public AutoCompletePage clickClearMultipleColorInputButton() {
        clearMultipleColorInputButton.click();
        return this;
    }

    // Single color input

    public AutoCompletePage writeColorInSingleColorInput(String color) {
        singleColorWriteInput.sendKeys(color);
        singleColorWriteInput.sendKeys(Keys.ENTER);
        return this;
    }

    // -------
    // GETTERS
    // -------

    public List<WebElement> getColorsInInput() {
        return colorsInInput;
    }

    public WebElement getSingleColorReadInput() {
        return singleColorReadInput;
    }
}
