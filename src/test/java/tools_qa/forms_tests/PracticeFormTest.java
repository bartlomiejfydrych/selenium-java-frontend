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

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PracticeFormTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    FormsPage formsPage;
    PracticeFormPage practiceFormPage;
    List<String> summaryTableLabelList = Arrays.asList(
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
    }

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

        homePage.goToFormsPage();

        trainingPage.removeAdFrameAndFooter();

        formsPage.goToPracticeFormPage();

        practiceFormPage.fillForm(practiceFormData)
                .clickSubmit();

        // ------
        // ASSERT
        // ------

        // Label column
        List<WebElement> labelColumnCells = practiceFormPage.getLabelColumnCells();
        assertThat(labelColumnCells.get(0).getText()).isEqualTo(summaryTableLabelList.get(0));
        assertThat(labelColumnCells.get(1).getText()).isEqualTo(summaryTableLabelList.get(1));
        assertThat(labelColumnCells.get(2).getText()).isEqualTo(summaryTableLabelList.get(2));
        assertThat(labelColumnCells.get(3).getText()).isEqualTo(summaryTableLabelList.get(3));
        assertThat(labelColumnCells.get(4).getText()).isEqualTo(summaryTableLabelList.get(4));
        assertThat(labelColumnCells.get(5).getText()).isEqualTo(summaryTableLabelList.get(5));
        assertThat(labelColumnCells.get(6).getText()).isEqualTo(summaryTableLabelList.get(6));
        assertThat(labelColumnCells.get(7).getText()).isEqualTo(summaryTableLabelList.get(7));
        assertThat(labelColumnCells.get(8).getText()).isEqualTo(summaryTableLabelList.get(8));
        assertThat(labelColumnCells.get(9).getText()).isEqualTo(summaryTableLabelList.get(9));

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

        homePage.goToFormsPage();

        trainingPage.removeAdFrameAndFooter();

        formsPage.goToPracticeFormPage();

        practiceFormPage.fillFormOnlyRequiredData(practiceFormData)
                .clickSubmit();

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
}
