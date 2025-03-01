package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.wiecej_elementow_models.WiecejElementowForm;
import testerczaki.models_providers.wiecej_elementow_models.WiecejElementowProvider;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.WiecejElementowPage;

import static org.assertj.core.api.Assertions.assertThat;

public class WiecejElementowTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/wiecej

    private HomePage homePage;
    private WiecejElementowPage wiecejElementowPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        wiecejElementowPage = new WiecejElementowPage(driver);
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

        homePage.goToWiecejElementowPage();
        wiecejElementowPage.fillForm(wiecejElementowForm)
                .checkRegulaminCheckbox()
                .clickWyslijButton();

        // ------
        // ASSERT
        // ------

        assertThat(wiecejElementowPage.getGratulacjeAlert().isDisplayed()).isTrue();
        assertThat(wiecejElementowPage.getGratulacjeAlert().getText()).isEqualTo(expectedMessage);
    }
}
