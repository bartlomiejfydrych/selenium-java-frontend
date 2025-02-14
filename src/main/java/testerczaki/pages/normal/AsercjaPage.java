package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testerczaki.models_providers.asercja_models.AsercjaForm;
import testerczaki.pages.base.BasePage;

public class AsercjaPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public AsercjaPage(WebDriver driver) {
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
    @FindBy(id = "rulesLabel")
    private WebElement regulaminCheckbox;
    @FindBy(id = "submit")
    private WebElement wyslijButton;
    @FindBy(id = "alert")
    private WebElement gratulacjeAlert;

    // -------
    // METHODS
    // -------

    public AsercjaPage fillAsercjaForm(AsercjaForm asercjaForm) {
        writeImie(asercjaForm.getImie());
        writeNazwisko(asercjaForm.getNazwisko());
        writeEmail(asercjaForm.getEmail());
        writeMiasto(asercjaForm.getMiasto());
        writeUlica(asercjaForm.getUlica());
        return this;
    }

    public AsercjaPage writeImie(String imie) {
        imieInput.sendKeys(imie);
        return this;
    }

    public AsercjaPage writeNazwisko(String nazwisko) {
        nazwiskoInput.sendKeys(nazwisko);
        return this;
    }

    public AsercjaPage writeEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public AsercjaPage writeMiasto(String miasto) {
        miastoInput.sendKeys(miasto);
        return this;
    }

    public AsercjaPage writeUlica(String ulica) {
        ulicaInput.sendKeys(ulica);
        return this;
    }

    public AsercjaPage checkRegulaminCheckbox() {
        regulaminCheckbox.click();
        return this;
    }

    public AsercjaPage clickWyslijButton() {
        wyslijButton.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getImieInput() {
        return imieInput;
    }

    public WebElement getNazwiskoInput() {
        return nazwiskoInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getMiastoInput() {
        return miastoInput;
    }

    public WebElement getUlicaInput() {
        return ulicaInput;
    }

    public WebElement getRegulaminCheckbox() {
        return regulaminCheckbox;
    }

    public WebElement getGratulacjeAlert() {
        return gratulacjeAlert;
    }
}
