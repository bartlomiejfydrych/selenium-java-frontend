package tools_qa.pages.normal.book_store_application_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class RegisterPage extends BasePage {

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

    // -------
    // METHODS
    // -------

    // INPUTS

    public RegisterPage writeFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterPage writeLastName(String lastName) {
        firstNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterPage writeUserName(String userName) {
        firstNameInput.sendKeys(userName);
        return this;
    }

    public RegisterPage writePassword(String password) {
        firstNameInput.sendKeys(password);
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
        defaultWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[title='reCAPTCHA']")));
        defaultWait.until(ExpectedConditions.visibilityOf(captchaFrame));
        driver.switchTo().frame(captchaFrame);
        defaultWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.recaptcha-checkbox-border")));
        defaultWait.until(ExpectedConditions.elementToBeClickable(captchaCheckbox));
        captchaCheckbox.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

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
}
