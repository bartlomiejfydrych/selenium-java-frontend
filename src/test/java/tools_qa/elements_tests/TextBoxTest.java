package tools_qa.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.models.TextBoxForm;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.elements_pages.ElementsPage;
import tools_qa.pages.normal.elements_pages.TextBoxPage;
import tools_qa.providers.TextBoxFormProvider;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TextBoxTest extends TestBase {

    private HomePage homePage;
    private TrainingPage trainingPage;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage(driver);
    }

    @Test
    public void shouldFillTextBoxes() {

        // -------
        // ARRANGE
        // -------

        TextBoxForm textBoxForm = TextBoxFormProvider.getRandomTextBoxForm();
        String expectedFullNameParagraph = "Name:" + textBoxForm.getFullName();
        String expectedEmailParagraph = "Email:" + textBoxForm.getEmail();
        String expectedCurrentAddressParagraph = "Current Address :" + textBoxForm.getCurrentAddress().replace("\n", " ");
        String expectedPermanentAddressParagraph = "Permananet Address :" + textBoxForm.getPermanentAddress().replace("\n", " ");

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();
        trainingPage.removeFooterAndAds();
        elementsPage.goToTextBoxPage();
        textBoxPage.fillTextBoxForm(textBoxForm)
                .clickSubmit();

        // ------
        // ASSERT
        // ------

        assertThat(textBoxPage.getFullNameParagraph().getText()).isEqualTo(expectedFullNameParagraph);
        assertThat(textBoxPage.getEmailParagraph().getText()).isEqualTo(expectedEmailParagraph);
        assertThat(textBoxPage.getCurrentAddressParagraph().getText()).isEqualTo(expectedCurrentAddressParagraph);
        assertThat(textBoxPage.getPermanentAddressParagraph().getText()).isEqualTo(expectedPermanentAddressParagraph);
    }
}
