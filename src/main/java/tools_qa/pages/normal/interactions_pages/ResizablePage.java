package tools_qa.pages.normal.interactions_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class ResizablePage extends BasePage {

    // https://demoqa.com/resizable

    // -----------
    // CONSTRUCTOR
    // -----------

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "#resizableBoxWithRestriction")
    private WebElement boxWithRestriction;
    @FindBy(css = "#resizable")
    private WebElement boxWithoutRestriction;

    // -------
    // METHODS
    // -------

    public ResizablePage resizeBoxWithRestriction(int newWidth, int newHeight) {
        return resizeElement(boxWithRestriction, newWidth, newHeight);
    }

    public ResizablePage resizeBoxWithoutRestriction(int newWidth, int newHeight) {
        return resizeElement(boxWithoutRestriction, newWidth, newHeight);
    }

    // -------
    // HELPERS
    // -------

    private ResizablePage resizeElement(WebElement element, int newWidth, int newHeight) {
        String script = String.format("arguments[0].style.width='%dpx'; arguments[0].style.height='%dpx';", newWidth, newHeight);
        jse.executeScript(script, element);
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getBoxWithRestriction() {
        return boxWithRestriction;
    }

    public WebElement getBoxWithoutRestriction() {
        return boxWithoutRestriction;
    }
}
