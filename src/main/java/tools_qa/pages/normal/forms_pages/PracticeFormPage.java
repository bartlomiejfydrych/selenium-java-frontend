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
import java.util.List;
import java.util.Random;

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
    @FindBy(css = "react-datepicker__year-select")
    private WebElement yearSelect;
    private final String daySelectXpath = "//div[@class='react-datepicker__month']/div/div[1]"; // [text()='1']
    @FindBy(xpath = daySelectXpath)
    private WebElement daySelect;
    // Subjects
    @FindBy(css = "#subjectsInput")
    private WebElement subjectsAutoCompleteInput;
    // Hobbies
    @FindBy(css = "input[type='checkbox'] + label")
    private List<WebElement> hobbiesCheckboxes;
    //    @FindBy(css = "#hobbies-checkbox-1")
//    private WebElement hobbiesSportsCheckbox;
//    @FindBy(css = "#hobbies-checkbox-2")
//    private WebElement hobbiesReadingCheckbox;
//    @FindBy(css = "#hobbies-checkbox-3")
//    private WebElement hobbiesMusicCheckbox;
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
    private final String citySelectXpath = "//div[@id='city']";
    @FindBy(xpath = citySelectXpath)
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
        clickGenderRadioButton(practiceForm.getGender());
        writeMobileNumber(practiceForm.getMobileNumber());
        // miss [Date of Birth]
        writeSubjects(practiceForm.getSubjectList());
        checkRandomHobbyCheckboxes();
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

    public PracticeFormPage selectDateOfBirth(String month, String year, String day) {
        dateOfBirthCalendarInput.click();
        WebElement monthSelectAfterWait = defaultWait.until(ExpectedConditions.elementToBeClickable(monthSelect));
        Select selectMonth = new Select(monthSelectAfterWait);
        selectMonth.selectByVisibleText(month);
        Select selectYear = new Select(yearSelect);
        selectYear.selectByValue(year);
        String daySelectOptionXpath = daySelectXpath + "[text()=`" + day + "']";
        WebElement daySelectOptionLocator = driver.findElement(By.xpath(daySelectOptionXpath));
        daySelectOptionLocator.click();
        return this;
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

    // Hobbies

    public PracticeFormPage checkRandomHobbyCheckboxes() {
        Random random = new Random();
        for (WebElement checkbox : hobbiesCheckboxes) {
            if (random.nextBoolean()) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }
        }
        return this;
    }

    // Rozważyć metody, gdybyśmy chcieli zaznaczyć tylko konktetne checkboxy

//    public PracticeFormPage checkHobbySports() {
//        hobbiesSportsCheckbox.click();
//        return this;
//    }
//
//    public PracticeFormPage checkHobbyReading() {
//        hobbiesReadingCheckbox.click();
//        return this;
//    }
//
//    public PracticeFormPage checkHobbyMusic() {
//        hobbiesMusicCheckbox.click();
//        return this;
//    }

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
        return this;
    }

    // -------
    // GETTERS
    // -------

}
