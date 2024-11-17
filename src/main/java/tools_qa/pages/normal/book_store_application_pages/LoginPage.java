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

    // INPUTS
    @FindBy(css = "#userName")
    private WebElement userNameInput;
    @FindBy(css = "#password")
    private WebElement passwordInput;
    // BUTTONS
    @FindBy(css = "#login")
    private WebElement loginButton;
    @FindBy(css = "#newUser")
    private WebElement newUserButton;
    // MESSAGES
    @FindBy(css = "#output #name")
    private WebElement messageText;
    // HEADER (for RegisterTest)
    @FindBy(css = ".login-wrapper .text-center")
    private WebElement loginHeader;

    // -------
    // METHODS
    // -------

    // INPUTS

    public LoginPage writeUserName(String userName) {
        userNameInput.sendKeys(userName);
        return this;
    }

    public LoginPage writePassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    // BUTTONS

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public LoginPage clickNewUserButton() {
        newUserButton.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    // INPUTS

    public WebElement getUserNameInput() {
        return userNameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    // MESSAGES

    public WebElement getMessageText() {
        return messageText;
    }

    // HEADER

    public WebElement getLoginHeader() {
        return loginHeader;
    }
}
