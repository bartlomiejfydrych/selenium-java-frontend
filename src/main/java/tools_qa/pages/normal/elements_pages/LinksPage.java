package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

import java.util.ArrayList;

public class LinksPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

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

    // -------
    // METHODS
    // -------

    // Links - new tab

    public LinksPage clickNewTabHomeLink() {
        return clickLinkAndWaitForNewTab(homeLink);
    }

    public LinksPage clickNewTabHomeDynamicLink() {
        return clickLinkAndWaitForNewTab(homeDynamicLink);
    }

    public LinksPage switchTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
        return this;
    }

    // Links - api call

    public LinksPage clickCreatedLink() {
        createdLink.click();
        return this;
    }

    public LinksPage clickNoContentLink() {
        noContentLink.click();
        return this;
    }

    public LinksPage clickMovedLink() {
        movedLink.click();
        return this;
    }

    public LinksPage clickBadRequestLink() {
        badRequestLink.click();
        return this;
    }

    public LinksPage clickUnauthorizedLink() {
        unauthorizedLink.click();
        return this;
    }

    public LinksPage clickForbiddenLink() {
        forbiddenLink.click();
        return this;
    }

    public LinksPage clickNotFoundLink() {
        notFoundLink.click();
        return this;
    }

    // Message

    public String getTextLinkResponseMessage(String expectedText) {
        defaultWait.until(ExpectedConditions.textToBePresentInElement(linkResponseMessage, expectedText));
        return linkResponseMessage.getText();
    }

    // -------
    // HELPERS
    // -------

    private LinksPage clickLinkAndWaitForNewTab(WebElement link) {
        link.click();
        defaultWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }
}
