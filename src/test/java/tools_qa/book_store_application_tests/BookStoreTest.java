package tools_qa.book_store_application_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.book_store_application_pages.BookStorePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookStoreTest extends TestBase {

    /*
    NOTES:
    When I click on the book name, a blank page opens and nothing else happens.
    This makes larger and more thorough tests of the Book Store impossible, so I test everything I can.
    */

    HomePage homePage;
    TrainingPage trainingPage;
    BookStorePage bookStorePage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        bookStorePage = new BookStorePage(driver);
    }

    @Test
    public void shouldSearchCorrectBook() {

        // -------
        // ARRANGE
        // -------

        String bookTitleToSearch = "Understanding ECMAScript 6";
        String expectedImage = "/images/bookimage0.jpg";
        String expectedAuthor = "Nicholas C. Zakas";
        String expectedPublisher = "No Starch Press";

        // ---
        // ACT
        // ---

        homePage.goToBookStoreApplicationPage();

        trainingPage.removeFooterAndAds();

        bookStorePage.writeTextToSearchInput(bookTitleToSearch);

        // ------
        // ASSERT
        // ------

        List<WebElement> firstRowCells = bookStorePage.getFirstRowCells();
        assertThat(firstRowCells.get(0).findElement(By.tagName("img")).getDomAttribute("src")).isEqualTo(expectedImage);
        assertThat(firstRowCells.get(1).getText()).isEqualTo(bookTitleToSearch);
        assertThat(firstRowCells.get(2).getText()).isEqualTo(expectedAuthor);
        assertThat(firstRowCells.get(3).getText()).isEqualTo(expectedPublisher);
    }

    @Test
    public void shouldChangeAmountOfRowsAndSwitchPagesToNextAndPrevious() {

        // -------
        // ARRANGE
        // -------

        int expectedRowsAmount = 5;

        // ------------
        // ACT + ASSERT
        // ------------

        homePage.goToBookStoreApplicationPage();

        trainingPage.removeFooterAndAds();

        // ROWS PER PAGE

        bookStorePage.selectRowsPerPage("5");

        List<WebElement> tableRows = bookStorePage.getTableRows();

        assertThat(tableRows.size()).isEqualTo(expectedRowsAmount);

        // NEXT PAGE

        bookStorePage.clickNextPageButton();

        // PREVIOUS PAGE


    }
}
