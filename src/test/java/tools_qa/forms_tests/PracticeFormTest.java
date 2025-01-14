package tools_qa.forms_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.models.PracticeForm;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.forms_pages.FormsPage;
import tools_qa.pages.normal.forms_pages.PracticeFormPage;
import tools_qa.providers.PracticeFormProvider;
import tools_qa.utils.WebElementMethods;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PracticeFormTest extends TestBase {

    private HomePage homePage;
    private TrainingPage trainingPage;
    private FormsPage formsPage;
    private PracticeFormPage practiceFormPage;

    private WebElementMethods webElementMethods;

    private  final List<String> summaryTableLabelList = Arrays.asList(
            "Student Name",
            "Student Email",
            "Gender",
            "Mobile",
            "Date of Birth",
            "Subjects",
            "Hobbies",
            "Picture",
            "Address",
            "State and City"
    );

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        formsPage = new FormsPage(driver);
        practiceFormPage = new PracticeFormPage(driver);

        webElementMethods = new WebElementMethods(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToPracticeFormPage() {
        homePage.goToFormsPage();
        trainingPage.removeFooterAndAds();
        formsPage.goToPracticeFormPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldFillFormCorrect() {

        // -------
        // ARRANGE
        // -------

        PracticeForm practiceFormData = PracticeFormProvider.getRandomPracticeForm();
        // Data formatting for summary table
        String studentName = practiceFormData.getFirstName() + " " + practiceFormData.getLastName();
        String dateOfBirth = practiceFormPage.convertDateOfBirthForSummaryTable(practiceFormData.getDateOfBirth());
        String subjects = practiceFormPage.convertSubjectsForSummaryTable(practiceFormData.getSubjectList());
        String hobbies = practiceFormPage.convertHobbiesForSummaryTable(practiceFormData.getHobbyList());
        String currentAddress = practiceFormPage.convertCurrentAddressForSummaryTable(practiceFormData.getCurrentAddress());
        String stateAndCity = practiceFormData.getState() + " " + practiceFormData.getCity();

        // ---
        // ACT
        // ---

        navigateToPracticeFormPage();
        practiceFormPage.fillForm(practiceFormData)
                .clickSubmitAndWaitForSummaryTable();

        // ------
        // ASSERT
        // ------

        // Label column
        List<WebElement> labelColumnCells = practiceFormPage.getLabelColumnCells();
        for (int i = 0; i < summaryTableLabelList.size(); i++) {
            assertThat(labelColumnCells.get(i).getText()).isEqualTo(summaryTableLabelList.get(i));
        }

        // Values column
        List<WebElement> valuesColumnCells = practiceFormPage.getValuesColumnCells();
        assertThat(valuesColumnCells.get(0).getText()).isEqualTo(studentName);
        assertThat(valuesColumnCells.get(1).getText()).isEqualTo(practiceFormData.getEmail());
        assertThat(valuesColumnCells.get(2).getText()).isEqualTo(practiceFormData.getGender());
        assertThat(valuesColumnCells.get(3).getText()).isEqualTo(practiceFormData.getMobileNumber());
        assertThat(valuesColumnCells.get(4).getText()).isEqualTo(dateOfBirth);
        assertThat(valuesColumnCells.get(5).getText()).isEqualTo(subjects);
        assertThat(valuesColumnCells.get(6).getText()).isEqualTo(hobbies);
        assertThat(valuesColumnCells.get(7).getText()).isEqualTo("PracticeFormTest_UploadPicture.png");
        assertThat(valuesColumnCells.get(8).getText()).isEqualTo(currentAddress);
        assertThat(valuesColumnCells.get(9).getText()).isEqualTo(stateAndCity);

        // -------------
        // CLOSE SUMMARY
        // -------------

        practiceFormPage.clickCloseSummaryTable();
        assertThat(practiceFormPage.getFirstNameInput().getText()).isEqualTo("");
        assertThat(practiceFormPage.getLastNameInput().getText()).isEqualTo("");
        assertThat(practiceFormPage.getEmailInput().getText()).isEqualTo("");
        assertThat(practiceFormPage.getGenderMaleRadioButton().isSelected()).isFalse();
        assertThat(practiceFormPage.getGenderFemaleRadioButton().isSelected()).isFalse();
        assertThat(practiceFormPage.getGenderOtherRadioButton().isSelected()).isFalse();
        assertThat(practiceFormPage.getMobileNumberInput().getText()).isEqualTo("");
        assertThat(practiceFormPage.getDateOfBirthCalendarInput().getText()).isEqualTo("");
        assertThat(practiceFormPage.getSubjectsAutoCompleteInputClearButton()).isEmpty();
        assertThat(practiceFormPage.getHobbiesSportsCheckbox().isSelected()).isFalse();
        assertThat(practiceFormPage.getHobbiesReadingCheckbox().isSelected()).isFalse();
        assertThat(practiceFormPage.getHobbiesMusicCheckbox().isSelected()).isFalse();
        assertThat(practiceFormPage.getUploadPictureLabel().getText()).isEqualTo("Select picture");
        assertThat(practiceFormPage.getCurrentAddressTextAreaInput().getText()).isEqualTo("");
        assertThat(practiceFormPage.getStateSelectWithDefaultValue().isDisplayed()).isTrue();
        assertThat(practiceFormPage.getCitySelectWithDefaultValue().isDisplayed()).isTrue();
    }

    @Test
    public void shouldFillFormWithOnlyRequiredData() {

        // -------
        // ARRANGE
        // -------

        PracticeForm practiceFormData = PracticeFormProvider.getRandomPracticeFormRequiredData();
        // Data formatting for summary table
        String studentName = practiceFormData.getFirstName() + " " + practiceFormData.getLastName();
        String todayFormattedDateOfBirth = practiceFormPage.getTodayDateOfBirthForSummaryTable();

        // ---
        // ACT
        // ---

        navigateToPracticeFormPage();
        practiceFormPage.fillFormOnlyRequiredData(practiceFormData)
                .clickSubmitAndWaitForSummaryTable();

        // ------
        // ASSERT
        // ------

        // Values column
        List<WebElement> valuesColumnCells = practiceFormPage.getValuesColumnCells();
        assertThat(valuesColumnCells.get(0).getText()).isEqualTo(studentName);
        assertThat(valuesColumnCells.get(1).getText()).isEqualTo("");
        assertThat(valuesColumnCells.get(2).getText()).isEqualTo(practiceFormData.getGender());
        assertThat(valuesColumnCells.get(3).getText()).isEqualTo(practiceFormData.getMobileNumber());
        assertThat(valuesColumnCells.get(4).getText()).isEqualTo(todayFormattedDateOfBirth);
        assertThat(valuesColumnCells.get(5).getText()).isEqualTo("");
        assertThat(valuesColumnCells.get(6).getText()).isEqualTo("");
        assertThat(valuesColumnCells.get(7).getText()).isEqualTo("");
        assertThat(valuesColumnCells.get(8).getText()).isEqualTo("");
        assertThat(valuesColumnCells.get(9).getText()).isEqualTo("");

        // -------------
        // CLOSE SUMMARY
        // -------------

        practiceFormPage.clickCloseSummaryTable();
    }

    @Test
    public void shouldNotAcceptEmptyFormAndMarkFields() {

        // -------
        // ARRANGE
        // -------

        String cssValue = "border-color";
        String colorRedRGB = "rgb(220, 53, 69)";
        String colorGreenRGB = "rgb(40, 167, 69)";

        // ---
        // ACT
        // ---

        navigateToPracticeFormPage();
        practiceFormPage.clickSubmit();
        webElementMethods.waitForElementToStopColorChanging(practiceFormPage.getFirstNameInput(), cssValue, 2000);

        // ------
        // ASSERT
        // ------

        // Red fields
        assertThat(practiceFormPage.getFirstNameInput().getCssValue(cssValue)).isEqualTo(colorRedRGB);
        assertThat(practiceFormPage.getLastNameInput().getCssValue(cssValue)).isEqualTo(colorRedRGB);
        assertThat(practiceFormPage.getGenderMaleRadioButton().getCssValue(cssValue)).isEqualTo(colorRedRGB);
        assertThat(practiceFormPage.getGenderFemaleRadioButton().getCssValue(cssValue)).isEqualTo(colorRedRGB);
        assertThat(practiceFormPage.getGenderOtherRadioButton().getCssValue(cssValue)).isEqualTo(colorRedRGB);
        assertThat(practiceFormPage.getMobileNumberInput().getCssValue(cssValue)).isEqualTo(colorRedRGB);

        // Green fields
        assertThat(practiceFormPage.getEmailInput().getCssValue(cssValue)).isEqualTo(colorGreenRGB);
        assertThat(practiceFormPage.getDateOfBirthCalendarInput().getCssValue(cssValue)).isEqualTo(colorGreenRGB);
        assertThat(practiceFormPage.getHobbiesSportsCheckbox().getCssValue(cssValue)).isEqualTo(colorGreenRGB);
        assertThat(practiceFormPage.getHobbiesReadingCheckbox().getCssValue(cssValue)).isEqualTo(colorGreenRGB);
        assertThat(practiceFormPage.getHobbiesMusicCheckbox().getCssValue(cssValue)).isEqualTo(colorGreenRGB);
        assertThat(practiceFormPage.getCurrentAddressTextAreaInput().getCssValue(cssValue)).isEqualTo(colorGreenRGB);
    }
}
