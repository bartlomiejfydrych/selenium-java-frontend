package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.KomunikatyPage;

import static org.assertj.core.api.Assertions.assertThat;

public class KomunikatyTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/komunikaty

    private HomePage homePage;
    private KomunikatyPage komunikatyPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        komunikatyPage = new KomunikatyPage(driver);
    }

    @Test
    public void shouldWriteCorrectAlertMessage() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Wszystkie pola zostały wypełnione prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToKomunikatyPage();
        komunikatyPage.clickWyswietlKomunikatButton();
        String alertMessage = komunikatyPage.getAlertText();
        komunikatyPage.acceptAlert()
                .writeKomunikat(alertMessage)
                .clickSprawdzButton()
                .acceptAlert()
                .dismissAlert()
                .writeTextInAlertAndAccept("tak");

        // ------
        // ASSERT
        // ------

        assertThat(komunikatyPage.getGratulacjeAlert().isDisplayed()).isTrue();
        assertThat(komunikatyPage.getGratulacjeAlert().getText()).isEqualTo(expectedMessage);
    }
}
