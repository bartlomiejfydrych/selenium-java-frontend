package tools_qa.book_store_application_tests;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void shouldLogInCorrectly() {

        // -------
        // ARRANGE
        // -------

        Dotenv dotenv = Dotenv.load();
        String userName = dotenv.get("TQ_BSA_USERNAME");
        String password = dotenv.get("TQ_BSA_PASSWORD");
        ProfilePage profilePage = new ProfilePage(driver);

        // ---
        // ACT
        // ---

        homePage.goToBookStoreApplicationPage();

        trainingPage.removeFooterAndAds();

        bookStoreApplicationPage.goToLoginPage();

        loginPage.writeUserName(userName)
                .writePassword(password)
                .clickLoginButton();

        // ------
        // ASSERT
        // ------

        assertThat(profilePage.getLogOutButton().isDisplayed()).isTrue();
    }

    @Test
    public void shouldMarkEmptyFieldsInRed() {

        // -------
        // ARRANGE
        // -------

        String expectedClassName = "is-invalid";
        String expectedInputColor = "rgb(220, 53, 69)";

        // ---
        // ACT
        // ---

        homePage.goToBookStoreApplicationPage();

        trainingPage.removeFooterAndAds();

        bookStoreApplicationPage.goToLoginPage();

        loginPage.clickLoginButton();

        // ------
        // ASSERT
        // ------

        assertThat(loginPage.getUserNameInput().getAttribute("class")).contains(expectedClassName);
        assertThat(loginPage.getUserNameInput().getCssValue("border-color")).isEqualTo(expectedInputColor);
        assertThat(loginPage.getPasswordInput().getAttribute("class")).contains(expectedClassName);
        assertThat(loginPage.getPasswordInput().getCssValue("border-color")).isEqualTo(expectedInputColor);
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
                .clickLoginButton();

        // ------
        // ASSERT
        // ------

        assertThat(loginPage.getMessageText().getText()).isEqualTo(expectedMessage);
    }
}
