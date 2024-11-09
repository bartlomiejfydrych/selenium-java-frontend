package tools_qa.book_store_application_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.book_store_application_pages.BookStoreApplicationPage;
import tools_qa.pages.normal.book_store_application_pages.LoginPage;
import tools_qa.pages.normal.book_store_application_pages.RegisterPage;

public class RegisterTest extends TestBase {

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
    public void shouldCaptchaBlockUs() throws InterruptedException {

        // -------
        // ARRANGE
        // -------

        // ---
        // ACT
        // ---

        homePage.goToBookStoreApplicationPage();

        trainingPage.removeFooterAndAds();

        bookStoreApplicationPage.goToLoginPage();

        loginPage.clickNewUserButton();

        //Thread.sleep(3000);

        registerPage.clickCaptcha();

        Thread.sleep(5000);

        // ------
        // ASSERT
        // ------
    }
}
