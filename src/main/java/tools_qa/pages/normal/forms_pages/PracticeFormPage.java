package tools_qa.pages.normal.forms_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tools_qa.models.PracticeForm;
import tools_qa.pages.base.BasePage;

import java.io.File;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    @FindBy(css = "input[value='Male'] + label")
    private WebElement genderMaleRadioButton;
    @FindBy(css = "input[value='Female'] + label")
    private WebElement genderFemaleRadioButton;
    @FindBy(css = "input[value='Other'] + label")
    private WebElement genderOtherRadioButton;
    // Mobile
    @FindBy(css = "#userNumber")
    private WebElement mobileNumberInput;
    // Date of Birth
    @FindBy(css = "#dateOfBirthInput")
    private WebElement dateOfBirthCalendarInput;
    @FindBy(css = ".react-datepicker__month-select")
    private WebElement monthSelect;
    @FindBy(css = ".react-datepicker__year-select")
    private WebElement yearSelect;
    private final String daySelectXpath = "//div[@class='react-datepicker__month']/div/div"; // [contains(@aria-label,'November') and text()='27']
    @FindBy(xpath = daySelectXpath)
    private WebElement daySelect;
    // Subjects
    @FindBy(css = "#subjectsInput")
    private WebElement subjectsAutoCompleteInput;
    @FindBy(css = ".subjects-auto-complete__indicators .subjects-auto-complete__indicator")
    private List<WebElement> subjectsAutoCompleteInputClearButton;
    // Hobbies
    @FindBy(css = "[for='hobbies-checkbox-1']")
    private WebElement hobbiesSportsCheckbox;
    @FindBy(css = "[for='hobbies-checkbox-2']")
    private WebElement hobbiesReadingCheckbox;
    @FindBy(css = "[for='hobbies-checkbox-3']")
    private WebElement hobbiesMusicCheckbox;
    // Picture
    @FindBy(css = "#uploadPicture")
    private WebElement uploadPictureButton;
    @FindBy(css = "label[for='uploadPicture']")
    private WebElement uploadPictureLabel;
    // Current Address
    @FindBy(css = "#currentAddress")
    private WebElement currentAddressTextAreaInput;
    // State and City
    private final String stateSelectXpath = "//div[@id='state']";
    @FindBy(xpath = stateSelectXpath)
    private WebElement stateSelect;
    @FindBy(xpath = "//div[@id='state']/div/div/div[text()='Select State']")
    private WebElement stateSelectWithDefaultValue;
    private final String citySelectXpath = "//div[@id='city']";
    @FindBy(xpath = citySelectXpath)
    private WebElement citySelect;
    @FindBy(xpath = "//div[@id='city']/div/div/div[text()='Select City']")
    private WebElement citySelectWithDefaultValue;
    // Submit
    @FindBy(css = "#submit")
    private WebElement submitButton;

    // SUMMARY TABLE

    @FindBy(css = "table.table tbody tr td:nth-of-type(1)")
    private List<WebElement> labelColumn;
    @FindBy(css = "table.table tbody tr td:nth-of-type(2)")
    private List<WebElement> valuesColumn;
    @FindBy(css = "#closeLargeModal")
    private WebElement closeSummaryTableButton;

    // -------
    // METHODS
    // -------

    // FORM

    public PracticeFormPage fillForm(PracticeForm practiceForm) {
        writeFirstName(practiceForm.getFirstName());
        writeLastName(practiceForm.getLastName());
        writeEmail(practiceForm.getEmail());
        clickGenderRadioButton(practiceForm.getGender());
        writeMobileNumber(practiceForm.getMobileNumber());
        selectDateOfBirth(practiceForm.getDateOfBirth());
        writeSubjects(practiceForm.getSubjectList());
        checkHobbyCheckboxes(practiceForm.getHobbyList());
        uploadPicture();
        writeCurrentAddress(practiceForm.getCurrentAddress());
        selectState(practiceForm.getState());
        selectCity(practiceForm.getCity());
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

    public PracticeFormPage clickGenderRadioButton(String gender) {
        switch (gender) {
            case "Male":
                genderMaleRadioButton.click();
                break;
            case "Female":
                genderFemaleRadioButton.click();
                break;
            case "Other":
                genderOtherRadioButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid gender: " + gender);
        }
        return this;
    }

    // Mobile

    public PracticeFormPage writeMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
        return this;
    }

    // Date of Birth

    public PracticeFormPage selectDateOfBirth(String date) {
        String[] dateParts = date.split(" ");
        String month = dateParts[0];
        String year = dateParts[1];
        String day = dateParts[2];
        dateOfBirthCalendarInput.click();
        WebElement monthSelectAfterWait = defaultWait.until(ExpectedConditions.elementToBeClickable(monthSelect));
        Select selectMonth = new Select(monthSelectAfterWait);
        selectMonth.selectByVisibleText(month);
        Select selectYear = new Select(yearSelect);
        selectYear.selectByValue(year);
        String daySelectOptionXpath = daySelectXpath + "[contains(@aria-label,'" + month + "') and text()='" + day + "']";
        WebElement daySelectOptionLocator = driver.findElement(By.xpath(daySelectOptionXpath));
        daySelectOptionLocator.click();
        return this;
    }

    public String convertDateOfBirthForSummaryTable(String date) {
        String[] dateParts = date.split(" ");
        String month = dateParts[0];
        String year = dateParts[1];
        String day = dateParts[2];
        DecimalFormat dayFormat = new DecimalFormat("00");
        String formattedDay = dayFormat.format(Integer.parseInt(day));
        String formattedDate = formattedDay + " " + month + "," + year;
        return formattedDate;
    }

    // Subjects

    public PracticeFormPage writeSubjects(List<String> subjectList) {
        subjectsAutoCompleteInput.click();
        for (String subject : subjectList) {
            subjectsAutoCompleteInput.sendKeys(subject);
            subjectsAutoCompleteInput.sendKeys(Keys.ENTER);
        }
        return this;
    }

    public String convertSubjectsForSummaryTable(List<String> subjectList) {
        String formattedSubjects = String.join(", ", subjectList);
        return formattedSubjects;
    }

    // Hobbies

    public PracticeFormPage checkHobbyCheckboxes(List<String> hobbyList) {
        if (hobbyList.contains("Sports")) {
            hobbiesSportsCheckbox.click();
        }
        if (hobbyList.contains("Reading")) {
            hobbiesReadingCheckbox.click();
        }
        if (hobbyList.contains("Music")) {
            hobbiesMusicCheckbox.click();
        }
        return this;
    }

    public String convertHobbiesForSummaryTable(List<String> hobbyList) {
        String formattedHobbies = String.join(", ", hobbyList);
        return formattedHobbies;
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

    public String convertCurrentAddressForSummaryTable(String currentAddress) {
        String formattedCurrentAddress = currentAddress.replace("\n", " ");
        return formattedCurrentAddress;
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
        citySelect.click();
        String citySelectOptionXpath = citySelectXpath + "//div[text()='" + city + "']";
        WebElement citySelectOptionLocator = driver.findElement(By.xpath(citySelectOptionXpath));
        WebElement citySelectOption = defaultWait.until(ExpectedConditions.elementToBeClickable(citySelectOptionLocator));
        citySelectOption.click();
        return this;
    }

    // Submit

    public PracticeFormPage clickSubmit() {
        submitButton.click();
        defaultWait.until(ExpectedConditions.visibilityOfAllElements(labelColumn));
        return this;
    }

    // SUMMARY TABLE

    public PracticeFormPage clickCloseSummaryTable() {
        closeSummaryTableButton.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getGenderMaleRadioButton() {
        return genderMaleRadioButton;
    }

    public WebElement getGenderFemaleRadioButton() {
        return genderFemaleRadioButton;
    }

    public WebElement getGenderOtherRadioButton() {
        return genderOtherRadioButton;
    }

    public WebElement getMobileNumberInput() {
        return mobileNumberInput;
    }

    public WebElement getDateOfBirthCalendarInput() {
        return dateOfBirthCalendarInput;
    }

    public WebElement getSubjectsAutoCompleteInput() {
        return subjectsAutoCompleteInput;
    }

    public List<WebElement> getSubjectsAutoCompleteInputClearButton() {
        return subjectsAutoCompleteInputClearButton;
    }

    public WebElement getHobbiesSportsCheckbox() {
        return hobbiesSportsCheckbox;
    }

    public WebElement getHobbiesReadingCheckbox() {
        return hobbiesReadingCheckbox;
    }

    public WebElement getHobbiesMusicCheckbox() {
        return hobbiesMusicCheckbox;
    }

    public WebElement getUploadPictureLabel() {
        return uploadPictureLabel;
    }

    public WebElement getCurrentAddressTextAreaInput() {
        return currentAddressTextAreaInput;
    }

    public WebElement getStateSelect() {
        return stateSelect;
    }

    public WebElement getStateSelectWithDefaultValue() {
        return stateSelectWithDefaultValue;
    }

    public WebElement getCitySelect() {
        return citySelect;
    }

    public WebElement getCitySelectWithDefaultValue() {
        return citySelectWithDefaultValue;
    }

    // SUMMARY TABLE

    public List<WebElement> getLabelColumnCells() {
        return labelColumn;
    }

    public List<WebElement> getValuesColumnCells() {
        return valuesColumn;
    }
}
