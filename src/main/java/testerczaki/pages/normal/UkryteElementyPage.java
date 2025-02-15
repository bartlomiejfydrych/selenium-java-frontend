package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.pages.base.BasePage;

public class UkryteElementyPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public UkryteElementyPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Container
    private final String containerSelector = ".container>.row:nth-of-type(3) form";
    @FindBy(css = containerSelector)
    private WebElement poprawnyKontener;
    // Inputs
    @FindBy(css = containerSelector + " #firstName")
    private WebElement imieInput;
    @FindBy(css = containerSelector + " #lastName")
    private WebElement nazwiskoInput;
    @FindBy(css = containerSelector + " #email")
    private WebElement emailInput;
    @FindBy(css = containerSelector + " #city")
    private WebElement miastoInput;
    @FindBy(css = containerSelector + " #street")
    private WebElement ulicaInput;
    // Buttons
    @FindBy(css = containerSelector + " #rules")
    private WebElement regulaminCheckbox;
    @FindBy(css = containerSelector + " #submit")
    private WebElement wyslijButton;
    // Alert
    @FindBy(css = containerSelector + " #alert")
    private WebElement gratulacjeAlert;

    // -------
    // METHODS
    // -------

    public UkryteElementyPage fillForm(PodstawyForm podstawyForm) {
        writeImie(podstawyForm.getImie());
        writeNazwisko(podstawyForm.getNazwisko());
        writeEmail(podstawyForm.getEmail());
        writeMiasto(podstawyForm.getMiasto());
        writeUlica(podstawyForm.getUlica());
        return this;
    }

    public UkryteElementyPage writeImie(String imie) {
        imieInput.sendKeys(imie);
        return this;
    }

    public UkryteElementyPage writeNazwisko(String nazwisko) {
        nazwiskoInput.sendKeys(nazwisko);
        return this;
    }

    public UkryteElementyPage writeEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public UkryteElementyPage writeMiasto(String miasto) {
        miastoInput.sendKeys(miasto);
        return this;
    }

    public UkryteElementyPage writeUlica(String ulica) {
        ulicaInput.sendKeys(ulica);
        return this;
    }

    public UkryteElementyPage checkRegulaminCheckbox() {
        regulaminCheckbox.click();
        return this;
    }

    public UkryteElementyPage clickWyslijButton() {
        wyslijButton.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getGratulacjeAlert() {
        return gratulacjeAlert;
    }
}
