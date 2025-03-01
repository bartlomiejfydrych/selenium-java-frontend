package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class TabsPage extends BasePage {

    // https://demoqa.com/tabs

    // -----------
    // CONSTRUCTOR
    // -----------

    public TabsPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // What
    @FindBy(css = "#demo-tab-what")
    private WebElement whatTabButton;
    @FindBy(css = "#demo-tabpane-what p")
    private WebElement whatTabText;
    // Origin
    @FindBy(css = "#demo-tab-origin")
    private WebElement originTabButton;
    @FindBy(css = "#demo-tabpane-origin p:nth-child(1)")
    private WebElement originTabText1;
    @FindBy(css = "#demo-tabpane-origin p:nth-child(2)")
    private WebElement originTabText2;
    // Use
    @FindBy(css = "#demo-tab-use")
    private WebElement useTabButton;
    @FindBy(css = "#demo-tabpane-use p")
    private WebElement useTabText;
    // More
    @FindBy(css = "#demo-tab-more")
    private WebElement moreTabButton;

    // -------
    // METHODS
    // -------

    public TabsPage clickWhatTab() {
        clickTabAndWait(whatTabButton, whatTabText);
        return this;
    }

    public TabsPage clickOriginTab() {
        clickTabAndWait(originTabButton, originTabText1);
        return this;
    }

    public TabsPage clickUseTab() {
        clickTabAndWait(useTabButton, useTabText);
        return this;
    }

    public TabsPage clickMoreTab() {
        try {
            moreTabButton.click();
        } catch (ElementClickInterceptedException e) {
            // This error is intentionally not handled to avoid unnecessary messages in the console.
        }
        return this;
    }

    // -------
    // HELPERS
    // -------

    private void clickTabAndWait(WebElement tabButton, WebElement tabContentArea) {
        tabButton.click();
        defaultWait.until(ExpectedConditions.visibilityOf(tabContentArea));
    }

    // -------
    // GETTERS
    // -------

    public WebElement getWhatTabText() {
        return whatTabText;
    }

    public WebElement getOriginTabText1() {
        return originTabText1;
    }

    public WebElement getOriginTabText2() {
        return originTabText2;
    }

    public WebElement getUseTabText() {
        return useTabText;
    }

    public WebElement getMoreTabButton() {
        return moreTabButton;
    }
}
