package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import testerczaki.models_providers.wiecej_elementow_models.WiecejElementowForm;
import tools_qa.pages.base.BasePage;

import java.io.File;
import java.util.List;

public class WiecejElementowPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public WiecejElementowPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Imię
    @FindBy(id = "firstName")
    private WebElement imieInput;
    // Nazwisko
    @FindBy(id = "lastName")
    private WebElement nazwiskoInput;
    // Kraj
    @FindBy(id = "country")
    private WebElement krajSelect;
    // Język programowania
    @FindBy(id = "lang")
    private WebElement jezykProgramowaniaSelect;
    // O sobie
    @FindBy(id = "about")
    private WebElement oSobieInput;
    // Plik
    @FindBy(id = "file")
    private WebElement plikAttachment;
    // Płeć
    @FindBy(id = "maleLabel")
    private WebElement mezczyznaRadioButton;
    @FindBy(id = "femaleLabel")
    private WebElement kobietaRadioButton;
    @FindBy(id = "otherLabel")
    private WebElement inneRadioButton;
    // Akcepuję regulamin
    @FindBy(id = "rulesLabel")
    private WebElement regulaminCheckbox;
    // Wyślij
    @FindBy(id = "submit")
    private WebElement wyslijButton;
    // Komunikat potwierdzający
    @FindBy(className = "alert-success")
    private WebElement gratulacjeAlert;

    // -------
    // METHODS
    // -------

    public WiecejElementowPage fillForm(WiecejElementowForm wiecejElementowForm) {
        writeImie(wiecejElementowForm.getImie());
        writeNazwisko(wiecejElementowForm.getNazwisko());
        selectKraj(wiecejElementowForm.getKraj());
        selectJezyk(wiecejElementowForm.getJezykProgramowania());
        writeOSobie(wiecejElementowForm.getoSobie());
        sendPlik();
        clickPlecRadioButton(wiecejElementowForm.getPlec());
        return this;
    }

    public WiecejElementowPage writeImie(String imie) {
        imieInput.sendKeys(imie);
        return this;
    }

    public WiecejElementowPage writeNazwisko(String nazwisko) {
        nazwiskoInput.sendKeys(nazwisko);
        return this;
    }

    public WiecejElementowPage selectKraj(String kraj) {
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

    public WiecejElementowPage selectJezyk(List<String> jezykProgramowaniaList) {
        Select jezykiProgramowania = new Select(jezykProgramowaniaSelect);
        for (String jezykProgramowania : jezykProgramowaniaList) {
            jezykiProgramowania.selectByVisibleText(jezykProgramowania);
        }
        return this;
    }

    public WiecejElementowPage writeOSobie(String oSobie) {
        oSobieInput.sendKeys(oSobie);
        return this;
    }

    public WiecejElementowPage sendPlik() {
        File fileToUpload = new File("src/main/resources/testerczaki/test_files/wiecej_elementow_files/WiecejElementow_TextFile.txt");
        plikAttachment.sendKeys(fileToUpload.getAbsolutePath());
        return this;
    }

    public WiecejElementowPage clickPlecRadioButton(String plec) {
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

    public WiecejElementowPage checkRegulaminCheckbox() {
        regulaminCheckbox.click();
        return this;
    }

    public WiecejElementowPage clickWyslijButton() {
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
