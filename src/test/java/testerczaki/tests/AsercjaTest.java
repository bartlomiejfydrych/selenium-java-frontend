package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.models_providers.podstawy_models.PodstawyFormProvider;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.AsercjaPage;
import testerczaki.pages.normal.PodstawyPage;
import utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class AsercjaTest extends TestBase {

    /*
    NOTES:
    This page uses the same elements and methods as the 'PodstawyPage'.
    This exercise involved writing assertions so that this test would always fail.
    Since this annoyed me, I wrote assertions that check whether the negative test scenario is met.
    */

    private HomePage homePage;
    private PodstawyPage podstawyPage;
    private AsercjaPage asercjaPage;

    private WebElementMethods webElementMethods;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        podstawyPage = new PodstawyPage(driver);
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
        asercjaPage.checkRegulaminCheckbox();
        podstawyPage.fillForm(podstawyForm)
                .clickWyslijButton();

        // ------
        // ASSERT
        // ------

        assertThat(podstawyPage.getImieInput().getDomProperty("value")).isEqualTo(podstawyForm.getImie());
        assertThat(podstawyPage.getNazwiskoInput().getDomProperty("value")).isEqualTo(podstawyForm.getNazwisko());
        assertThat(podstawyPage.getEmailInput().getDomProperty("value")).isEqualTo(podstawyForm.getEmail());
        assertThat(podstawyPage.getMiastoInput().getDomProperty("value")).isEqualTo("");
        assertThat(podstawyPage.getUlicaInput().getDomProperty("value")).isEqualTo(podstawyForm.getUlica());
        assertThat(asercjaPage.getRegulaminCheckbox().isSelected()).isFalse();
        assertThat(webElementMethods.isElementPresent(podstawyPage.getGratulacjeAlert())).isFalse();
    }
}
