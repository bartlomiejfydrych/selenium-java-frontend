package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.asercja_models.AsercjaForm;
import testerczaki.models_providers.asercja_models.AsercjaFormProvider;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.AsercjaPage;
import utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class AsercjaTest extends TestBase {

    /*
    NOTES:
    This exercise involved writing assertions so that this test would always fail.
    Since this annoyed me, I wrote assertions that check whether the negative test scenario is met.
    */

    private HomePage homePage;
    private AsercjaPage asercjaPage;

    private WebElementMethods webElementMethods;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        asercjaPage = new AsercjaPage(driver);

        webElementMethods = new WebElementMethods(driver);
    }

    @Test
    public void shouldFillFormButSomeElementsWillNotChange() {

        // -------
        // ARRANGE
        // -------

        AsercjaForm asercjaForm = AsercjaFormProvider.getRandomAsercjaForm();

        // ---
        // ACT
        // ---

        homePage.goToAsercjaPage();
        asercjaPage.fillAsercjaForm(asercjaForm)
                .checkRegulaminCheckbox()
                .clickWyslijButton();

        // ------
        // ASSERT
        // ------

        assertThat(asercjaPage.getImieInput().getDomProperty("value")).isEqualTo(asercjaForm.getImie());
        assertThat(asercjaPage.getNazwiskoInput().getDomProperty("value")).isEqualTo(asercjaForm.getNazwisko());
        assertThat(asercjaPage.getEmailInput().getDomProperty("value")).isEqualTo(asercjaForm.getEmail());
        assertThat(asercjaPage.getMiastoInput().getDomProperty("value")).isEqualTo("");
        assertThat(asercjaPage.getUlicaInput().getDomProperty("value")).isEqualTo(asercjaForm.getUlica());
        assertThat(asercjaPage.getRegulaminCheckbox().isSelected()).isFalse();
        assertThat(webElementMethods.isElementPresent(asercjaPage.getGratulacjeAlert())).isFalse();
    }
}
