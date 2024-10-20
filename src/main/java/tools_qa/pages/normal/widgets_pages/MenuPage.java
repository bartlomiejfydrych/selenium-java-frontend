package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

import java.util.List;

public class MenuPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // All menu buttons
    @FindBy(css = ".nav-menu-container #nav li")
    private List<WebElement> menuButtons;
    // Main items
    @FindBy(xpath = "//a[text()='Main Item 1']")
    private WebElement mainItem1Button;
    @FindBy(xpath = "//a[text()='Main Item 2']")
    private WebElement mainItem2Button;
    @FindBy(xpath = "//a[text()='Main Item 3']")
    private WebElement mainItem3Button;
    // Main item 2 - sub items
    @FindBy(xpath = "//a[text()='SUB SUB LIST »']")
    private WebElement subSubListButton;
    // Main item 2 - sub sub list items
    @FindBy(xpath = "//a[text()='Sub Sub Item 1']")
    private WebElement subSubItem1;
    @FindBy(xpath = "//a[text()='Sub Sub Item 2']")
    private WebElement subSubItem2;

    // -------
    // METHODS
    // -------

    public MenuPage hoverOverMainItem3() {
        actions.moveToElement(mainItem1Button)
                .moveToElement(mainItem3Button)
                .perform();
        return this;
    }

    public MenuPage hoverOverSubSubItem2() {
        defaultWait.until(ExpectedConditions.visibilityOf(mainItem2Button));
        actions.moveToElement(mainItem2Button).perform();
        defaultWait.until(ExpectedConditions.visibilityOf(subSubListButton));
        actions.moveToElement(subSubListButton).perform();
        defaultWait.until(ExpectedConditions.visibilityOf(subSubItem1));
        actions.moveToElement(subSubItem1).perform();
        defaultWait.until(ExpectedConditions.visibilityOf(subSubItem2));
        actions.moveToElement(subSubItem2).perform();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public List<WebElement> getMenuButtons() {
        return menuButtons;
    }
}
