package tools_qa.book_store_application_tests;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.book_store_application_pages.BookStoreApplicationPage;
import tools_qa.pages.normal.book_store_application_pages.LoginPage;
import tools_qa.pages.normal.book_store_application_pages.ProfilePage;
import tools_qa.utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    BookStoreApplicationPage bookStoreApplicationPage;
    LoginPage loginPage;

    WebElementMethods webElementMethods;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        bookStoreApplicationPage = new BookStoreApplicationPage(driver);
        loginPage = new LoginPage(driver);

        webElementMethods = new WebElementMethods(driver);
    }

    @Test
    public void shouldLogInAndLogOutUserCorrectly() {

        // -------
        // ARRANGE
        // -------

        Dotenv dotenv = Dotenv.configure().directory("./environment").load();
        String userName = dotenv.get("TQ_BSA_USERNAME");
        String password = dotenv.get("TQ_BSA_PASSWORD");
        ProfilePage profilePage = new ProfilePage(driver);

        // ------------
        // ACT + ASSERT
        // ------------

        homePage.goToBookStoreApplicationPage();

        trainingPage.removeFooterAndAds();

        bookStoreApplicationPage.goToLoginPage();

        // LOG IN

        loginPage.writeUserName(userName)
                .writePassword(password)
                .clickLoginButton();

        profilePage.waitForLogOutButton();

        assertThat(profilePage.getLogOutButton().isDisplayed()).isTrue();
        assertThat(profilePage.getUserNameValue().getText()).isEqualTo(userName);

        // LOG OUT

        profilePage.clickLogOutButton();

        assertThat(loginPage.getLoginHeader().getText()).isEqualTo("Login");
    }

    @Test
    public void shouldMarkEmptyFieldsInRed() {

        // -------
        // ARRANGE
        // -------

        String expectedClassName = "is-invalid";
        String expectedInputColor = "rgb(220, 53, 69)";
        String attribute = "class";
        String cssValue = "border-color";
        WebElement userNameInput = loginPage.getUserNameInput();
        WebElement passwordInput = loginPage.getPasswordInput();

        // ---
        // ACT
        // ---

        homePage.goToBookStoreApplicationPage();

        trainingPage.removeFooterAndAds();

        bookStoreApplicationPage.goToLoginPage();

        loginPage.clickLoginButton();

        webElementMethods.waitForElementToStopColorChanging(userNameInput, cssValue);
        webElementMethods.waitForElementToStopColorChanging(passwordInput, cssValue);

        // ------
        // ASSERT
        // ------

        assertThat(userNameInput.getAttribute(attribute)).contains(expectedClassName);
        assertThat(userNameInput.getCssValue(cssValue)).isEqualTo(expectedInputColor);
        assertThat(passwordInput.getAttribute(attribute)).contains(expectedClassName);
        assertThat(passwordInput.getCssValue(cssValue)).isEqualTo(expectedInputColor);
    }

    @Test
    public void shouldNotLogInNonExistentUser() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Invalid username or password!";

        // ---
        // ACT
        // ---

        homePage.goToBookStoreApplicationPage();

        trainingPage.removeFooterAndAds();

        bookStoreApplicationPage.goToLoginPage();

        loginPage.writeUserName("TestNonExistUserName")
                .writePassword("TestNonExistPassword")
                .clickLoginButton()
                .waitForMessageText();

        // ------
        // ASSERT
        // ------

        assertThat(loginPage.getMessageText().getText()).isEqualTo(expectedMessage);
    }
}
