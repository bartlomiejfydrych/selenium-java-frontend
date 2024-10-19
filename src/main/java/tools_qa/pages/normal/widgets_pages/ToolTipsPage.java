package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class ToolTipsPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = ".tooltip-inner")
    private WebElement tooltipText;
    @FindBy(css = "#toolTipButton")
    private WebElement hoverButton;
    @FindBy(css = "#toolTipTextField")
    private WebElement hoverInput;
    @FindBy(css = "#texToolTopContainer a:nth-child(1)")
    private WebElement hoverContraryText;
    @FindBy(css = "#texToolTopContainer a:nth-child(2)")
    private WebElement hover11032Text;

    // -------
    // METHODS
    // -------

    public ToolTipsPage hoverOverButton() {
        actions.moveToElement(hoverButton).perform();
        defaultWait.until(ExpectedConditions.visibilityOf(tooltipText));
        return this;
    }

    public ToolTipsPage hoverOverInput() {
        actions.moveToElement(hoverInput).perform();
        defaultWait.until(ExpectedConditions.visibilityOf(tooltipText));
        return this;
    }

    public ToolTipsPage hoverOverContraryText() {
        actions.moveToElement(hoverContraryText).perform();
        defaultWait.until(ExpectedConditions.visibilityOf(tooltipText));
        return this;
    }

    public ToolTipsPage hoverOver11032Text() {
        actions.moveToElement(hover11032Text).perform();
        defaultWait.until(ExpectedConditions.visibilityOf(tooltipText));
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getTooltipText() {
        return tooltipText;
    }
}
