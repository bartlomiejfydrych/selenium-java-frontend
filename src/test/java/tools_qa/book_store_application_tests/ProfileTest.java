package tools_qa.book_store_application_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.book_store_application_pages.BookStorePage;
import tools_qa.pages.normal.book_store_application_pages.ProfilePage;
import tools_qa.providers.CookiesProvider;
import tools_qa.utils.WebElementMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfileTest extends TestBase {

    /*
    NOTES:
    - These tests require a logged-in user
    - When attempting to log out a user whose cookies were loaded from a file, after clicking the logout button,
      the user was not logged out...
    - There is no test for deleting a user, because after that a new one would have to be created manually
    - When I click on the book name, a blank page opens and nothing else happens.
      This makes larger and more thorough tests of the Book Store impossible, so I test everything I can.
    */

    private HomePage homePage;
    private TrainingPage trainingPage;
    private BookStorePage bookStorePage;
    private ProfilePage profilePage;

    private WebElementMethods webElementMethods;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        CookiesProvider.loadCookiesOrLogIn(driver);

        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        bookStorePage = new BookStorePage(driver);
        profilePage = new ProfilePage(driver);

        webElementMethods = new WebElementMethods(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToProfilePage() {
        homePage.goToBookStorePage();
        trainingPage.removeFooterAndAds();
        bookStorePage.goToProfilePage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldChangeNumberOfRows() {

        // -------
        // ARRANGE
        // -------

        List<String> rowsSelectValueList = Arrays.asList("10", "20", "25", "50", "100");
        Random random = new Random();
        String rowsSelectValue = rowsSelectValueList.get(random.nextInt(rowsSelectValueList.size()));
        int expectedRowCount = Integer.parseInt(rowsSelectValue);

        // ---
        // ACT
        // ---

        navigateToProfilePage();
        profilePage.waitForBooksTable()
                .selectRowsAmount(rowsSelectValue);

        // ------
        // ASSERT
        // ------

        assertThat(profilePage.getTableRows().size()).isEqualTo(expectedRowCount);
    }

    @Test
    public void shouldCancelDeleteAllBooks() {

        // -------
        // ARRANGE
        // -------

        WebElement deleteAllBooksModal = profilePage.getDeleteAllBooksModal();

        // ---
        // ACT
        // ---

        navigateToProfilePage();
        profilePage.waitForBooksTable()
                .clickDeleteAllBooksButton();
        webElementMethods.waitForElementToStopMoving(deleteAllBooksModal);
        profilePage.clickDeleteAllBooksModalCancelButton()
                .waitForDisappearDeleteAllBooksModal();

        // ------
        // ASSERT
        // ------

        assertThat(webElementMethods.isElementPresent(deleteAllBooksModal)).isFalse();
    }

    @Test
    public void shouldAlertAppearWhenTryingToDeleteAllBooksFromEmptyCollection() {

        // -------
        // ARRANGE
        // -------

        String alertText;
        String expectedAlertText = "No books available in your's collection!";

        // ---
        // ACT
        // ---

        navigateToProfilePage();
        profilePage.waitForBooksTable()
                .clickDeleteAllBooksButton();
        webElementMethods.waitForElementToStopMoving(profilePage.getDeleteAllBooksModal());
        profilePage.clickDeleteAllBooksModalOKButton();
        alertText = profilePage.getAlertText();
        profilePage.acceptAlert();

        // ------
        // ASSERT
        // ------

        assertThat(alertText).isEqualTo(expectedAlertText);
    }

    @Test
    public void shouldGoToBookStore() {

        // ---
        // ACT
        // ---

        navigateToProfilePage();
        profilePage.waitForBooksTable()
                .clickGoToBookStoreButton();
        bookStorePage.waitForBooksTable();

        // ------
        // ASSERT
        // ------

        assertThat(bookStorePage.getGitPocketGuideTitle().isDisplayed()).isTrue();
    }
}
