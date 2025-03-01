package tools_qa.pages.normal.interactions_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class InteractionsPage extends BasePage {

    // https://demoqa.com/interaction

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
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Droppable']")
    private WebElement droppableButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Dragabble']")
    private WebElement dragabbleButton;

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

    public DroppablePage goToDroppablePage() {
        droppableButton.click();
        return new DroppablePage(driver);
    }

    public DragabblePage goToDragabblePage() {
        dragabbleButton.click();
        return new DragabblePage(driver);
    }
}
