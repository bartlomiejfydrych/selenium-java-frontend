package tools_qa.pages.normal.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class SortablePage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "#demo-tab-grid")
    private WebElement gridTabButton;
    // LIST
    @FindBy(css = ".vertical-list-container .list-group-item")
    private List<WebElement> listElements;
    @FindBy(xpath = "(//div[text()='One'])[1]")
    private WebElement oneListElement;
    @FindBy(xpath = "(//div[text()='Two'])[1]")
    private WebElement twoListElement;
    @FindBy(xpath = "(//div[text()='Three'])[1]")
    private WebElement threeListElement;
    @FindBy(xpath = "(//div[text()='Four'])[1]")
    private WebElement fourListElement;
    @FindBy(xpath = "(//div[text()='Five'])[1]")
    private WebElement fiveListElement;
    @FindBy(xpath = "(//div[text()='Six'])[1]")
    private WebElement sixListElement;
    // GRID
    @FindBy(css = ".create-grid .list-group-item")
    private List<WebElement> gridElements;
    @FindBy(xpath = "(//div[text()='One'])[2]")
    private WebElement oneGridElement;
    @FindBy(xpath = "(//div[text()='Two'])[2]")
    private WebElement twoGridElement;
    @FindBy(xpath = "(//div[text()='Three'])[2]")
    private WebElement threeGridElement;
    @FindBy(xpath = "(//div[text()='Four'])[2]")
    private WebElement fourGridElement;
    @FindBy(xpath = "(//div[text()='Five'])[2]")
    private WebElement fiveGridElement;
    @FindBy(xpath = "(//div[text()='Six'])[2]")
    private WebElement sixGridElement;
    @FindBy(xpath = "//div[text()='Seven']")
    private WebElement sevenGridElement;
    @FindBy(xpath = "//div[text()='Eight']")
    private WebElement eightGridElement;
    @FindBy(xpath = "//div[text()='Nine']")
    private WebElement nineGridElement;

    // -------
    // METHODS
    // -------

    public SortablePage moveElementToAnotherElement(WebElement movedElement, WebElement targetElement) {
        actions.clickAndHold(movedElement)
                .moveToElement(targetElement)
                .release()
                .perform();
        return this;
    }

    public SortablePage clickGridTab() {
        gridTabButton.click();
        return this;
    }

    // -------
    // HELPERS
    // -------

    public List<String> getListElementsAsText() {
        List<String> listElementsTextList = listElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return listElementsTextList;
    }

    public List<String> getGridElementsAsText() {
        List<String> gridElementsTextList = gridElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return gridElementsTextList;
    }

    // -------
    // GETTERS
    // -------

    // LIST

    public WebElement getOneListElement() {
        return oneListElement;
    }

    public WebElement getTwoListElement() {
        return twoListElement;
    }

    public WebElement getThreeListElement() {
        return threeListElement;
    }

    public WebElement getFourListElement() {
        return fourListElement;
    }

    public WebElement getFiveListElement() {
        return fiveListElement;
    }

    public WebElement getSixListElement() {
        return sixListElement;
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
