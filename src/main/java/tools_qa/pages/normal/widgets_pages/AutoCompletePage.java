package tools_qa.pages.normal.widgets_pages;

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

    // Multiple color
    @FindBy(css = ".auto-complete__input #autoCompleteMultipleInput")
    private WebElement multipleColorInput;
    @FindBy(css = ".auto-complete__multi-value__label")
    private List<WebElement> colorsInInput;
    @FindBy(css = ".auto-complete__indicators .auto-complete__indicator")
    private WebElement clearMultipleColorInputButton;
    // Single color
    @FindBy(css = "#autoCompleteSingle #autoCompleteSingleContainer .auto-complete__control .auto-complete__value-container")
    private WebElement singleColorInput;

    // -------
    // METHODS
    // -------

    public AutoCompletePage writeColors(List<String> colorList) {
        multipleColorInput.click();
        for (String color : colorList) {
            multipleColorInput.sendKeys(color);
            multipleColorInput.sendKeys(Keys.ENTER);
        }
        return this;
    }

    public AutoCompletePage clickClearMultipleColorInputButton() {
        clearMultipleColorInputButton.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public List<WebElement> getColorsInInput() {
        return colorsInInput;
    }
}
