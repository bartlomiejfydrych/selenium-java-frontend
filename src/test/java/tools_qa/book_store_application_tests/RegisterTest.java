package tools_qa.book_store_application_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.models.RegisterUser;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.book_store_application_pages.BookStoreApplicationPage;
import tools_qa.pages.normal.book_store_application_pages.LoginPage;
import tools_qa.pages.normal.book_store_application_pages.RegisterPage;
import tools_qa.providers.RegisterUserProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterTest extends TestBase {

    // TODO: Add explanation NOTE

    HomePage homePage;
    TrainingPage trainingPage;
    BookStoreApplicationPage bookStoreApplicationPage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        bookStoreApplicationPage = new BookStoreApplicationPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void shouldCaptchaBlockUs() {

        // -------
        // ARRANGE
        // -------

        RegisterUser registerUser = RegisterUserProvider.getRandomRegisterUser();

        // ---
        // ACT
        // ---

        homePage.goToBookStoreApplicationPage();

        trainingPage.removeFooterAndAds();

        bookStoreApplicationPage.goToLoginPage();

        loginPage.clickNewUserButton();

        registerPage.fillRegisterForm(registerUser)
                .clickCaptcha()
                .switchAndWaitForCaptchaImageSelect();

        // ------
        // ASSERT
        // ------

        assertThat(registerPage.getCaptchaImageSelect().isDisplayed()).isTrue();
    }

    @Test
    public void shouldNotRegisterWithoutCaptcha() {

        // -------
        // ARRANGE
        // -------

        RegisterUser registerUser = RegisterUserProvider.getRandomRegisterUser();
        String expectedMessageText = "Please verify reCaptcha to register!";
        String expectedMessageColor = "rgba(255, 0, 0, 1)";

        // ---
        // ACT
        // ---

        homePage.goToBookStoreApplicationPage();

        trainingPage.removeFooterAndAds();

        bookStoreApplicationPage.goToLoginPage();

        loginPage.clickNewUserButton();

        registerPage.fillRegisterForm(registerUser)
                .clickRegisterButton();

        // ------
        // ASSERT
        // ------

        assertThat(registerPage.getMessageText().getText()).isEqualTo(expectedMessageText);
        assertThat(registerPage.getMessageText().getCssValue("color")).isEqualTo(expectedMessageColor);
    }

    @Test
    public void shouldRequireStrongPassword() {

    }

    @Test
    public void shouldRequireAllFields() {

    }

    @Test
    public void shouldBackToLoginButtonWork() {

    }
}
