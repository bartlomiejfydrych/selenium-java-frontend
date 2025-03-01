package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.models_providers.podstawy_models.PodstawyFormProvider;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.OknaZakladkiPage;
import testerczaki.pages.normal.PodstawyPage;

import static org.assertj.core.api.Assertions.assertThat;

public class OknaZakladkiTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/okna

    private HomePage homePage;
    private PodstawyPage podstawyPage;
    private OknaZakladkiPage oknaZakladkiPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        podstawyPage = new PodstawyPage(driver);
        oknaZakladkiPage = new OknaZakladkiPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void fillPodstawyPageForm() {
        PodstawyForm podstawyForm = PodstawyFormProvider.getRandomPodstawyForm();
        podstawyPage.writeImie(podstawyForm.getImie())
                .writeNazwisko(podstawyForm.getNazwisko())
                .writeEmail(podstawyForm.getEmail())
                .writeMiasto(podstawyForm.getMiasto())
                .writeUlica(podstawyForm.getUlica())
                .checkRegulaminCheckbox()
                .clickWyslijButton();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldFillPodstawyFormCorrectlyInNewTab() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Wszystkie pola zostały wypełnione prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToOknaZakladkiPage();
        oknaZakladkiPage.clickPodstawyNewTab();
        oknaZakladkiPage.switchTabOrWindow(1);
        fillPodstawyPageForm();

        // ------
        // ASSERT
        // ------

        assertThat(podstawyPage.getGratulacjeAlert().isDisplayed()).isTrue();
        assertThat(podstawyPage.getGratulacjeAlert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void shouldFillPodstawyFormCorrectlyInNewWindow() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Wszystkie pola zostały wypełnione prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToOknaZakladkiPage();
        oknaZakladkiPage.clickPodstawyNewWindow();
        oknaZakladkiPage.switchTabOrWindowAndMaximize(1);
        fillPodstawyPageForm();

        // ------
        // ASSERT
        // ------

        assertThat(podstawyPage.getGratulacjeAlert().isDisplayed()).isTrue();
        assertThat(podstawyPage.getGratulacjeAlert().getText()).isEqualTo(expectedMessage);
    }
}
