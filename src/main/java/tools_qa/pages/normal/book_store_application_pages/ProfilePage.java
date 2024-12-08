package tools_qa.pages.normal.book_store_application_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tools_qa.pages.base.BasePage;

import java.util.List;

public class ProfilePage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "#userName-value")
    private WebElement userNameValue;
    @FindBy(xpath = "//button[text()='Log out']")
    private WebElement logOutButton;
    @FindBy(css = ".ReactTable")
    private WebElement booksTable;
    @FindBy(css = "div[role='rowgroup']")
    private List<WebElement> tableRows;
    @FindBy(css = "select[aria-label='rows per page']")
    private WebElement rowsSelect;
    @FindBy(css = "#gotoStore")
    private WebElement goToBookStoreButton;
    // DELETE ALL BOOKS
    @FindBy(xpath = "(//button)[text()='Delete All Books'][1]")
    private WebElement deleteAllBooksButton;
    @FindBy(css = ".modal-content")
    private WebElement deleteAllBooksModal;
    @FindBy(css = "modal-body")
    private WebElement deleteAllBooksModalBody;
    @FindBy(css = "#closeSmallModal-ok")
    private WebElement deleteAllBooksModalOKButton;
    @FindBy(css = "#closeSmallModal-cancel")
    private WebElement deleteAllBooksModalCancelButton;

    // -------
    // METHODS
    // -------

    public ProfilePage clickLogOutButton() {
        logOutButton.click();
        return this;
    }

    public ProfilePage selectRowsAmount(String amountValue) {
        Select select = new Select(rowsSelect);
        select.selectByValue(amountValue);
        return this;
    }

    public ProfilePage clickGoToBookStoreButton() {
        goToBookStoreButton.click();
        return this;
    }

    // DELETE ALL BOOKS

    public ProfilePage clickDeleteAllBooksButton() {
        deleteAllBooksButton.click();
        return this;
    }

    public ProfilePage clickDeleteAllBooksModalOKButton() {
        deleteAllBooksModalOKButton.click();
        return this;
    }

    public ProfilePage clickDeleteAllBooksModalCancelButton() {
        deleteAllBooksModalCancelButton.click();
        return this;
    }

    // ALERTS

    public Alert waitForAlert() {
        return defaultWait.until(ExpectedConditions.alertIsPresent());
    }

    public String getAlertText() {
        Alert alert = waitForAlert();
        return alert.getText();
    }

    public void acceptAlert() {
        Alert alert = waitForAlert();
        alert.accept();
    }

    // WAITS

    public ProfilePage waitForLogOutButton() {
        defaultWait.until(ExpectedConditions.visibilityOf(logOutButton));
        return this;
    }

    public ProfilePage waitForBooksTable() {
        defaultWait.until(ExpectedConditions.visibilityOf(booksTable));
        return this;
    }

    public ProfilePage waitForDisappearDeleteAllBooksModal() {
        defaultWait.until(ExpectedConditions.invisibilityOf(deleteAllBooksModal));
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getUserNameValue() {
        return userNameValue;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public List<WebElement> getTableRows() {
        return tableRows;
    }

    public WebElement getDeleteAllBooksModal() {
        return deleteAllBooksModal;
    }
}
