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

    @FindBy(css = "")
    private WebElement plusExpandAllButton;
}
