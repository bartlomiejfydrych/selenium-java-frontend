package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class CheckboxPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "button[title='Expand all']")
    private WebElement plusExpandAllButton;
    @FindBy(css = "button[title='Collapse all']")
    private WebElement minusCollapseAllButton;
    @FindBy(css = "#result")
    private WebElement resultTextField;
    // CheckBoxes
    @FindBy(css = "label[for='tree-node-home']")
    private WebElement homeCheckbox;
    @FindBy(css = "label[for='tree-node-desktop']")
    private WebElement desktopCheckbox;
    @FindBy(css = "label[for='tree-node-workspace']")
    private WebElement workSpaceCheckbox;
    @FindBy(css = "label[for='tree-node-excelFile']")
    private WebElement excelFileCheckbox;
    // Locators for assertion
    @FindBy(css = "label[for='tree-node-home'] input")
    private WebElement assertHomeCheckbox;
    @FindBy(css = "label[for='tree-node-desktop'] input")
    private WebElement assertDesktopCheckbox;
    @FindBy(css = "label[for='tree-node-notes'] input")
    private WebElement assertNotesCheckbox;
    @FindBy(css = "label[for='tree-node-commands'] input")
    private WebElement assertCommandsCheckbox;
    @FindBy(css = "label[for='tree-node-documents'] input")
    private WebElement assertDocumentsCheckbox;
    @FindBy(css = "label[for='tree-node-workspace'] input")
    private WebElement assertWorkSpaceCheckbox;
    @FindBy(css = "label[for='tree-node-react'] input")
    private WebElement assertReactCheckbox;
    @FindBy(css = "label[for='tree-node-angular'] input")
    private WebElement assertAngularCheckbox;
    @FindBy(css = "label[for='tree-node-veu'] input")
    private WebElement assertVeuCheckbox;
    @FindBy(css = "label[for='tree-node-office'] input")
    private WebElement assertOfficeCheckbox;
    @FindBy(css = "label[for='tree-node-public'] input")
    private WebElement assertPublicCheckbox;
    @FindBy(css = "label[for='tree-node-private'] input")
    private WebElement assertPrivateCheckbox;
    @FindBy(css = "label[for='tree-node-classified'] input")
    private WebElement assertClassifiedCheckbox;
    @FindBy(css = "label[for='tree-node-general'] input")
    private WebElement assertGeneralCheckbox;
    @FindBy(css = "label[for='tree-node-downloads'] input")
    private WebElement assertDownloadsCheckbox;
    @FindBy(css = "label[for='tree-node-wordFile'] input")
    private WebElement assertWordFileCheckbox;
    @FindBy(css = "label[for='tree-node-excelFile'] input")
    private WebElement assertExcelFileCheckbox;

    // -------
    // METHODS
    // -------

    public CheckboxPage clickExpandAll() {
        plusExpandAllButton.click();
        return this;
    }

    public CheckboxPage clickCollapseAll() {
        minusCollapseAllButton.click();
        return this;
    }

    public String getResultText() {
        return resultTextField.getText();
    }

    // Methods for selecting checkboxes

    public CheckboxPage clickHomeCheckbox() {
        homeCheckbox.click();
        return this;
    }

    public CheckboxPage clickWorkSpaceCheckbox() {
        workSpaceCheckbox.click();
        return this;
    }

    public CheckboxPage clickExcelFileCheckbox() {
        excelFileCheckbox.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    // Checkboxes

    public WebElement getDesktopCheckbox() {
        return desktopCheckbox;
    }

    // Checking the selection of checkboxes

    public WebElement getAssertHomeCheckbox() {
        return assertHomeCheckbox;
    }

    public WebElement getAssertDesktopCheckbox() {
        return assertDesktopCheckbox;
    }

    public WebElement getAssertNotesCheckbox() {
        return assertNotesCheckbox;
    }

    public WebElement getAssertCommandsCheckbox() {
        return assertCommandsCheckbox;
    }

    public WebElement getAssertDocumentsCheckbox() {
        return assertDocumentsCheckbox;
    }

    public WebElement getAssertWorkSpaceCheckbox() {
        return assertWorkSpaceCheckbox;
    }

    public WebElement getAssertReactCheckbox() {
        return assertReactCheckbox;
    }

    public WebElement getAssertAngularCheckbox() {
        return assertAngularCheckbox;
    }

    public WebElement getAssertVeuCheckbox() {
        return assertVeuCheckbox;
    }

    public WebElement getAssertOfficeCheckbox() {
        return assertOfficeCheckbox;
    }

    public WebElement getAssertPublicCheckbox() {
        return assertPublicCheckbox;
    }

    public WebElement getAssertPrivateCheckbox() {
        return assertPrivateCheckbox;
    }

    public WebElement getAssertClassifiedCheckbox() {
        return assertClassifiedCheckbox;
    }

    public WebElement getAssertGeneralCheckbox() {
        return assertGeneralCheckbox;
    }

    public WebElement getAssertDownloadsCheckbox() {
        return assertDownloadsCheckbox;
    }

    public WebElement getAssertWordFileCheckbox() {
        return assertWordFileCheckbox;
    }

    public WebElement getAssertExcelFileCheckbox() {
        return assertExcelFileCheckbox;
    }
}
