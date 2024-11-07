package tools_qa.pages.normal.book_store_application_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class BookStoreApplicationPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public BookStoreApplicationPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Login']")
    private WebElement loginButton;

    // -------
    // METHODS
    // -------

    public LoginPage goToLoginPage() {
        loginButton.click();
        return new LoginPage(driver);
    }
}
