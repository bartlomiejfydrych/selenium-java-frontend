package tools_qa.pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;
import tools_qa.pages.normal.alerts_frame_windows_pages.AlertsFrameWindowsPage;
import tools_qa.pages.normal.book_store_application_pages.BookStorePage;
import tools_qa.pages.normal.elements_pages.ElementsPage;
import tools_qa.pages.normal.forms_pages.FormsPage;
import tools_qa.pages.normal.interactions_pages.InteractionsPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

public class HomePage extends BasePage {

    // https://demoqa.com/

    // -----------
    // CONSTRUCTOR
    // -----------

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(xpath = "//div[contains(@class,'card')]/h5[text()='Elements']")
    private WebElement elementsButton;
    @FindBy(xpath = "//div[contains(@class,'card')]/h5[text()='Forms']")
    private WebElement formsButton;
    @FindBy(xpath = "//div[contains(@class,'card')]/h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsButton;
    @FindBy(xpath = "//div[contains(@class,'card')]/h5[text()='Widgets']")
    private WebElement widgetsButton;
    @FindBy(xpath = "//div[contains(@class,'card')]/h5[text()='Interactions']")
    private WebElement interactionsButton;
    @FindBy(xpath = "//div[contains(@class,'card')]/h5[text()='Book Store Application']")
    private WebElement bookStoreApplicationButton;

    // -------
    // METHODS
    // -------

    public ElementsPage goToElementsPage() {
        navigateToPage(elementsButton, ElementsPage.class);
        return new ElementsPage(driver);
    }

    public FormsPage goToFormsPage() {
        navigateToPage(formsButton, FormsPage.class);
        return new FormsPage(driver);
    }

    public AlertsFrameWindowsPage goToAlertsFrameWindowsPage() {
        navigateToPage(alertsFrameWindowsButton, AlertsFrameWindowsPage.class);
        return new AlertsFrameWindowsPage(driver);
    }

    public WidgetsPage goToWidgetsPage() {
        navigateToPage(widgetsButton, WidgetsPage.class);
        return new WidgetsPage(driver);
    }

    public InteractionsPage goToInteractionsPage() {
        navigateToPage(interactionsButton, InteractionsPage.class);
        return new InteractionsPage(driver);
    }

    public BookStorePage goToBookStorePage() {
        scrollToBottom();
        navigateToPage(bookStoreApplicationButton, BookStorePage.class);
        return new BookStorePage(driver);
        /* NOTE:
        We can use `actions.sendKeys(Keys.END).perform();` too,
        but it's slower and not work here (we still click footer AD).
        */
    }

    // -------
    // HELPERS
    // -------

    private void navigateToPage(WebElement button, Class<?> pageClass) {
        waitForElementToBeClickable(button);
        button.click();
    }

    private void waitForElementToBeClickable(WebElement element) {
        defaultWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void scrollToBottom() {
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}
