package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.podstawy_models.PodstawyForm;
import testerczaki.models_providers.podstawy_models.PodstawyFormProvider;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.PodstawyPage;
import testerczaki.pages.normal.WiecejRamekPage;

import static org.assertj.core.api.Assertions.assertThat;

public class WiecejRamekTest extends TestBase {

    private HomePage homePage;
    private PodstawyPage podstawyPage;
    private WiecejRamekPage wiecejRamekPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        podstawyPage = new PodstawyPage(driver);
        wiecejRamekPage = new WiecejRamekPage(driver);
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

        homePage.goToWiecejRamekPage();
        wiecejRamekPage.switchToIframe2();
        podstawyPage.writeImie(podstawyForm.getImie())
                .writeNazwisko(podstawyForm.getNazwisko());
        wiecejRamekPage.switchToIframe3();
        podstawyPage.writeEmail(podstawyForm.getEmail());
        wiecejRamekPage.switchToParentFrame()
                .switchToIframe4();
        podstawyPage.writeMiasto(podstawyForm.getMiasto());
        wiecejRamekPage.switchToDefaultContent()
                .switchToIframe5();
        podstawyPage.writeUlica(podstawyForm.getUlica());
        wiecejRamekPage.switchToDefaultContent();
        podstawyPage.checkRegulaminCheckbox()
                .clickWyslijButton();

        // ------
        // ASSERT
        // ------

        assertThat(podstawyPage.getGratulacjeAlert().isDisplayed()).isTrue();
        assertThat(podstawyPage.getGratulacjeAlert().getText()).isEqualTo(expectedMessage);
    }
}
