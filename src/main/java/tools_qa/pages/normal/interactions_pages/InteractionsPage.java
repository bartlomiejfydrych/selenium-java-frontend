package tools_qa.pages.normal.interactions_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class InteractionsPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public InteractionsPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Sortable']")
    private WebElement sortableButton;

    // -------
    // METHODS
    // -------

    public SortablePage goToSortablePage() {
        sortableButton.click();
        return new SortablePage(driver);
    }
}
