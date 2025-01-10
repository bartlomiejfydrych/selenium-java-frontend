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

        homePage.goToBookStorePage();

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
        // NEXT PAGE
        // row 1
        String nextRow1ExpectedImageSrc = "/images/bookimage1.jpg";
        String nextRow1ExpectedTitle = "Programming JavaScript Applications";
        String nextRow1ExpectedAuthor = "Eric Elliott";
        String nextRow1ExpectedPublisher = "O'Reilly Media";
        // row 2
        String nextRow2ExpectedImageSrc = "/images/bookimage2.jpg";
        String nextRow2ExpectedTitle = "Eloquent JavaScript, Second Edition";
        String nextRow2ExpectedAuthor = "Marijn Haverbeke";
        String nextRow2ExpectedPublisher = "No Starch Press";
        // row 3
        String nextRow3ExpectedImageSrc = "/images/bookimage3.jpg";
        String nextRow3ExpectedTitle = "Understanding ECMAScript 6";
        String nextRow3ExpectedAuthor = "Nicholas C. Zakas";
        String nextRow3ExpectedPublisher = "No Starch Press";
        // PREVIOUS PAGE
        // row 1
        String previousRow1ExpectedImageSrc = "/images/bookimage0.jpg";
        String previousRow1ExpectedTitle = "Git Pocket Guide";
        String previousRow1ExpectedAuthor = "Richard E. Silverman";
        String previousRow1ExpectedPublisher = "O'Reilly Media";
        // row 2
        String previousRow2ExpectedImageSrc = "/images/bookimage1.jpg";
        String previousRow2ExpectedTitle = "Learning JavaScript Design Patterns";
        String previousRow2ExpectedAuthor = "Addy Osmani";
        String previousRow2ExpectedPublisher = "O'Reilly Media";
        // row 3
        String previousRow3ExpectedImageSrc = "/images/bookimage2.jpg";
        String previousRow3ExpectedTitle = "Designing Evolvable Web APIs with ASP.NET";
        String previousRow3ExpectedAuthor = "Glenn Block et al.";
        String previousRow3ExpectedPublisher = "O'Reilly Media";
        // row 4
        String previousRow4ExpectedImageSrc = "/images/bookimage3.jpg";
        String previousRow4ExpectedTitle = "Speaking JavaScript";
        String previousRow4ExpectedAuthor = "Axel Rauschmayer";
        String previousRow4ExpectedPublisher = "O'Reilly Media";
        // row 5
        String previousRow5ExpectedImageSrc = "/images/bookimage0.jpg";
        String previousRow5ExpectedTitle = "You Don't Know JS";
        String previousRow5ExpectedAuthor = "Kyle Simpson";
        String previousRow5ExpectedPublisher = "O'Reilly Media";

        // ------------
        // ACT + ASSERT
        // ------------

        homePage.goToBookStorePage();

        trainingPage.removeFooterAndAds();

        // ROWS PER PAGE

        bookStorePage.selectRowsPerPage("5");

        List<WebElement> tableRows = bookStorePage.getTableRows();

        assertThat(tableRows.size()).isEqualTo(expectedRowsAmount);

        // NEXT PAGE

        bookStorePage.clickNextPageButton();

        assertThat(bookStorePage.isRowDataValid(0, nextRow1ExpectedImageSrc, nextRow1ExpectedTitle, nextRow1ExpectedAuthor, nextRow1ExpectedPublisher)).isTrue();
        assertThat(bookStorePage.isRowDataValid(1, nextRow2ExpectedImageSrc, nextRow2ExpectedTitle, nextRow2ExpectedAuthor, nextRow2ExpectedPublisher)).isTrue();
        assertThat(bookStorePage.isRowDataValid(2, nextRow3ExpectedImageSrc, nextRow3ExpectedTitle, nextRow3ExpectedAuthor, nextRow3ExpectedPublisher)).isTrue();

        // PREVIOUS PAGE

        bookStorePage.clickPreviousPageButton();

        assertThat(bookStorePage.isRowDataValid(0, previousRow1ExpectedImageSrc, previousRow1ExpectedTitle, previousRow1ExpectedAuthor, previousRow1ExpectedPublisher)).isTrue();
        assertThat(bookStorePage.isRowDataValid(1, previousRow2ExpectedImageSrc, previousRow2ExpectedTitle, previousRow2ExpectedAuthor, previousRow2ExpectedPublisher)).isTrue();
        assertThat(bookStorePage.isRowDataValid(2, previousRow3ExpectedImageSrc, previousRow3ExpectedTitle, previousRow3ExpectedAuthor, previousRow3ExpectedPublisher)).isTrue();
        assertThat(bookStorePage.isRowDataValid(3, previousRow4ExpectedImageSrc, previousRow4ExpectedTitle, previousRow4ExpectedAuthor, previousRow4ExpectedPublisher)).isTrue();
        assertThat(bookStorePage.isRowDataValid(4, previousRow5ExpectedImageSrc, previousRow5ExpectedTitle, previousRow5ExpectedAuthor, previousRow5ExpectedPublisher)).isTrue();
    }
}
