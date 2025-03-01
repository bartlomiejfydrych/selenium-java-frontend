package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

import java.util.List;

public class MenuPage extends BasePage {

    // https://demoqa.com/menu

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
    @FindBy(xpath = "(//a[text()='Sub Item'])[1]")
    private WebElement subItem1;
    @FindBy(xpath = "(//a[text()='Sub Item'])[2]")
    private WebElement subItem2;
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
                .moveToElement(mainItem2Button)
                .moveToElement(mainItem3Button)
                .perform();
        return this;
    }

    public MenuPage hoverOverSubSubItem2() {
        actions.moveToElement(mainItem1Button)
                .moveToElement(mainItem2Button)
                .moveToElement(subItem1)
                .moveToElement(subItem2)
                .moveToElement(subSubListButton)
                .moveToElement(subSubItem1)
                .moveToElement(subSubItem2)
                .perform();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public List<WebElement> getMenuButtons() {
        return menuButtons;
    }
}

/*

------
NOTES:
------

I'm writing it down because I think it's worth remembering just in case.

No waits wanted to work.
For some reason, adding the following line before the action execution improved their performance:
int width = subItem1.getSize().getWidth();

It is also worth remembering that it is safest to perform actions item by item, without skipping menu items along the way.

*/
