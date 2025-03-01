package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testerczaki.pages.base.BasePage;

import java.util.ArrayList;

public class OknaZakladkiPage extends BasePage {

    // https://dawidkaruga.pl/testerczaki/okna

    // -----------
    // CONSTRUCTOR
    // -----------

    public OknaZakladkiPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(id = "newTab")
    private WebElement podstawyTab;
    @FindBy(id = "newWindow")
    private WebElement podstawyWindow;

    // -------
    // METHODS
    // -------

    public PodstawyPage clickPodstawyNewTab() {
        podstawyTab.click();
        waitForNewTabOrWindow();
        return new PodstawyPage(driver);
    }

    public PodstawyPage clickPodstawyNewWindow() {
        podstawyWindow.click();
        waitForNewTabOrWindow();
        return new PodstawyPage(driver);
    }

    public OknaZakladkiPage switchTabOrWindow(int tabOrWindowNumber) {
        ArrayList<String> tabOrWindowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabOrWindowList.get(tabOrWindowNumber));
        return this;
    }

    public OknaZakladkiPage switchTabOrWindowAndMaximize(int tabOrWindowNumber) {
        switchTabOrWindow(tabOrWindowNumber);
        if (tabOrWindowNumber > 0) {
            driver.manage().window().maximize();
        }
        return this;
    }

    // -------
    // HELPERS
    // -------

    private void waitForNewTabOrWindow() {
        defaultWait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }
}
