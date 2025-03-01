package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.models_providers.podstawy_models.PodstawyFormProvider;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.OpcjonalnyFormularzPage;

import static org.assertj.core.api.Assertions.assertThat;

public class OpcjonalnyFormularzTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/opcjonalny

    private HomePage homePage;
    private OpcjonalnyFormularzPage opcjonalnyFormularzPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        opcjonalnyFormularzPage = new OpcjonalnyFormularzPage(driver);
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

        homePage.goToOpcjonalnyFormularzPage();
        opcjonalnyFormularzPage.fillForm(podstawyForm)
                .clickWyslijButton();

        // ------
        // ASSERT
        // ------

        assertThat(opcjonalnyFormularzPage.getGratulacjeAlert().isDisplayed()).isTrue();
        assertThat(opcjonalnyFormularzPage.getGratulacjeAlert().getText()).isEqualTo(expectedMessage);
    }
}
