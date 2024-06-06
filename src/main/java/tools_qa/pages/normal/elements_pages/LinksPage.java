package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class LinksPage extends BasePage {

    //------------
    // CONSTRUCTOR
    //------------

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    //-------------
    // WEB ELEMENTS
    //-------------

    // Links - new tab
    @FindBy(css = "#simpleLink")
    private WebElement homeLink;
    @FindBy(css = "#dynamicLink")
    private WebElement homeDynamicLink;
    // Links - api call
    @FindBy(css = "#created")
    private WebElement createdLink;
    @FindBy(css = "#no-content")
    private WebElement noContentLink;
    @FindBy(css = "#moved")
    private WebElement movedLink;
    @FindBy(css = "#bad-request")
    private WebElement badRequestLink;
    @FindBy(css = "#unauthorized")
    private WebElement unauthorizedLink;
    @FindBy(css = "#forbidden")
    private WebElement forbiddenLink;
    @FindBy(css = "#invalid-url")
    private WebElement notFoundLink;
    // Message
    @FindBy(css = "p#linkResponse")
    private WebElement linkResponseMessage;

    //--------
    // METHODS
    //--------

    // Links - new tab

    public LinksPage clickNewTabHomeLink() {
        homeLink.click();
        defaultWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public LinksPage clickNewTabHomeDynamicLink() {
        homeDynamicLink.click();
        defaultWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public LinksPage switchTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
        return this;
    }

    // Links - api call

    public LinksPage clickCreatedLink() {
        createdLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    public LinksPage clickNoContentLink() {
        noContentLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    public LinksPage clickMovedLink() {
        movedLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    public LinksPage clickBadRequestLink() {
        badRequestLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    public LinksPage clickUnauthorizedLink() {
        unauthorizedLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    public LinksPage clickForbiddenLink() {
        forbiddenLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    public LinksPage clickNotFoundLink() {
        notFoundLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    // Message

    public String getTextLinkResponseMessage() {
        jse.executeScript("arguments[0].scrollIntoView(true);", linkResponseMessage);
        return linkResponseMessage.getText();
    }

    //--------
    // GETTERS
    //--------

    public WebElement getLinkResponseMessage() {
        return linkResponseMessage;
    }
}
