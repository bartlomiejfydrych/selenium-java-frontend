package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.models.TextBoxForm;
import tools_qa.pages.base.BasePage;


public class TextBoxPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Input fields
    @FindBy(css = "#userName")
    private WebElement fullNameInput;
    @FindBy(css = "#userEmail")
    private WebElement emailInput;
    @FindBy(css = "#currentAddress")
    private WebElement currentAddressTextArea;
    @FindBy(css = "#permanentAddress")
    private WebElement permanentAddressTextArea;
    @FindBy(css = "#submit")
    private WebElement submitButton;
    // Output fields
    @FindBy(css = "#output p#name")
    private WebElement fullNameParagraph;
    @FindBy(css = "#output p#email")
    private WebElement emailParagraph;
    @FindBy(css = "#output p#currentAddress")
    private WebElement currentAddressParagraph;
    @FindBy(css = "#output p#permanentAddress")
    private WebElement permanentAddressParagraph;

    // -------
    // METHODS
    // -------

    public TextBoxPage fillTextBoxForm(TextBoxForm textBoxForm) {
        writeFullName(textBoxForm.getFullName());
        writeEmail(textBoxForm.getEmail());
        writeCurrentAddress(textBoxForm.getCurrentAddress());
        writePermanentAddress(textBoxForm.getPermanentAddress());
        return this;
    }

    public TextBoxPage writeFullName(String fullName) {
        return sendKeys(fullNameInput, fullName);
    }

    public TextBoxPage writeEmail(String email) {
        return sendKeys(emailInput, email);
    }

    public TextBoxPage writeCurrentAddress(String currentAddress) {
        return sendKeys(currentAddressTextArea, currentAddress);
    }

    public TextBoxPage writePermanentAddress(String permanentAddress) {
        return sendKeys(permanentAddressTextArea, permanentAddress);
    }

    public TextBoxPage clickSubmit() {
        jse.executeScript("arguments[0].click();", submitButton);
        return this;
        /*
        NOTE:
        Ads on the page cover the button. Because of this, you had to use JavaScript.
        Added the following line to the BasePage:
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        In subsequent tests, I use the method that deletes the area with the advertisement and footer.
        I left this method here so that I know that it is possible to act on occluded elements using JavaScript.
        */
    }

    // -------
    // HELPERS
    // -------

    private TextBoxPage sendKeys(WebElement element, String textToWrite) {
        element.clear();
        element.sendKeys(textToWrite);
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getFullNameParagraph() {
        return fullNameParagraph;
    }

    public WebElement getEmailParagraph() {
        return emailParagraph;
    }

    public WebElement getCurrentAddressParagraph() {
        return currentAddressParagraph;
    }

    public WebElement getPermanentAddressParagraph() {
        return permanentAddressParagraph;
    }
}
