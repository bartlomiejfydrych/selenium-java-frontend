package tools_qa.pages.normal.book_store_application_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tools_qa.pages.base.BasePage;

import java.time.Duration;
import java.util.List;

public class BookStorePage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // SEARCH
    @FindBy(css = "#searchBox")
    private WebElement searchInput;
    // BOOKS TABLE
    @FindBy(css = ".rt-table")
    private WebElement booksTable;
    @FindBy(css = ".rt-tr-group")
    private List<WebElement> tableRows;
    @FindBy(css = ".rt-td")
    private List<WebElement> tableColumns;
    @FindBy(css = "div .-odd:nth-of-type(1) .rt-td")
    private List<WebElement> firstRowCells;
    @FindBy(css = "span[id='see-book-Git Pocket Guide'] a")
    private WebElement gitPocketGuideTitle;
    // PAGINATION
    @FindBy(css = ".-pageJump input")
    private WebElement pageInput;
    @FindBy(css = ".-previous button")
    private WebElement previousPageButton;
    @FindBy(css = ".-next button")
    private WebElement nextPageButton;
    @FindBy(css = ".select-wrap select")
    private WebElement rowsSelect;

    // -------
    // METHODS
    // -------

    public BookStorePage writeTextToSearchInput(String textToSearch) {
        searchInput.clear();
        searchInput.sendKeys(textToSearch);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return this;
    }

    public BookStorePage selectRowsPerPage(String number) {
        Select select = new Select(rowsSelect);
        select.selectByValue(number);
        return this;
    }

    public BookStorePage clickNextPageButton() {
        nextPageButton.click();
        return this;
    }

    public BookStorePage clickPreviousPageButton() {
        previousPageButton.click();
        return this;
    }

    // WAITS

    public BookStorePage waitForBooksTable() {
        defaultWait.until(ExpectedConditions.visibilityOf(booksTable));
        return this;
    }

    // -------
    // GETTERS
    // -------

    public List<WebElement> getFirstRowCells() {
        return firstRowCells;
    }

    public List<WebElement> getTableRows() {
        return tableRows;
    }

    public WebElement getGitPocketGuideTitle() {
        return gitPocketGuideTitle;
    }
}
