package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class TabsPage extends BasePage {

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
        whatTabButton.click();
        defaultWait.until(ExpectedConditions.visibilityOf(whatTabText));
        return this;
    }

    public TabsPage clickOriginTab() {
        originTabButton.click();
        defaultWait.until(ExpectedConditions.visibilityOf(originTabText1));
        return this;
    }

    public TabsPage clickUseTab() {
        useTabButton.click();
        defaultWait.until(ExpectedConditions.visibilityOf(useTabText));
        return this;
    }

    public TabsPage clickMoreTab() {
        try {
            moreTabButton.click();
        } catch (ElementClickInterceptedException e) {
        }
        return this;
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
