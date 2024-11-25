package tools_qa.pages.normal.book_store_application_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class ProfilePage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(xpath = "//button[text()='Log out']")
    private WebElement logOutButton;

    // -------
    // METHODS
    // -------

    // WAITS

    public ProfilePage waitForLogOutButton() {
        defaultWait.until(ExpectedConditions.visibilityOf(logOutButton));
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getLogOutButton() {
        return logOutButton;
    }
}
