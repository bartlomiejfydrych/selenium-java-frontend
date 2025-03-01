package tools_qa.tests.book_store_application_tests;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.book_store_application_pages.BookStorePage;
import tools_qa.pages.normal.book_store_application_pages.LoginPage;
import tools_qa.pages.normal.book_store_application_pages.ProfilePage;
import utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends TestBase {

    // https://demoqa.com/login

    private HomePage homePage;
    private TrainingPage trainingPage;
    private BookStorePage bookStorePage;
    private LoginPage loginPage;

    private WebElementMethods webElementMethods;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        bookStorePage = new BookStorePage(driver);
        loginPage = new LoginPage(driver);

        webElementMethods = new WebElementMethods(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToLoginPage() {
        homePage.goToBookStorePage();
        trainingPage.removeFooterAndAds();
        bookStorePage.goToLoginPage();
    }

    // -----
    // TESTS
    // -----

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

        navigateToLoginPage();

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

        navigateToLoginPage();
        loginPage.clickLoginButton();
        webElementMethods.waitForElementToStopColorChanging(userNameInput, cssValue, 2000);
        webElementMethods.waitForElementToStopColorChanging(passwordInput, cssValue, 2000);

        // ------
        // ASSERT
        // ------

        assertThat(userNameInput.getDomAttribute(attribute)).contains(expectedClassName);
        assertThat(userNameInput.getCssValue(cssValue)).isEqualTo(expectedInputColor);
        assertThat(passwordInput.getDomAttribute(attribute)).contains(expectedClassName);
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

        navigateToLoginPage();
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
