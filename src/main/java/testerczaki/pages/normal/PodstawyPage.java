package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.pages.base.BasePage;

public class PodstawyPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public PodstawyPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(id = "firstName")
    private WebElement imieInput;
    @FindBy(id = "lastName")
    private WebElement nazwiskoInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "city")
    private WebElement miastoInput;
    @FindBy(id = "street")
    private WebElement ulicaInput;
    @FindBy(id = "rules")
    private WebElement regulaminCheckbox;
    @FindBy(id = "submit")
    private WebElement wyslijButton;
    @FindBy(id = "alert")
    private WebElement gratulacjeAlert;

    // -------
    // METHODS
    // -------

    public PodstawyPage fillPodstawyForm(PodstawyForm podstawyForm) {
        writeImie(podstawyForm.getImie());
        writeNazwisko(podstawyForm.getNazwisko());
        writeEmail(podstawyForm.getEmail());
        writeMiasto(podstawyForm.getMiasto());
        writeUlica(podstawyForm.getUlica());
        return this;
    }

    public PodstawyPage writeImie(String imie) {
        imieInput.sendKeys(imie);
        return this;
    }

    public PodstawyPage writeNazwisko(String nazwisko) {
        nazwiskoInput.sendKeys(nazwisko);
        return this;
    }

    public PodstawyPage writeEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public PodstawyPage writeMiasto(String miasto) {
        miastoInput.sendKeys(miasto);
        return this;
    }

    public PodstawyPage writeUlica(String ulica) {
        ulicaInput.sendKeys(ulica);
        return this;
    }

    public PodstawyPage checkRegulaminCheckbox() {
        regulaminCheckbox.click();
        return this;
    }

    public PodstawyPage clickWyslijButton() {
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
