package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.models_providers.podstawy_models.PodstawyFormProvider;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.PodstawyPage;
import testerczaki.pages.normal.RamkaPage;

import static org.assertj.core.api.Assertions.assertThat;

public class RamkaTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/ramka

    private HomePage homePage;
    private PodstawyPage podstawyPage;
    private RamkaPage ramkaPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        podstawyPage = new PodstawyPage(driver);
        ramkaPage = new RamkaPage(driver);
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

        homePage.goToRamkaPage();
        ramkaPage.switchToIframe1();
        podstawyPage.fillForm(podstawyForm)
                .checkRegulaminCheckbox()
                .clickWyslijButton();

        // ------
        // ASSERT
        // ------

        assertThat(podstawyPage.getGratulacjeAlert().isDisplayed()).isTrue();
        assertThat(podstawyPage.getGratulacjeAlert().getText()).isEqualTo(expectedMessage);

        // -----------------------
        // BACK TO DEFAULT CONTENT
        // -----------------------

        ramkaPage.switchToDefaultContent();
    }
}
