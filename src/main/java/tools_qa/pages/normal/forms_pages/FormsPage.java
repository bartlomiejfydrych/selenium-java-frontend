package tools_qa.pages.normal.forms_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class FormsPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Practice Form']")
    private WebElement practiceFormButton;

    // -------
    // METHODS
    // -------


}
