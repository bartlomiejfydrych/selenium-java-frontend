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
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Auto Complete']")
    private WebElement autoCompleteButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Date Picker']")
    private WebElement datePickerButton;

    // -------
    // METHODS
    // -------

    public AccordianPage goToAccordianPage() {
        accordianButton.click();
        return new AccordianPage(driver);
    }

    public AutoCompletePage goToAutoCompletePage() {
        autoCompleteButton.click();
        return new AutoCompletePage(driver);
    }

    public DatePickerPage goToDatePickerPage() {
        datePickerButton.click();
        return new DatePickerPage(driver);
    }
}
