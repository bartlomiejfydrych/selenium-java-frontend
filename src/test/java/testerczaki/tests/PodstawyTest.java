package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.models_providers.podstawy_models.PodstawyFormProvider;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.PodstawyPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PodstawyTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/podstawy

    private HomePage homePage;
    private PodstawyPage podstawyPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        podstawyPage = new PodstawyPage(driver);
    }

    @Test
    public void shouldFillFormCorrectly() {

        // -------
        // ARRANGE
        // -------

        PodstawyForm podstawyForm = PodstawyFormProvider.getRandomPodstawyForm();
        String expectedMessage = "Wszystkie pola zostały wypełnione prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToPodstawyPage();
        podstawyPage.fillForm(podstawyForm)
                .checkRegulaminCheckbox()
                .clickWyslijButton();

        // ------
        // ASSERT
        // ------

        assertThat(podstawyPage.getGratulacjeAlert().isDisplayed()).isTrue();
        assertThat(podstawyPage.getGratulacjeAlert().getText()).isEqualTo(expectedMessage);
    }
}
