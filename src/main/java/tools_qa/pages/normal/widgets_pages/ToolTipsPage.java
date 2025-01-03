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
        return hoverOverElementAndWait(hoverButton);
    }

    public ToolTipsPage hoverOverInput() {
        return hoverOverElementAndWait(hoverInput);
    }

    public ToolTipsPage hoverOverContraryText() {
        return hoverOverElementAndWait(hoverContraryText);
    }

    public ToolTipsPage hoverOver11032Text() {
        return hoverOverElementAndWait(hover11032Text);
    }

    // -------
    // HELPERS
    // -------

    private ToolTipsPage hoverOverElementAndWait(WebElement element) {
        try {
            actions.moveToElement(element).perform();
            defaultWait.until(ExpectedConditions.visibilityOf(tooltipText));
        } catch (Exception e) {
            throw new RuntimeException("Error while hovering over element: " + element, e);
        }
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getTooltipText() {
        return tooltipText;
    }
}
