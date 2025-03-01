package tools_qa.tests.book_store_application_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.book_store_application_pages.BookStorePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookStoreTest extends TestBase {

    // https://demoqa.com/books

    /*
    NOTES:
    When I click on the book name, a blank page opens and nothing else happens.
    This makes larger and more thorough tests of the Book Store impossible, so I test everything I can.
    */

    private HomePage homePage;
    private TrainingPage trainingPage;
    private BookStorePage bookStorePage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        bookStorePage = new BookStorePage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToBookStorePage() {
        homePage.goToBookStorePage();
        trainingPage.removeFooterAndAds();
    }

    private void assertRowsData(String[][] expectedRows) {
        for (int i = 0; i < expectedRows.length; i++) {
            assertThat(bookStorePage.isRowDataValid(i, expectedRows[i])).isTrue();
        }
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldSearchCorrectBook() {

        // -------
        // ARRANGE
        // -------

        String bookTitleToSearch = "Understanding ECMAScript 6";
        String[] expectedData = {
                "/images/bookimage0.jpg",
                bookTitleToSearch,
                "Nicholas C. Zakas",
                "No Starch Press"
        };

        // ---
        // ACT
        // ---

        navigateToBookStorePage();
        bookStorePage.writeTextToSearchInput(bookTitleToSearch);

        // ------
        // ASSERT
        // ------

        assertThat(bookStorePage.isRowDataValid(0, expectedData)).isTrue();
    }

    @Test
    public void shouldChangeAmountOfRowsAndSwitchPagesToNextAndPrevious() {

        // -------
        // ARRANGE
        // -------

        // ROWS PER PAGE
        int expectedRowsAmount = 5;
        // NEXT PAGE
        String[][] nextPageData = {
                {"/images/bookimage1.jpg", "Programming JavaScript Applications", "Eric Elliott", "O'Reilly Media"},
                {"/images/bookimage2.jpg", "Eloquent JavaScript, Second Edition", "Marijn Haverbeke", "No Starch Press"},
                {"/images/bookimage3.jpg", "Understanding ECMAScript 6", "Nicholas C. Zakas", "No Starch Press"}
        };
        // PREVIOUS PAGE
        String[][] previousPageData = {
                {"/images/bookimage0.jpg", "Git Pocket Guide", "Richard E. Silverman", "O'Reilly Media"},
                {"/images/bookimage1.jpg", "Learning JavaScript Design Patterns", "Addy Osmani", "O'Reilly Media"},
                {"/images/bookimage2.jpg", "Designing Evolvable Web APIs with ASP.NET", "Glenn Block et al.", "O'Reilly Media"},
                {"/images/bookimage3.jpg", "Speaking JavaScript", "Axel Rauschmayer", "O'Reilly Media"},
                {"/images/bookimage0.jpg", "You Don't Know JS", "Kyle Simpson", "O'Reilly Media"}
        };

        // ------------
        // ACT + ASSERT
        // ------------

        navigateToBookStorePage();

        // ROWS PER PAGE

        bookStorePage.selectRowsPerPage("5");

        List<WebElement> tableRows = bookStorePage.getTableRows();
        assertThat(tableRows.size()).isEqualTo(expectedRowsAmount);

        // NEXT PAGE

        bookStorePage.clickNextPageButton();

        assertRowsData(nextPageData);

        // PREVIOUS PAGE

        bookStorePage.clickPreviousPageButton();

        assertRowsData(previousPageData);
    }
}
