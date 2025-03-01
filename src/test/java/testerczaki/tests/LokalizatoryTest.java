package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.wiecej_elementow_models.WiecejElementowForm;
import testerczaki.models_providers.wiecej_elementow_models.WiecejElementowProvider;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.LokalizatoryPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LokalizatoryTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/lokalizatory

    private HomePage homePage;
    private LokalizatoryPage lokalizatoryPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        lokalizatoryPage = new LokalizatoryPage(driver);
    }

    @Test
    public void shouldFillFormCorrectly() {

        // -------
        // ARRANGE
        // -------

        WiecejElementowForm wiecejElementowForm = WiecejElementowProvider.getRandomWiecejElementowForm();
        String expectedMessage = "Wszystkie pola zostały wypełnione prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToLokalizatoryPage();
        lokalizatoryPage.fillForm(wiecejElementowForm)
                .checkRegulaminCheckbox()
                .clickWyslijButton();

        // ------
        // ASSERT
        // ------

        assertThat(lokalizatoryPage.getGratulacjeAlert().isDisplayed()).isTrue();
        assertThat(lokalizatoryPage.getGratulacjeAlert().getText()).isEqualTo(expectedMessage);
    }
}
