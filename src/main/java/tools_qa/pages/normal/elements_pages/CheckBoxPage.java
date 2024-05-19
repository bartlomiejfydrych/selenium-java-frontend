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
    @FindBy(css = "label[for='tree-node-home']")
    private WebElement homeCheckBox;
    // Locators for assertions
    @FindBy(css = "label[for='tree-node-home'] input")
    private WebElement assertHomeCheckBox;

    // Metody

    public CheckBoxPage clickExpandAll() {
        click(this.plusExpandAllButton);
        return this;
    }

    public CheckBoxPage clickCollapseAll() {
        click(this.minusCollapseAllButton);
        return this;
    }

    public CheckBoxPage clickHomeCheckBox() {
        click(this.homeCheckBox);
        return this;
    }

    // Gettery (do używania WebElementów w asercjach)

    public WebElement getAssertHomeCheckBox() {
        return assertHomeCheckBox;
    }
}
