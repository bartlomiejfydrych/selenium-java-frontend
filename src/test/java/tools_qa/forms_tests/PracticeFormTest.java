package tools_qa.forms_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.models.PracticeForm;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.forms_pages.FormsPage;
import tools_qa.pages.normal.forms_pages.PracticeFormPage;
import tools_qa.providers.PracticeFormProvider;

public class PracticeFormTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    FormsPage formsPage;
    PracticeFormPage practiceFormPage;

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

        // ---
        // ACT
        // ---

        homePage.goToFormsPage();

        trainingPage.removeAdFrameAndFooter();

        formsPage.goToPracticeFormPage();

        practiceFormPage.fillForm(practiceFormData);


        // Zrobić metodę zapisującą, które checkboxy zostały zaznaczone

        // ------
        // ASSERT
        // ------
    }
}
