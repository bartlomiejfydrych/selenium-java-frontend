package tools_qa.tests.book_store_application_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.models_providers.book_store_application_models.register_user.RegisterUser;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.book_store_application_pages.BookStorePage;
import tools_qa.pages.normal.book_store_application_pages.LoginPage;
import tools_qa.pages.normal.book_store_application_pages.RegisterPage;
import tools_qa.models_providers.book_store_application_models.register_user.RegisterUserProvider;
import utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterTest extends TestBase {

    // https://demoqa.com/register

    /*
    NOTE:
    Due to the reCaptcha mechanism, it is not possible to automate full, correct user registration using Selenium.
    We will have to create an account ourselves and create an ENV file with its data, which will not be uploaded to GitHub.
    In the directory of this test collection, I will create a README file in which I will describe all the details.

    Here, there could be an additional test checking whether a message requiring a strong password appears, but
    to trigger it, we would first have to go through the reCaptcha mechanism.
    */

    private HomePage homePage;
    private TrainingPage trainingPage;
    private BookStorePage bookStorePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    private WebElementMethods webElementMethods;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        bookStorePage = new BookStorePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);

        webElementMethods = new WebElementMethods(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToRegisterPage() {
        homePage.goToBookStorePage();
        trainingPage.removeFooterAndAds();
        bookStorePage.goToLoginPage();
        loginPage.clickNewUserButton();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldCaptchaBlockUs() {

        /*
        NOTE:
        Sometimes this test will fail because reCaptcha lets us through...
        Well, that's what this test is for.

        I think that creating some special handling for this test or additional steps to register and remove such user
        makes no sense, because one test shouldn't check two random conditions.
        */

        // -------
        // ARRANGE
        // -------

        RegisterUser registerUser = RegisterUserProvider.getRandomRegisterUser();

        // ---
        // ACT
        // ---

        navigateToRegisterPage();
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

        navigateToRegisterPage();
        registerPage.fillRegisterForm(registerUser)
                .clickRegisterButton();

        // ------
        // ASSERT
        // ------

        assertThat(registerPage.getMessageText().getText()).isEqualTo(expectedMessageText);
        assertThat(registerPage.getMessageText().getCssValue("color")).isEqualTo(expectedMessageColor);
    }

    @Test
    public void shouldRequireAllFields() {

        // -------
        // ARRANGE
        // -------

        String expectedClassName = "is-invalid";
        String expectedInputColor = "rgb(220, 53, 69)";

        // ---
        // ACT
        // ---

        navigateToRegisterPage();
        registerPage.clickRegisterButton();
        webElementMethods.waitForElementToStopColorChanging(registerPage.getFirstNameInput(), "border-color", 2000);

        // ------
        // ASSERT
        // ------

        assertThat(registerPage.getFirstNameInput().getDomAttribute("class")).contains(expectedClassName);
        assertThat(registerPage.getFirstNameInput().getCssValue("border-color")).isEqualTo(expectedInputColor);
        assertThat(registerPage.getLastNameInput().getDomAttribute("class")).contains(expectedClassName);
        assertThat(registerPage.getLastNameInput().getCssValue("border-color")).isEqualTo(expectedInputColor);
        assertThat(registerPage.getUserNameInput().getDomAttribute("class")).contains(expectedClassName);
        assertThat(registerPage.getUserNameInput().getCssValue("border-color")).isEqualTo(expectedInputColor);
        assertThat(registerPage.getPasswordInput().getDomAttribute("class")).contains(expectedClassName);
        assertThat(registerPage.getPasswordInput().getCssValue("border-color")).isEqualTo(expectedInputColor);
    }

    @Test
    public void shouldBackToLoginButtonWork() {

        // -------
        // ARRANGE
        // -------

        String expectedLoginHeader = "Login";

        // ---
        // ACT
        // ---

        navigateToRegisterPage();
        registerPage.clickBackToLoginButton();

        // ------
        // ASSERT
        // ------

        assertThat(loginPage.getLoginHeader().getText()).isEqualTo(expectedLoginHeader);
    }
}
