package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.models_providers.podstawy_models.PodstawyFormProvider;
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

        PodstawyForm podstawyForm = PodstawyFormProvider.getRandomPodstawyForm();

        // ---
        // ACT
        // ---

        homePage.goToAsercjaPage();
        asercjaPage.fillForm(podstawyForm)
                .checkRegulaminCheckbox()
                .clickWyslijButton();

        // ------
        // ASSERT
        // ------

        assertThat(asercjaPage.getImieInput().getDomProperty("value")).isEqualTo(podstawyForm.getImie());
        assertThat(asercjaPage.getNazwiskoInput().getDomProperty("value")).isEqualTo(podstawyForm.getNazwisko());
        assertThat(asercjaPage.getEmailInput().getDomProperty("value")).isEqualTo(podstawyForm.getEmail());
        assertThat(asercjaPage.getMiastoInput().getDomProperty("value")).isEqualTo("");
        assertThat(asercjaPage.getUlicaInput().getDomProperty("value")).isEqualTo(podstawyForm.getUlica());
        assertThat(asercjaPage.getRegulaminCheckbox().isSelected()).isFalse();
        assertThat(webElementMethods.isElementPresent(asercjaPage.getGratulacjeAlert())).isFalse();
    }
}
