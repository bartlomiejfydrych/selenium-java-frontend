package tools_qa.tests.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.elements_pages.ElementsPage;
import tools_qa.pages.normal.elements_pages.RadioButtonPage;

import static org.assertj.core.api.Assertions.assertThat;

public class RadioButtonTest extends TestBase {

    private HomePage homePage;
    private TrainingPage trainingPage;
    private ElementsPage elementsPage;
    private RadioButtonPage radioButtonPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        elementsPage = new ElementsPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToRadioButtonPage() {
        homePage.goToElementsPage();
        trainingPage.removeFooterAndAds();
        elementsPage.goToRadioButtonPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldCheckYesRadioButton() {

        // -------
        // ARRANGE
        // -------

        String expectedText = "Yes";

        // ---
        // ACT
        // ---

        navigateToRadioButtonPage();
        radioButtonPage.clickYesRadioButton();

        // ------
        // ASSERT
        // ------

        assertThat(radioButtonPage.getYesRadioButton().isSelected()).isTrue();
        assertThat(radioButtonPage.getConfirmationText().getText()).isEqualTo(expectedText);
    }

    @Test
    public void shouldCheckImpressiveRadioButton() {

        // -------
        // ARRANGE
        // -------

        String expectedText = "Impressive";

        // ---
        // ACT
        // ---

        navigateToRadioButtonPage();
        radioButtonPage.clickImpressiveRadioButton();

        // ------
        // ASSERT
        // ------

        assertThat(radioButtonPage.getImpressiveRadioButton().isSelected()).isTrue();
        assertThat(radioButtonPage.getConfirmationText().getText()).isEqualTo(expectedText);
    }

    @Test
    public void shouldNotCheckNoRadioButton() {

        // ---
        // ACT
        // ---

        navigateToRadioButtonPage();

        // ------
        // ASSERT
        // ------

        boolean isDisabled = radioButtonPage.getNoRadioButton().getDomProperty("disabled") != null;
        assertThat(isDisabled).isTrue();
    }
}
