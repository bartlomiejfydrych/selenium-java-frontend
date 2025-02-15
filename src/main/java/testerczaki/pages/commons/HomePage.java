package testerczaki.pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testerczaki.pages.base.BasePage;
import testerczaki.pages.normal.*;

public class HomePage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(id = "podstawy")
    private WebElement podstawyZacznijButton;
    @FindBy(id = "wiecej")
    private WebElement wiecejElementowZacznijButton;
    @FindBy(id = "asercja")
    private WebElement asercjaZacznijButton;
    @FindBy(css = "[href='/testerczaki/lokalizatory']")
    private WebElement lokalizatoryZacznijButton;
    @FindBy(css = "[href='/testerczaki/ukryte']")
    private WebElement ukryteElementyZacznijButton;
    @FindBy(css = "[href='/testerczaki/opcjonalny']")
    private WebElement opcjonalnyFormularzZacznijButton;
    @FindBy(css = "[href='/testerczaki/ramka']")
    private WebElement ramkaZacznijButton;
    @FindBy(css = "[href='/testerczaki/ramki']")
    private WebElement wiecejRamekZacznijButton;
    @FindBy(css = "[href='/testerczaki/okna']")
    private WebElement oknaZakladkiZacznijButton;
    @FindBy(css = "[href='/testerczaki/komunikaty']")
    private WebElement komunikatyZacznijButton;
    @FindBy(css = "[href='/testerczaki/menu']")
    private WebElement menuZacznijButton;
    @FindBy(css = "[href='/testerczaki/przeciagnij']")
    private WebElement przeciagnijUpuscZacznijButton;
    @FindBy(css = "[href='/testerczaki/mysz']")
    private WebElement kliknijPrzetrzymajZacznijButton;
    @FindBy(css = "[href='/testerczaki/listy']")
    private WebElement niestandardoweListyZacznijButton;
    @FindBy(css = "[href='/testerczaki/tabele']")
    private WebElement tabeleZacznijButton;

    // -------
    // METHODS
    // -------

    public PodstawyPage goToPodstawyPage() {
        navigateToPage(podstawyZacznijButton, PodstawyPage.class);
        return new PodstawyPage(driver);
    }

    public WiecejElementowPage goToWiecejElementowPage() {
        navigateToPage(wiecejElementowZacznijButton, WiecejElementowPage.class);
        return new WiecejElementowPage(driver);
    }

    public AsercjaPage goToAsercjaPage() {
        navigateToPage(asercjaZacznijButton, AsercjaPage.class);
        return new AsercjaPage(driver);
    }

    public LokalizatoryPage goToLokalizatoryPage() {
        navigateToPage(lokalizatoryZacznijButton, LokalizatoryPage.class);
        return new LokalizatoryPage(driver);
    }

    public UkryteElementyPage goToUkryteElementyPage() {
        navigateToPage(ukryteElementyZacznijButton, UkryteElementyPage.class);
        return new UkryteElementyPage(driver);
    }

    public OpcjonalnyFormularzPage goToOpcjonalnyFormularzPage() {
        navigateToPage(opcjonalnyFormularzZacznijButton, OpcjonalnyFormularzPage.class);
        return new OpcjonalnyFormularzPage(driver);
    }

//    public RamkaPage goToRamkaPage() {
//        ramkaZacznij.click();
//        return new RamkaPage(driver);
//    }
//
//    public WiecejRamekPage goToWiecejRamekPage() {
//        wiecejRamekZacznij.click();
//        return new WiecejRamekPage(driver);
//    }
//
//    public OknaZakladkiPage goToOknaZakladkiPage() {
//        oknaZakladkiZacznij.click();
//        return new OknaZakladkiPage(driver);
//    }
//
//    public KomunikatyPage goToKomunikatyPage() {
//        komunikatyZacznij.click();
//        return new KomunikatyPage(driver);
//    }
//
//    public MenuPage goToMenuPage() {
//        menuZacznij.click();
//        return new MenuPage(driver);
//    }
//
//    public PrzeciagnijUpuscPage goToPrzeciagnijUpuscPage() {
//        przeciagnijUpuscZacznij.click();
//        return new PrzeciagnijUpuscPage(driver);
//    }
//
//    public KliknijPrzytrzymajPage goToKliknijPrzytrzymajPage() {
//        kliknijPrzetrzymajZacznij.click();
//        return new KliknijPrzytrzymajPage(driver);
//    }
//
//    public NiestandardoweListyPage goToNiestandardoweListyPage() {
//        niestandardoweListyZacznij.click();
//        return new NiestandardoweListyPage(driver);
//    }
//
//    public TabelePage goToTabelePage() {
//        tabeleZacznij.click();
//        return new TabelePage(driver);
//    }

    // -------
    // HELPERS
    // -------

    private void navigateToPage(WebElement button, Class<?> pageClass) {
        waitForElementToBeClickable(button);
        button.click();
    }

    private void waitForElementToBeClickable(WebElement element) {
        defaultWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
