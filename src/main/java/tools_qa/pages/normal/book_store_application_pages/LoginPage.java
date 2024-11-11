package tools_qa.pages.normal.book_store_application_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class LoginPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // HEADER (for RegisterTest)
    @FindBy(css = ".login-wrapper .text-center")
    private WebElement loginHeader;
    // BUTTONS
    @FindBy(css = "#newUser")
    private WebElement newUserButton;

    // -------
    // METHODS
    // -------

    public LoginPage clickNewUserButton() {
        newUserButton.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    // HEADER

    public WebElement getLoginHeader() {
        return loginHeader;
    }
}
