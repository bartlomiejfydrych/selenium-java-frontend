package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class SelectMenuPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // SELECT VALUE
    @FindBy(css = "#withOptGroup")
    private WebElement selectValueSelect;
    // Value xpath selector
    // //div[text()='Group 1, option 1']
    @FindBy(css = ".css-1uccc91-singleValue")
    private WebElement selectValueValue;
    // SELECT ONE

    // -------
    // METHODS
    // -------

    public SelectMenuPage selectValueInSelectValue(String value) {
        String selectValueSelector = "//div[text()='" + value + "']";
        WebElement selectValueLocator = driver.findElement(By.xpath(selectValueSelector));
        selectValueSelect.click();
        selectValueLocator.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getSelectValueValue() {
        return selectValueValue;
    }
}
