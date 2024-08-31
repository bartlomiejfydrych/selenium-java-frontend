package tools_qa.pages.normal.forms_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tools_qa.models.PracticeForm;
import tools_qa.pages.base.BasePage;

import java.io.File;

public class PracticeFormPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // FORM

    // Name
    @FindBy(css = "#firstName")
    private WebElement firstNameInput;
    @FindBy(css = "#lastName")
    private WebElement lastNameInput;
    // Email
    @FindBy(css = "#userEmail")
    private WebElement emailInput;
    // Gender
    @FindBy(css = "input[value='Male']")
    private WebElement genderMaleRadioButton;
    @FindBy(css = "input[value='Female']")
    private WebElement genderFemaleRadioButton;
    @FindBy(css = "input[value='Other']")
    private WebElement genderOtherRadioButton;
    // Mobile
    @FindBy(css = "#userNumber")
    private WebElement mobileNumberInput;
    // Date of Birth
    @FindBy(css = "#dateOfBirthInput")
    private WebElement dateOfBirthCalendarInput;
    // Subjects
    @FindBy(css = "#subjectsContainer")
    private WebElement subjectsAutoCompleteInput;
    // Hobbies
    @FindBy(css = "#hobbies-checkbox-1")
    private WebElement hobbiesSportsCheckbox;
    @FindBy(css = "#hobbies-checkbox-2")
    private WebElement hobbiesReadingCheckbox;
    @FindBy(css = "#hobbies-checkbox-3")
    private WebElement hobbiesMusicCheckbox;
    // Picture
    @FindBy(css = "#uploadPicture")
    private WebElement uploadPictureButton;
    // Current Address
    @FindBy(css = "#currentAddress")
    private WebElement currentAddressTextAreaInput;
    // State and City
    private final String stateSelectXpath = "//div[@id='state']";
    @FindBy(xpath = stateSelectXpath)
    private WebElement stateSelect;
    @FindBy(css = "#city")
    private WebElement citySelect;
    // Submit
    @FindBy(css = "#submit")
    private WebElement submitButton;

    // -------
    // METHODS
    // -------

    // FORM

    public PracticeFormPage fillForm(PracticeForm practiceForm) {
        writeFirstName(practiceForm.getFirstName());
        writeLastName(practiceForm.getLastName());
        writeEmail(practiceForm.getEmail());
        // <wybranie płci>
        writeMobileNumber(practiceForm.getMobileNumber());
        // miss [Date of Birth]
        // miss [Subject]
        // <wybranie hobby>
        uploadPicture();
        writeCurrentAddress(practiceForm.getCurrentAddress());
        selectState(practiceForm.getState());
//        selectState(practiceForm.getCity());
        // miss [Click Submit Button]
        return this;
    }

    // Name

    public PracticeFormPage writeFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public PracticeFormPage writeLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    // Email

    public PracticeFormPage writeEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    // Gender

    public PracticeFormPage clickGenderMale() {
        genderMaleRadioButton.click();
        return this;
    }

    public PracticeFormPage clickGenderFemale() {
        genderFemaleRadioButton.click();
        return this;
    }

    public PracticeFormPage clickGenderOther() {
        genderOtherRadioButton.click();
        return this;
    }

    // Mobile

    public PracticeFormPage writeMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
        return this;
    }

    // Date of Birth

    public PracticeFormPage writeDateOfBirth(String birthDate) {
        // FORMAT: 02 Jul 2024
        dateOfBirthCalendarInput.sendKeys(birthDate);
        return this;
    }

    // Subjects

    public PracticeFormPage writeSubjects(String subject) {
        subjectsAutoCompleteInput.sendKeys(subject);
        return this;
    }

    // Hobbies

    public PracticeFormPage checkHobbySports() {
        hobbiesSportsCheckbox.click();
        return this;
    }

    public PracticeFormPage checkHobbyReading() {
        hobbiesReadingCheckbox.click();
        return this;
    }

    public PracticeFormPage checkHobbyMusic() {
        hobbiesMusicCheckbox.click();
        return this;
    }

    // Picture

    public PracticeFormPage uploadPicture() {
        File pictureToUpload = new File("src/main/resources/tools_qa/PracticeForm/PracticeFormTest_UploadPicture.png");
        uploadPictureButton.sendKeys(pictureToUpload.getAbsolutePath());
        return this;
    }

    // Current Address

    public PracticeFormPage writeCurrentAddress(String currentAddress) {
        currentAddressTextAreaInput.sendKeys(currentAddress);
        return this;
    }

    // State and City

    public PracticeFormPage selectState(String state) {
        stateSelect.click();
        String stateSelectOptionXpath = stateSelectXpath + "//div[text()='" + state + "']";
        WebElement stateSelectOptionLocator = driver.findElement(By.xpath(stateSelectOptionXpath));
        WebElement stateSelectOption = defaultWait.until(ExpectedConditions.elementToBeClickable(stateSelectOptionLocator));
        stateSelectOption.click();
        return this;
    }

    public PracticeFormPage selectCity(String city) {
        Select select = new Select(citySelect);
        select.selectByVisibleText(city);
        return this;
    }

    // Submit

    public PracticeFormPage clickSubmit() {
        submitButton.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

}
