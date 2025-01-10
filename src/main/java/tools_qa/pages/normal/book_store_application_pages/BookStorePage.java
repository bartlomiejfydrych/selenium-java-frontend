package tools_qa.pages.normal.book_store_application_pages;

import org.openqa.selenium.By;
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
    private final String tableRowsLocator = ".rt-tr-group";
    @FindBy(css = tableRowsLocator)
    private List<WebElement> tableRows;
    private final String tableColumnsLocator = ".rt-td";
    @FindBy(css = tableColumnsLocator)
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

    // NAVIGATE TO OTHER BOOK STORE APPLICATION PAGES
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Profile']")
    private WebElement profileButton;

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

    public boolean isRowDataValid(int rowIndex, String... expectedData) {
        // Fetch a row based on index
        WebElement row = driver.findElements(By.cssSelector(tableRowsLocator)).get(rowIndex);
        // Get columns
        List<WebElement> columns = row.findElements(By.cssSelector(tableColumnsLocator));
        // Get data from each column into Strings Array
        String[] actualData = {
                columns.get(0).findElement(By.tagName("img")).getDomAttribute("src"),
                columns.get(1).findElement(By.tagName("a")).getText(),
                columns.get(2).getText(),
                columns.get(3).getText()
        };
        // Check if any column with current data does not contain the expected data and return 'false'
        for (int i = 0; i < expectedData.length; i++) {
            if (!actualData[i].contains(expectedData[i])) return false;
        }
        return true;
    }

    // WAITS

    public BookStorePage waitForBooksTable() {
        defaultWait.until(ExpectedConditions.visibilityOf(booksTable));
        return this;
    }

    // NAVIGATE TO OTHER BOOK STORE APPLICATION PAGES

    public LoginPage goToLoginPage() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public ProfilePage goToProfilePage() {
        profileButton.click();
        return new ProfilePage(driver);
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
