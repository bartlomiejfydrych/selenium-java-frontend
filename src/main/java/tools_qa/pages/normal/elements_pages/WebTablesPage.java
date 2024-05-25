package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

import java.time.Duration;
import java.util.List;

public class WebTablesPage extends BasePage {

    // Konstruktor

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    // Web Elementy

    @FindBy(css = "div input#searchBox")
    private WebElement searchInput;
    @FindBy(css = "div .-odd:nth-of-type(1) .rt-td")
    private List<WebElement> firstRowCells;

    // Metody

    public WebTablesPage writeTextToSearch(String searchText) {
        searchInput.sendKeys(searchText);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return this;
    }

    // Gettery

    public List<WebElement> getFirstRowCells() {
        return firstRowCells;
    }
}
