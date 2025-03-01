package tools_qa.pages.normal.interactions_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class SelectablePage extends BasePage {

    // https://demoqa.com/selectable

    // -----------
    // CONSTRUCTOR
    // -----------

    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "#demo-tab-grid")
    private WebElement gridTabButton;
    // LIST
    @FindBy(xpath = "//li[text()='Cras justo odio']")
    private WebElement crasListElement;
    @FindBy(xpath = "//li[text()='Dapibus ac facilisis in']")
    private WebElement dapibusListElement;
    @FindBy(xpath = "//li[text()='Morbi leo risus']")
    private WebElement morbiListElement;
    @FindBy(xpath = "//li[text()='Porta ac consectetur ac']")
    private WebElement portaListElement;
    // GRID
    @FindBy(xpath = "//li[text()='One']")
    private WebElement oneGridElement;
    @FindBy(xpath = "//li[text()='Two']")
    private WebElement twoGridElement;
    @FindBy(xpath = "//li[text()='Three']")
    private WebElement threeGridElement;
    @FindBy(xpath = "//li[text()='Four']")
    private WebElement fourGridElement;
    @FindBy(xpath = "//li[text()='Five']")
    private WebElement fiveGridElement;
    @FindBy(xpath = "//li[text()='Six']")
    private WebElement sixGridElement;
    @FindBy(xpath = "//li[text()='Seven']")
    private WebElement sevenGridElement;
    @FindBy(xpath = "//li[text()='Eight']")
    private WebElement eightGridElement;
    @FindBy(xpath = "//li[text()='Nine']")
    private WebElement nineGridElement;

    // -------
    // METHODS
    // -------

    public SelectablePage clickGridTab() {
        gridTabButton.click();
        return this;
    }

    // LIST

    public SelectablePage clickCrasListElement() {
        crasListElement.click();
        return this;
    }

    public SelectablePage clickDapibusListElement() {
        dapibusListElement.click();
        return this;
    }

    public SelectablePage clickMorbiListElement() {
        morbiListElement.click();
        return this;
    }

    public SelectablePage clickPortaListElement() {
        portaListElement.click();
        return this;
    }

    // GRID

    public SelectablePage clickOneGridElement() {
        oneGridElement.click();
        return this;
    }

    public SelectablePage clickTwoGridElement() {
        twoGridElement.click();
        return this;
    }

    public SelectablePage clickThreeGridElement() {
        threeGridElement.click();
        return this;
    }

    public SelectablePage clickFourGridElement() {
        fourGridElement.click();
        return this;
    }

    public SelectablePage clickFiveGridElement() {
        fiveGridElement.click();
        return this;
    }

    public SelectablePage clickSixGridElement() {
        sixGridElement.click();
        return this;
    }

    public SelectablePage clickSevenGridElement() {
        sevenGridElement.click();
        return this;
    }

    public SelectablePage clickEightGridElement() {
        eightGridElement.click();
        return this;
    }

    public SelectablePage clickNineGridElement() {
        nineGridElement.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    // LIST

    public WebElement getCrasListElement() {
        return crasListElement;
    }

    public WebElement getDapibusListElement() {
        return dapibusListElement;
    }

    public WebElement getMorbiListElement() {
        return morbiListElement;
    }

    public WebElement getPortaListElement() {
        return portaListElement;
    }

    // GRID

    public WebElement getOneGridElement() {
        return oneGridElement;
    }

    public WebElement getTwoGridElement() {
        return twoGridElement;
    }

    public WebElement getThreeGridElement() {
        return threeGridElement;
    }

    public WebElement getFourGridElement() {
        return fourGridElement;
    }

    public WebElement getFiveGridElement() {
        return fiveGridElement;
    }

    public WebElement getSixGridElement() {
        return sixGridElement;
    }

    public WebElement getSevenGridElement() {
        return sevenGridElement;
    }

    public WebElement getEightGridElement() {
        return eightGridElement;
    }

    public WebElement getNineGridElement() {
        return nineGridElement;
    }
}
