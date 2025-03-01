package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.models_providers.podstawy_models.PodstawyFormProvider;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.UkryteElementyPage;

import static org.assertj.core.api.Assertions.assertThat;

public class UkryteElementyTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/ukryte

    private HomePage homePage;
    private UkryteElementyPage ukryteElementyPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        ukryteElementyPage = new UkryteElementyPage(driver);
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

        homePage.goToUkryteElementyPage();
        ukryteElementyPage.fillForm(podstawyForm)
                .checkRegulaminCheckbox()
                .clickWyslijButton();

        // ------
        // ASSERT
        // ------

        assertThat(ukryteElementyPage.getGratulacjeAlert().isDisplayed()).isTrue();
        assertThat(ukryteElementyPage.getGratulacjeAlert().getText()).isEqualTo(expectedMessage);
    }
}
