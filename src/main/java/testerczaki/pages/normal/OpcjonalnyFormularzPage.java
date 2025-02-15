package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.pages.base.BasePage;

public class OpcjonalnyFormularzPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public OpcjonalnyFormularzPage(WebDriver driver) {
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
    @FindBy(css = "label[for=\"add\"]")
    private WebElement dodatkowePolaCheckbox;
    @FindBy(id = "city")
    private WebElement miastoInput;
    @FindBy(id = "street")
    private WebElement ulicaInput;
    @FindBy(id = "submit")
    private WebElement wyslijButton;
    @FindBy(id = "alert")
    private WebElement gratulacjeAlert;

    // -------
    // METHODS
    // -------

    public OpcjonalnyFormularzPage fillForm(PodstawyForm podstawyForm) {
        writeImie(podstawyForm.getImie());
        writeNazwisko(podstawyForm.getNazwisko());
        writeEmail(podstawyForm.getEmail());
        checkDodatkowePolaCheckbox();
        writeMiasto(podstawyForm.getMiasto());
        writeUlica(podstawyForm.getUlica());
        return this;
    }

    public OpcjonalnyFormularzPage writeImie(String imie) {
        imieInput.sendKeys(imie);
        return this;
    }

    public OpcjonalnyFormularzPage writeNazwisko(String nazwisko) {
        nazwiskoInput.sendKeys(nazwisko);
        return this;
    }

    public OpcjonalnyFormularzPage writeEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public OpcjonalnyFormularzPage checkDodatkowePolaCheckbox() {
        dodatkowePolaCheckbox.click();
        return this;
    }

    public OpcjonalnyFormularzPage writeMiasto(String miasto) {
        defaultWait.until(ExpectedConditions.visibilityOf(miastoInput));
        miastoInput.sendKeys(miasto);
        return this;
    }

    public OpcjonalnyFormularzPage writeUlica(String ulica) {
        defaultWait.until(ExpectedConditions.visibilityOf(ulicaInput));
        ulicaInput.sendKeys(ulica);
        return this;
    }

    public OpcjonalnyFormularzPage clickWyslijButton() {
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
