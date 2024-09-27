package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class AccordianPage extends BasePage {

    /*
    NOTE:
    There is a typo on the page and the correct name is "Accordions"
    but I use the name as it is on the page to be consistent.
    */

    // -----------
    // CONSTRUCTOR
    // -----------

    public AccordianPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Section 1
    @FindBy(css = "#section1Heading")
    private WebElement section1Button;
    @FindBy(css = "#section1Content p")
    private WebElement section1Text;
    // Section 2
    @FindBy(css = "#section2Heading")
    private WebElement section2Button;
    @FindBy(css = "#section2Content p:nth-of-type(1)")
    private WebElement section2Text1;
    @FindBy(css = "#section2Content p:nth-of-type(2)")
    private WebElement section2Text2;
    // Section 3
    @FindBy(css = "#section3Heading")
    private WebElement section3Button;
    @FindBy(css = "#section3Content p")
    private WebElement section3Text;

    // -------
    // METHODS
    // -------

    public AccordianPage waitForElementToBeHidden(WebElement webElement) {
        defaultWait.until(ExpectedConditions.invisibilityOf(webElement));
        return this;
    }

    public AccordianPage waitForElementToBeVisible(WebElement webElement) {
        defaultWait.until(ExpectedConditions.visibilityOf(webElement));
        return this;
    }

    public AccordianPage clickSection1Button() {
        section1Button.click();
        return this;
    }

    public AccordianPage clickSection2Button() {
        section2Button.click();
        return this;
    }

    public AccordianPage clickSection3Button() {
        section3Button.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getSection1Text() {
        return section1Text;
    }

    public WebElement getSection2Text1() {
        return section2Text1;
    }

    public WebElement getSection2Text2() {
        return section2Text2;
    }

    public WebElement getSection3Text() {
        return section3Text;
    }
}
