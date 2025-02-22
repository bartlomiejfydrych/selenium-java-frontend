package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testerczaki.pages.base.BasePage;

import java.util.List;

public class NiestandardoweListyPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public NiestandardoweListyPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Zadanie 1
    @FindBy(css = "button:first-of-type")
    private WebElement z1WybierzButton;
    @FindBy(css = ".dropdown-menu > a")
    private List<WebElement> z1ElementyList;
    @FindBy(css = "#alert1")
    private WebElement z1Alert;
    // Zadanie 2
    @FindBy(css = "button#dropdown_coins")
    private WebElement z2WybierzButton;
    @FindBy(id = "search2")
    private WebElement z2WyszukajInput;
    @FindBy(css = "#menuItems > input")
    private List<WebElement> z2ElementyList;
    @FindBy(id = "alert2")
    private WebElement z2Alert;

    // -------
    // METHODS
    // -------

    // Zadanie 1

    public NiestandardoweListyPage z1ClickWybierzButton() {
        z1WybierzButton.click();
        return this;
    }

    public NiestandardoweListyPage z1ClickElement(int index) {
        z1ElementyList.get(index - 1).click();
        return this;
    }

    // Zadanie 2

    public NiestandardoweListyPage z2ClickWybierzButton() {
        z2WybierzButton.click();
        return this;
    }

    public NiestandardoweListyPage z2WriteWyszukajText(String Element) {
        z2WyszukajInput.sendKeys(Element);
        return this;
    }

    public NiestandardoweListyPage z2ClickElement(int index) {
        z2ElementyList.get(index - 1).click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getZ1Alert() {
        return z1Alert;
    }

    public WebElement getZ2Alert() {
        return z2Alert;
    }
}
