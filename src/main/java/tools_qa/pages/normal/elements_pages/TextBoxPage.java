package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;


public class TextBoxPage extends BasePage {

    //------------
    // CONSTRUCTOR
    //------------

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    //-------------
    // WEB ELEMENTS
    //-------------

    @FindBy(css = "#userName")
    private WebElement userNameInput;
    @FindBy(css = "#userEmail")
    private WebElement userEmailInput;
    @FindBy(css = "#currentAddress")
    private WebElement currentAddressTextArea;
    @FindBy(css = "#permanentAddress")
    private WebElement permanentAddressTextArea;
    @FindBy(css = "#submit")
    private WebElement submitButton;
    // Output
    @FindBy(css = "#output p#name")
    private WebElement nameParagraph;
    @FindBy(css = "#output p#email")
    private WebElement emailParagraph;
    @FindBy(css = "#output p#currentAddress")
    private WebElement currentAddressParagraph;
    @FindBy(css = "#output p#permanentAddress")
    private WebElement permanentAddressParagraph;

    //--------
    // METHODS
    //--------

    public TextBoxPage writeFullName(String fullName) {
        sendKeys(this.userNameInput, fullName);
        return this;
    }

    public TextBoxPage writeEmail(String email) {
        sendKeys(this.userEmailInput, email);
        return this;
    }

    public TextBoxPage writeCurrentAddress(String currentAddress) {
        sendKeys(this.currentAddressTextArea, currentAddress);
        return this;
    }

    public TextBoxPage writePermanentAddress(String permanentAddress) {
        sendKeys(this.permanentAddressTextArea, permanentAddress);
        return this;
    }

    public TextBoxPage clickSubmit() {
        jse.executeScript("arguments[0].click();", this.submitButton);
        return this;
        /*
        Ads on the page cover the button. Because of this, you had to use JavaScript.
        Added the following line to the BasePage:
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        In subsequent tests, I use the method that deletes the area with the advertisement and footer.
        I left this method here so that I know that it is possible to act on occluded elements using JavaScript.
        */
    }

    public String getNameParagraph() {
        return nameParagraph.getText();
    }

    public String getEmailParagraph() {
        return emailParagraph.getText();
    }

    public String getCurrentAddressParagraph() {
        return currentAddressParagraph.getText();
    }

    public String getPermanentAddressParagraph() {
        return permanentAddressParagraph.getText();
    }
}
