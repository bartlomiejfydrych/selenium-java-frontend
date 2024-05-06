package tools_qa.pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class HomePage extends BasePage {

    // Konstruktor

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Web Elementy

    @FindBy(xpath = "//div[contains(@class,'card')]/h5[contains(text(), 'Elements')]")
    private WebElement elementsButton;
    @FindBy(xpath = "//div[contains(@class,'card')]/h5[contains(text(), 'Forms')]")
    private WebElement formsButton;
    @FindBy(xpath = "//div[contains(@class,'card')]/h5[contains(text(), 'Alerts, Frame & Windows')]")
    private WebElement alertsFrameWindowsButton;
    @FindBy(xpath = "//div[contains(@class,'card')]/h5[contains(text(), 'Widgets')]")
    private WebElement widgetsButton;
    @FindBy(xpath = "//div[contains(@class,'card')]/h5[contains(text(), 'Interactions')]")
    private WebElement interactionsButton;
    @FindBy(xpath = "//div[contains(@class,'card')]/h5[contains(text(), 'Book Store Application')]")
    private WebElement bookStoreApplicationButton;

    // Metody

    public ElementsPage goToElementsPage() {
        elementsButton.click();
        return new ElementsPage(driver);
    }
}
