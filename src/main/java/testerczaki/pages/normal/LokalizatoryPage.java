package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import testerczaki.models_providers.wiecej_elementow_models.WiecejElementowForm;
import testerczaki.pages.base.BasePage;

import java.io.File;
import java.util.List;

public class LokalizatoryPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public LokalizatoryPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Imię
    @FindBy(className = "firstName")
    private WebElement imieInput;
    // Nazwisko
    @FindBy(css = "[placeholder=\"Nazwisko\"]")
    private WebElement nazwiskoInput;
    // Kraj
    @FindBy(className = "custom-select")
    private WebElement krajSelect;
    // Język programowania
    @FindBy(css = "select.form-control")
    private WebElement jezykProgramowaniaSelect;
    // O sobie
    @FindBy(css = "textarea.form-control")
    private WebElement oSobieInput;
    // Plik
    @FindBy(className = "form-control-file")
    private WebElement plikAttachment;
    //Płeć
    @FindBy(css = "div.mb-3 > div.custom-radio:nth-of-type(1)>.custom-control-label")
    private WebElement mezczyznaRadioButton;
    @FindBy(css = "div.mb-3>div.custom-radio:nth-of-type(2)>.custom-control-label")
    private WebElement kobietaRadioButton;
    @FindBy(css = "div.mb-3>div.custom-radio:nth-of-type(3)>.custom-control-label")
    private WebElement inneRadioButton;
    // Akceptuję regulamin
    @FindBy(css = ".custom-checkbox>.custom-control-label")
    private WebElement regulaminCheckbox;
    // Wyślij
    @FindBy(css = "[type=\"submit\"]")
    private WebElement wyslijButton;
    // Komunikat potwierdzający
    @FindBy(className = "alert-success")
    private WebElement gratulacjeAlert;

    // -------
    // METHODS
    // -------

    public LokalizatoryPage fillForm(WiecejElementowForm wiecejElementowForm) {
        writeImie(wiecejElementowForm.getImie());
        writeNazwisko(wiecejElementowForm.getNazwisko());
        selectKraj(wiecejElementowForm.getKraj());
        selectJezyk(wiecejElementowForm.getJezykProgramowania());
        writeOSobie(wiecejElementowForm.getoSobie());
        sendPlik();
        clickPlecRadioButton(wiecejElementowForm.getPlec());
        return this;
    }

    public LokalizatoryPage writeImie(String imie) {
        imieInput.sendKeys(imie);
        return this;
    }

    public LokalizatoryPage writeNazwisko(String nazwisko) {
        nazwiskoInput.sendKeys(nazwisko);
        return this;
    }

    public LokalizatoryPage selectKraj(String kraj) {
        Select country = new Select(krajSelect);
        // We get the available options from the select field
        List<WebElement> availableOptions = country.getOptions();
        // We create a list of text values of available options
        List<String> validCountries = availableOptions.stream()
                .map(WebElement::getText)
                .toList();
        // We check if the given value is in the list
        if (!validCountries.contains(kraj)) {
            throw new IllegalArgumentException("Invalid country name provided: " + kraj);
        }
        // We select the value if it is correct
        country.selectByVisibleText(kraj);
        return this;
    }

    public LokalizatoryPage selectJezyk(List<String> jezykProgramowaniaList) {
        Select jezykiProgramowania = new Select(jezykProgramowaniaSelect);
        for (String jezykProgramowania : jezykProgramowaniaList) {
            jezykiProgramowania.selectByVisibleText(jezykProgramowania);
        }
        return this;
    }

    public LokalizatoryPage writeOSobie(String oSobie) {
        oSobieInput.sendKeys(oSobie);
        return this;
    }

    public LokalizatoryPage sendPlik() {
        File fileToUpload = new File("src/main/resources/testerczaki/test_files/wiecej_elementow_files/WiecejElementow_TextFile.txt");
        plikAttachment.sendKeys(fileToUpload.getAbsolutePath());
        return this;
    }

    public LokalizatoryPage clickPlecRadioButton(String plec) {
        switch (plec.toLowerCase()) {
            case "mężczyzna":
                mezczyznaRadioButton.click();
                break;
            case "kobieta":
                kobietaRadioButton.click();
                break;
            case "inne":
                inneRadioButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid gender: " + plec);
        }
        return this;
    }

    public LokalizatoryPage checkRegulaminCheckbox() {
        regulaminCheckbox.click();
        return this;
    }

    public LokalizatoryPage clickWyslijButton() {
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
