package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.KliknijPrzytrzymajPage;

import static org.assertj.core.api.Assertions.assertThat;

public class KliknijPrzytrzymajTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/mysz

    private HomePage homePage;
    private KliknijPrzytrzymajPage kliknijPrzytrzymajPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        kliknijPrzytrzymajPage = new KliknijPrzytrzymajPage(driver);
    }

    @Test
    public void z1ShouldCorrectlyRightClickAndClickOpcja2() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToKliknijPrzytrzymajPage();
        kliknijPrzytrzymajPage.z1ClickRightKliknijTutajButton()
                .z1ClickOpcja2Button();

        // ------
        // ASSERT
        // ------

        assertThat(kliknijPrzytrzymajPage.getZ1Alert().isDisplayed()).isTrue();
        assertThat(kliknijPrzytrzymajPage.getZ1Alert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void z2ShouldCorrectlyClickAndHoldFor3Seconds() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToKliknijPrzytrzymajPage();
        kliknijPrzytrzymajPage.z2ClickAndHoldKliknijPrzytrzymajButton();

        // ------
        // ASSERT
        // ------

        assertThat(kliknijPrzytrzymajPage.getZ2Alert().isDisplayed()).isTrue();
        assertThat(kliknijPrzytrzymajPage.getZ2Alert().getText()).isEqualTo(expectedMessage);
    }
}
