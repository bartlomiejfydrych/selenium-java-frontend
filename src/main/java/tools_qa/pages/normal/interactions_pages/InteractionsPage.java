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
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Selectable']")
    private WebElement selectableButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Resizable']")
    private WebElement resizableButton;

    // -------
    // METHODS
    // -------

    public SortablePage goToSortablePage() {
        sortableButton.click();
        return new SortablePage(driver);
    }

    public SelectablePage goToSelectablePage() {
        selectableButton.click();
        return new SelectablePage(driver);
    }

    public ResizablePage goToResizablePage() {
        resizableButton.click();
        return new ResizablePage(driver);
    }
}
