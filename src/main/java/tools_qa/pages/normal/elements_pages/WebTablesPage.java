package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tools_qa.models_providers.elements_models.web_tables.TableRow;
import tools_qa.pages.base.BasePage;

import java.time.Duration;
import java.util.List;

public class WebTablesPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "div button#addNewRecordButton")
    private WebElement addNewRowButton;
    @FindBy(css = "div input#searchBox")
    private WebElement searchInput;
    @FindBy(css = "div .action-buttons span[title='Edit'] svg")
    private WebElement editFirstRowButton;
    @FindBy(css = "div .action-buttons span[title='Delete'] svg")
    private WebElement deleteFirstRowButton;
    @FindBy(css = "select[aria-label='rows per page']")
    private WebElement rowsPerPageSelect;
    @FindBy(css = "div .-next button")
    private WebElement nextPageButton;
    @FindBy(css = "div .-odd:nth-of-type(1) .rt-td")
    private List<WebElement> firstRowCells;
    @FindBy(css = ".rt-noData")
    private WebElement noDataField;
    // Registration form
    @FindBy(css = "div .modal-content #firstName")
    private WebElement firstNameInput;
    @FindBy(css = "div .modal-content #lastName")
    private WebElement lastNameInput;
    @FindBy(css = "div .modal-content #userEmail")
    private WebElement emailInput;
    @FindBy(css = "div .modal-content #age")
    private WebElement ageInput;
    @FindBy(css = "div .modal-content #salary")
    private WebElement salaryInput;
    @FindBy(css = "div .modal-content #department")
    private WebElement departmentInput;
    @FindBy(css = "div button#submit")
    private WebElement submitButton;

    // -------
    // METHODS
    // -------

    public WebTablesPage clickAddNewRowButton() {
        addNewRowButton.click();
        waitForLoad(1);
        return this;
    }

    public WebTablesPage clickEditFirstRowButton() {
        editFirstRowButton.click();
        waitForLoad(1);
        return this;
    }

    public WebTablesPage clickDeleteFirstRowButton() {
        deleteFirstRowButton.click();
        return this;
    }

    public WebTablesPage selectRowsPerPage(String number) {
        Select select = new Select(rowsPerPageSelect);
        select.selectByValue(number);
        return this;
    }

    public WebTablesPage clickNextPageButton() {
        nextPageButton.click();
        return this;
    }

    public WebTablesPage writeTextToSearch(String searchText) {
        sendKeys(searchInput, searchText);
        waitForLoad(1);
        return this;
    }

    // Registration form

    public WebTablesPage fillRowForm(TableRow tableRow) {
        writeFirstName(tableRow.getFirstName());
        writeLastName(tableRow.getLastName());
        writeEmail(tableRow.getEmail());
        writeAge(tableRow.getAge());
        writeSalary(tableRow.getSalary());
        writeDepartment(tableRow.getDepartment());
        clickSubmitButton();
        return this;
    }

    public WebTablesPage writeFirstName(String firstName) {
        sendKeys(firstNameInput, firstName);
        return this;
    }

    public WebTablesPage writeLastName(String lastName) {
        sendKeys(lastNameInput, lastName);
        return this;
    }

    public WebTablesPage writeEmail(String email) {
        sendKeys(emailInput, email);
        return this;
    }

    public WebTablesPage writeAge(String age) {
        sendKeys(ageInput, age);
        return this;
    }

    public WebTablesPage writeSalary(String salary) {
        sendKeys(salaryInput, salary);
        return this;
    }

    public WebTablesPage writeDepartment(String department) {
        sendKeys(departmentInput, department);
        return this;
    }

    public WebTablesPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    // -------
    // HELPERS
    // -------

    private WebTablesPage sendKeys(WebElement element, String textToWrite) {
        element.clear();
        element.sendKeys(textToWrite);
        return this;
    }

    private void waitForLoad(int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
        // NOTE:
        // I had to use "implicitlyWait" here because standard waits didn't work on refreshed/loaded page elements
    }

    // -------
    // GETTERS
    // -------

    public List<WebElement> getFirstRowCells() {
        return firstRowCells;
    }

    public WebElement getNoDataField() {
        return noDataField;
    }
}
