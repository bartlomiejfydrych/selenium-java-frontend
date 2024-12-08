package tools_qa.pages.normal.book_store_application_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

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

    @FindBy(css = "span[id='see-book-Git Pocket Guide'] a")
    private WebElement gitPocketGuideTitle;
    @FindBy(css = ".rt-table")
    private WebElement booksTable;

    // -------
    // METHODS
    // -------

    // WAITS

    public BookStorePage waitForBooksTable() {
        defaultWait.until(ExpectedConditions.visibilityOf(booksTable));
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getGitPocketGuideTitle() {
        return gitPocketGuideTitle;
    }
}
