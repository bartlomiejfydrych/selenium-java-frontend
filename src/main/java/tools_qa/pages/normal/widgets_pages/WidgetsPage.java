package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class WidgetsPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Accordian']")
    private WebElement accordianButton;

    // -------
    // METHODS
    // -------

    public AccordianPage goToAccordianPage() {
        accordianButton.click();
        return new AccordianPage(driver);
    }
}
