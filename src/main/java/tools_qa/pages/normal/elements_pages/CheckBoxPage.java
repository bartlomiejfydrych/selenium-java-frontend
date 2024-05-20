package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class CheckBoxPage extends BasePage {

    // Konstruktor

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    // Web Elementy

    @FindBy(css = "button[title='Expand all']")
    private WebElement plusExpandAllButton;
    @FindBy(css = "button[title='Collapse all']")
    private WebElement minusCollapseAllButton;
    @FindBy(css = "#result")
    private WebElement resultTextField;
    // CheckBoxes
    @FindBy(css = "label[for='tree-node-home']")
    private WebElement homeCheckBox;
    // Lokatory dla asercji
    @FindBy(css = "label[for='tree-node-home'] input")
    private WebElement assertHomeCheckBox;
    @FindBy(css = "label[for='tree-node-desktop'] input")
    private WebElement assertDesktopCheckBox;
    @FindBy(css = "label[for='tree-node-notes'] input")
    private WebElement assertNotesCheckBox;
    @FindBy(css = "label[for='tree-node-commands'] input")
    private WebElement assertCommandsCheckBox;
    @FindBy(css = "label[for='tree-node-documents'] input")
    private WebElement assertDocumentsCheckBox;
    @FindBy(css = "label[for='tree-node-workspace'] input")
    private WebElement assertWorkSpaceCheckBox;
    @FindBy(css = "label[for='tree-node-react'] input")
    private WebElement assertReactCheckBox;
    @FindBy(css = "label[for='tree-node-angular'] input")
    private WebElement assertAngularCheckBox;
    @FindBy(css = "label[for='tree-node-veu'] input")
    private WebElement assertVeuCheckBox;
    @FindBy(css = "label[for='tree-node-office'] input")
    private WebElement assertOfficeCheckBox;
    @FindBy(css = "label[for='tree-node-public'] input")
    private WebElement assertPublicCheckBox;
    @FindBy(css = "label[for='tree-node-private'] input")
    private WebElement assertPrivateCheckBox;
    @FindBy(css = "label[for='tree-node-classified'] input")
    private WebElement assertClassifiedCheckBox;
    @FindBy(css = "label[for='tree-node-general'] input")
    private WebElement assertGeneralCheckBox;
    @FindBy(css = "label[for='tree-node-downloads'] input")
    private WebElement assertDownloadsCheckBox;
    @FindBy(css = "label[for='tree-node-wordFile'] input")
    private WebElement assertWordFileCheckBox;
    @FindBy(css = "label[for='tree-node-excelFile'] input")
    private WebElement assertExcelFileCheckBox;

    // Metody

    public CheckBoxPage clickExpandAll() {
        click(this.plusExpandAllButton);
        return this;
    }

    public CheckBoxPage clickCollapseAll() {
        click(this.minusCollapseAllButton);
        return this;
    }

    public String getResultText() {
        return resultTextField.getText();
    }

    // Metody do zaznaczania checkboxów

    public CheckBoxPage clickHomeCheckBox() {
        click(this.homeCheckBox);
        return this;
    }

    // Gettery (do używania WebElementów w asercjach)

    public WebElement getAssertHomeCheckBox() {
        return assertHomeCheckBox;
    }

    public WebElement getAssertDesktopCheckBox() {
        return assertDesktopCheckBox;
    }

    public WebElement getAssertNotesCheckBox() {
        return assertNotesCheckBox;
    }

    public WebElement getAssertCommandsCheckBox() {
        return assertCommandsCheckBox;
    }

    public WebElement getAssertDocumentsCheckBox() {
        return assertDocumentsCheckBox;
    }

    public WebElement getAssertWorkSpaceCheckBox() {
        return assertWorkSpaceCheckBox;
    }

    public WebElement getAssertReactCheckBox() {
        return assertReactCheckBox;
    }

    public WebElement getAssertAngularCheckBox() {
        return assertAngularCheckBox;
    }

    public WebElement getAssertVeuCheckBox() {
        return assertVeuCheckBox;
    }

    public WebElement getAssertOfficeCheckBox() {
        return assertOfficeCheckBox;
    }

    public WebElement getAssertPublicCheckBox() {
        return assertPublicCheckBox;
    }

    public WebElement getAssertPrivateCheckBox() {
        return assertPrivateCheckBox;
    }

    public WebElement getAssertClassifiedCheckBox() {
        return assertClassifiedCheckBox;
    }

    public WebElement getAssertGeneralCheckBox() {
        return assertGeneralCheckBox;
    }

    public WebElement getAssertDownloadsCheckBox() {
        return assertDownloadsCheckBox;
    }

    public WebElement getAssertWordFileCheckBox() {
        return assertWordFileCheckBox;
    }

    public WebElement getAssertExcelFileCheckBox() {
        return assertExcelFileCheckBox;
    }
}
