package tools_qa.pages.normal.book_store_application_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.models_providers.book_store_application_models.register_user.RegisterUser;
import tools_qa.pages.base.BasePage;

public class RegisterPage extends BasePage {

    // https://demoqa.com/register

    // -----------
    // CONSTRUCTOR
    // -----------

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // INPUTS
    @FindBy(css = "#firstname")
    private WebElement firstNameInput;
    @FindBy(css = "#lastname")
    private WebElement lastNameInput;
    @FindBy(css = "#userName")
    private WebElement userNameInput;
    @FindBy(css = "#password")
    private WebElement passwordInput;
    // BUTTONS
    @FindBy(css = "#register")
    private WebElement registerButton;
    @FindBy(css = "#gotologin")
    private WebElement backToLoginButton;
    // CAPTCHA
    @FindBy(css = "iframe[title='reCAPTCHA']")
    private WebElement captchaFrame;
    @FindBy(css = ".recaptcha-checkbox-border")
    private WebElement captchaCheckbox;
    @FindBy(css = "iframe[title='recaptcha challenge expires in two minutes']")
    private WebElement captchaImageSelectFrame;
    @FindBy(css = "#rc-imageselect")
    private WebElement captchaImageSelect;
    // MESSAGES
    @FindBy(css = "#output #name")
    private WebElement messageText;

    // -------
    // METHODS
    // -------

    // BUILDER

    public RegisterPage fillRegisterForm(RegisterUser registerUser) {
        writeFirstName(registerUser.getFirstName());
        writeLastName(registerUser.getLastName());
        writeUserName(registerUser.getUserName());
        writePassword(registerUser.getPassword());
        return this;
    }

    // INPUTS

    public RegisterPage writeFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterPage writeLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterPage writeUserName(String userName) {
        userNameInput.sendKeys(userName);
        return this;
    }

    public RegisterPage writePassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    // BUTTONS

    public RegisterPage clickRegisterButton() {
        registerButton.click();
        return this;
    }

    public RegisterPage clickBackToLoginButton() {
        backToLoginButton.click();
        return this;
    }

    // CAPTCHA

    public RegisterPage clickCaptcha() {
        defaultWait.until(ExpectedConditions.visibilityOf(captchaFrame));
        driver.switchTo().frame(captchaFrame);
        defaultWait.until(ExpectedConditions.elementToBeClickable(captchaCheckbox));
        captchaCheckbox.click();
        return this;
    }

    public RegisterPage switchAndWaitForCaptchaImageSelect() {
        driver.switchTo().defaultContent();
        defaultWait.until(ExpectedConditions.visibilityOf(captchaImageSelectFrame));
        driver.switchTo().frame(captchaImageSelectFrame);
        defaultWait.until(ExpectedConditions.elementToBeClickable(captchaImageSelect));
        return this;
    }

    // -------
    // GETTERS
    // -------

    // INPUTS

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getUserNameInput() {
        return userNameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    // CAPTCHA

    public WebElement getCaptchaImageSelect() {
        return captchaImageSelect;
    }

    // MESSAGES

    public WebElement getMessageText() {
        return messageText;
    }
}
