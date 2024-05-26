package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

import java.time.Duration;
import java.util.List;

public class WebTablesPage extends BasePage {

    // Konstruktor

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    // Web Elementy

    @FindBy(css = "div button#addNewRecordButton")
    private WebElement addNewRowButton;
    @FindBy(css = "div input#searchBox")
    private WebElement searchInput;
    @FindBy(css = "div .-odd:nth-of-type(1) .rt-td")
    private List<WebElement> firstRowCells;
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

    // Metody

    public WebTablesPage clickAddNewRowButton() {
        addNewRowButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return this;
    }

    public WebTablesPage writeTextToSearch(String searchText) {
        searchInput.sendKeys(searchText);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return this;
    }

    // Registration form

    public WebTablesPage writeFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public WebTablesPage writeLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public WebTablesPage writeEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public WebTablesPage writeAge(String age) {
        ageInput.sendKeys(age);
        return this;
    }

    public WebTablesPage writeSalary(String salary) {
        salaryInput.sendKeys(salary);
        return this;
    }

    public WebTablesPage writeDepartment(String department) {
        departmentInput.sendKeys(department);
        return this;
    }

    public WebTablesPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    // Gettery

    public List<WebElement> getFirstRowCells() {
        return firstRowCells;
    }
}
